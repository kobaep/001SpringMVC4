package com.psk.web;

import com.psk.domain.*;
import com.psk.manager.AppUserManager;
import com.psk.manager.MaterialTypeManager;
import com.psk.manager.MatterManager;
import com.psk.service.MaterialTypeService;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apichat on 3/11/2016 AD.
 */
@Controller
public class MtmsControllerJson {

    private final Logger logger = LoggerFactory.getLogger(MtmsControllerJson.class);

    @Autowired
    private MaterialTypeManager materialTypeManager;

    @Autowired
    private MatterManager matterManager;

    @Autowired
    private AppUserManager appUserManager;

    @RequestMapping(value = "/materialTypePrivate/createMaterialType", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> materialTypeCreate(@RequestParam("data") String data, Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            AppUser appUser = appUserManager.findAppUserByName(principal.getName());

            JSONObject jsonObject = new JSONObject(data);

            MaterialType materialType = new MaterialType();
            materialType.setCreateDate(new Date());
            materialType.setCreateBy(appUser);
            materialType.setTypeName(jsonObject.getString("inputMaterialType"));

            materialTypeManager.insertMaterialType(materialType);
            return new ResponseEntity<String>("{\"create\":true}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/materialPrivate/create", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> createMatter(HttpServletRequest request,MultipartHttpServletRequest multipartHttpServletRequest, Principal principal) throws IOException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            AppUser appUser = appUserManager.findAppUserByName(principal.getName());
            MaterialType materialType = materialTypeManager.findMaterialType(Long.parseLong(multipartHttpServletRequest.getParameter("id")));

            MultipartFile spec = multipartHttpServletRequest.getFile("inputSpec");
            MultipartFile rohs = multipartHttpServletRequest.getFile("inputRoHs");
            MultipartFile msds = multipartHttpServletRequest.getFile("inputMSDS");
            MultipartFile halogen = multipartHttpServletRequest.getFile("inputHalogen");

            String dateSpec = multipartHttpServletRequest.getParameter("inputDateSpec");
            String dateRohs = multipartHttpServletRequest.getParameter("inputDateRoHs");
            String dateMsds = multipartHttpServletRequest.getParameter("inputDateMSDS");
            String dateHalogen = multipartHttpServletRequest.getParameter("inputDateHF");

            Set<Matter> matters = new HashSet<Matter>();
            Matter matter = new Matter();

            matter.setMaterialName(multipartHttpServletRequest.getParameter("inputMaterialName"));
            matter.setUlNumber(multipartHttpServletRequest.getParameter("inputUlNumber"));
            matter.setManufacturing(multipartHttpServletRequest.getParameter("inputManufacturing"));

            uploadFile(spec, rohs, msds, halogen, dateSpec, dateRohs, dateMsds, dateHalogen, materialType, request, matter);

            matter.setCreateBy(appUser);
            matter.setCreateDate(new Date());
            matter.setStatus("CREATE");
            matter.setFolw("qa");

            Set<DocumentHistory> documentHistories = new HashSet<DocumentHistory>();
            DocumentHistory documentHistory = new DocumentHistory();
            documentHistory.setCreateBy(appUser);
            documentHistory.setCreateDate(new Date());
            documentHistory.setActionType("CREATE");
            documentHistory.setRemark("create material");
            documentHistory.setStatus("CREATE");
            documentHistory.setMatter(matter);
            documentHistories.add(documentHistory);

            matter.setDocumentHistorys(documentHistories);
            matter.setMaterialType(materialType);

            matters.add(matter);

            materialType.setMatters(matters);

            materialTypeManager.insertMaterialType(materialType);

            return new ResponseEntity<String>("{\"create\":true}", headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/materialPrivate/update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> updateMatter(@RequestParam("data") String data, Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            AppUser appUser = appUserManager.findAppUserByName(principal.getName());
            JSONObject jsonObject = new JSONObject(data);

            Matter matter = matterManager.findMatter(jsonObject.getLong("inputId"));
            matter.setUpdateBy(appUser);
            matter.setStatus(jsonObject.getString("action"));

            Set<DocumentHistory> documentHistories = matter.getDocumentHistorys();
            DocumentHistory documentHistory = new DocumentHistory();
            documentHistory.setStatus(jsonObject.getString("action"));
            documentHistory.setCreateBy(appUser);
            documentHistory.setCreateDate(new Date());
            documentHistory.setActionType(jsonObject.getString("action"));
            documentHistory.setMatter(matter);
            documentHistories.add(documentHistory);

            matter.setDocumentHistorys(documentHistories);

            matterManager.insertMatter(matter);

            return new ResponseEntity<String>("{\"create\":true}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/materialSapPrivate/createMaterialSap", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> materialSapCreate(@RequestParam("data") String data, Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            AppUser appUser = appUserManager.findAppUserByName(principal.getName());

            JSONObject jsonObject = new JSONObject(data);
            Matter matter = matterManager.findMatter(jsonObject.getLong("inputMaterialId"));
            Set<MaterialCode> materialCodes = matter.getMaterialCodes();
            MaterialCode materialCode = new MaterialCode();
            materialCode.setCodeName(jsonObject.getString("inputSapCode"));
            materialCode.setCreateDate(new Date());
            materialCode.setUpdateDate(new Date());
            materialCode.setMatter(matter);
            materialCode.setUpdateBy(appUser);
            materialCodes.add(materialCode);
            matterManager.insertMatter(matter);

            return new ResponseEntity<String>("{\"create\":true}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void uploadFile(MultipartFile spec, MultipartFile rohs, MultipartFile msds, MultipartFile halogen,
                            String dateSpec, String dateMsds, String dateRohs, String dateHalogen,
                            MaterialType materialType, HttpServletRequest request, Matter matter) throws IOException{
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String path = request.getRealPath("./resources/filePDF/");
        try {
            if(spec != null) {
                String url = "/" +materialType.getTypeName() +"/SPEC/" + matter.getMaterialName() + "/" + spec.getOriginalFilename();
                File convFile = new File(path + url);
                convFile.getParentFile().mkdirs();
                matter.setSpec(url);
                matter.setSpecDateTest(df.parse(dateSpec));

                FileOutputStream fos = new FileOutputStream(convFile);
                fos.write(spec.getBytes());
                fos.close();
            }
            if(rohs != null) {
                String url = "/" +materialType.getTypeName() +"/ROHS/" + matter.getMaterialName() + "/" + rohs.getOriginalFilename();
                File convFile = new File(path + url);
                convFile.getParentFile().mkdirs();
                matter.setRohs(url);
                matter.setRohsDateTest(df.parse(dateRohs));

                FileOutputStream fos = new FileOutputStream(convFile);
                fos.write(rohs.getBytes());
                fos.close();
            }
            if(msds != null) {
                String url = "/" +materialType.getTypeName() +"/MSDS/" + matter.getMaterialName() + "/" + msds.getOriginalFilename();
                File convFile = new File(path + url);
                convFile.getParentFile().mkdirs();
                matter.setMsds(url);
                matter.setMsdsDateTest(df.parse(dateMsds));

                FileOutputStream fos = new FileOutputStream(convFile);
                fos.write(msds.getBytes());
                fos.close();
            }
            if(halogen != null) {
                String url = "/" +materialType.getTypeName() +"/HALOGEN/" + matter.getMaterialName() + "/" + halogen.getOriginalFilename();
                File convFile = new File(path + url);
                convFile.getParentFile().mkdirs();
                matter.setHalogen(url);
                matter.setHalogenDateTest(df.parse(dateHalogen));

                FileOutputStream fos = new FileOutputStream(convFile);
                fos.write(halogen.getBytes());
                fos.close();
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

}
