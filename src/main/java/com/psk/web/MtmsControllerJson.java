package com.psk.web;

import com.psk.domain.*;
import com.psk.manager.AppUserManager;
import com.psk.manager.MaterialCodeManager;
import com.psk.manager.MaterialTypeManager;
import com.psk.manager.MatterManager;
import com.psk.service.MaterialTypeService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
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
import java.util.*;

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

    @Autowired
    private MaterialCodeManager materialCodeManager;

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

            String dateRohs = multipartHttpServletRequest.getParameter("inputDateRoHs");
            String dateHalogen = multipartHttpServletRequest.getParameter("inputDateHF");

            Set<Matter> matters = new HashSet<Matter>();
            Matter matter = new Matter();

            matter.setMaterialName(multipartHttpServletRequest.getParameter("inputMaterialName"));
            matter.setUlNumber(multipartHttpServletRequest.getParameter("inputUlNumber"));
            matter.setManufacturing(multipartHttpServletRequest.getParameter("inputManufacturing"));

            uploadFile(spec, rohs, msds, halogen, dateRohs, dateHalogen, materialType, request, matter);

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
            matter.setReason(jsonObject.getString("reason"));
            Set<DocumentHistory> documentHistories = matter.getDocumentHistorys();
            DocumentHistory documentHistory = new DocumentHistory();
            documentHistory.setStatus(jsonObject.getString("action"));
            documentHistory.setCreateBy(appUser);
            documentHistory.setCreateDate(new Date());
            documentHistory.setRemark(jsonObject.getString("reason"));
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

    @RequestMapping(value = "/materialPrivate/remove", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> removeMatter(@RequestParam("data") String data, Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            AppUser appUser = appUserManager.findAppUserByName(principal.getName());
            JSONObject jsonObject = new JSONObject(data);

            Matter matter = matterManager.findMatter(jsonObject.getLong("inputId"));
            matter.setUpdateBy(appUser);
            matter.setStatus(jsonObject.getString("action"));
            matter.setReason(jsonObject.getString("reason"));
            Set<DocumentHistory> documentHistories = matter.getDocumentHistorys();
            DocumentHistory documentHistory = new DocumentHistory();
            documentHistory.setStatus(jsonObject.getString("action"));
            documentHistory.setCreateBy(appUser);
            documentHistory.setCreateDate(new Date());
            documentHistory.setRemark(jsonObject.getString("reason"));
            documentHistory.setActionType(jsonObject.getString("action"));
            documentHistory.setMatter(matter);
            documentHistories.add(documentHistory);

            matter.setDocumentHistorys(documentHistories);

            matterManager.insertMatter(matter);
            return new ResponseEntity<String>("{\"create\":true}", headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/materialPrivate/updateAll", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> updateAllMatter(HttpServletRequest request,MultipartHttpServletRequest multipartHttpServletRequest, Principal principal) throws IOException{
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            AppUser appUser = appUserManager.findAppUserByName(principal.getName());

            Matter matter = matterManager.findMatter(Long.parseLong(multipartHttpServletRequest.getParameter("id")));

            MultipartFile spec = multipartHttpServletRequest.getFile("inputSpec");
            MultipartFile rohs = multipartHttpServletRequest.getFile("inputRoHs");
            MultipartFile msds = multipartHttpServletRequest.getFile("inputMSDS");
            MultipartFile halogen = multipartHttpServletRequest.getFile("inputHalogen");

            String dateRohs = multipartHttpServletRequest.getParameter("inputDateRoHs");
            String dateHalogen = multipartHttpServletRequest.getParameter("inputDateHF");

            matter.setMaterialName(multipartHttpServletRequest.getParameter("inputMaterialName"));
            matter.setUlNumber(multipartHttpServletRequest.getParameter("inputUlNumber"));
            matter.setManufacturing(multipartHttpServletRequest.getParameter("inputManufacturing"));

            uploadFile(spec, rohs, msds, halogen, dateRohs, dateHalogen, matter.getMaterialType(), request, matter);

            matter.setUpdateBy(appUser);
            matter.setUpdateDate(new Date());
            matter.setStatus("UPDATE");
            matter.setFolw("qa");

            Set<DocumentHistory> documentHistories = matter.getDocumentHistorys();
            DocumentHistory documentHistory = new DocumentHistory();
            documentHistory.setCreateBy(appUser);
            documentHistory.setCreateDate(new Date());
            documentHistory.setActionType("UPDATE");
            documentHistory.setRemark("update material");
            documentHistory.setStatus("UPDATE");
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

    @RequestMapping(value = "/material/search", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> search(@RequestParam("data") String data, Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {

            JSONObject jsonObject = new JSONObject(data);
            MaterialCode materialCode = materialCodeManager.findMaterialCodeLink(jsonObject.getString("inputSearch"));
            JSONObject jsonObjectDataOutPut = new JSONObject();
            jsonObjectDataOutPut.put("materialType", materialCode.getMatter().getMaterialType().getTypeName());
            jsonObjectDataOutPut.put("materialName", materialCode.getMatter().getMaterialName());
            jsonObjectDataOutPut.put("id", materialCode.getMatter().getId());
            return new ResponseEntity<String>(jsonObjectDataOutPut.toString(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void uploadFile(MultipartFile spec, MultipartFile rohs, MultipartFile msds, MultipartFile halogen, String dateRohs, String dateHalogen,
                            MaterialType materialType, HttpServletRequest request, Matter matter) throws IOException{
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        String path = request.getRealPath("./resources/filePDF/");
        try {
            if(spec != null) {
                String url = "/" +materialType.getTypeName() +"/SPEC/" + matter.getMaterialName() + "/" + matter.getMaterialName() + "_SPEC.pdf";
                File convFile = new File(path + url);
                convFile.getParentFile().mkdirs();
                matter.setSpec(url);
                FileOutputStream fos = new FileOutputStream(convFile);
                fos.write(spec.getBytes());
                fos.close();
            }
            if(rohs != null) {
                String url = "/" +materialType.getTypeName() +"/ROHS/" + matter.getMaterialName() + "/" + matter.getMaterialName() + "_ROHS.pdf";
                File convFile = new File(path + url);
                convFile.getParentFile().mkdirs();
                matter.setRohs(url);

                Date date = df.parse(dateRohs);
                matter.setRohsDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                matter.setRohsEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                matter.setRohsAlertDateTest(cal.getTime());

                FileOutputStream fos = new FileOutputStream(convFile);
                fos.write(rohs.getBytes());
                fos.close();
            }
            if(msds != null) {
                String url = "/" +materialType.getTypeName() +"/MSDS/" + matter.getMaterialName() + "/" + matter.getMaterialName() + "_MSDS.pdf";
                File convFile = new File(path + url);
                convFile.getParentFile().mkdirs();
                matter.setMsds(url);

                FileOutputStream fos = new FileOutputStream(convFile);
                fos.write(msds.getBytes());
                fos.close();
            }
            if(halogen != null) {
                String url = "/" +materialType.getTypeName() +"/HALOGEN/" + matter.getMaterialName() + "/" + matter.getMaterialName() + "_HALOGEN.pdf";
                File convFile = new File(path + url);
                convFile.getParentFile().mkdirs();
                matter.setHalogen(url);

                Date date = df.parse(dateHalogen);
                matter.setHalogenDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                matter.setHalogenEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                matter.setHalogenAlertDateTest(cal.getTime());

                FileOutputStream fos = new FileOutputStream(convFile);
                fos.write(halogen.getBytes());
                fos.close();
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    @RequestMapping(value = "/testJasper/create", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> testJasper(@RequestParam("data") String data, Principal principal, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            JSONObject jsonObject = new JSONObject(data);

            String path = request.getRealPath("./resources/core/report/");
            JRCsvDataSource ds = new JRCsvDataSource(new File(path + "/Data.csv"));
            ds.setColumnNames(new String[] {"id", "name", "salary"});
            String fileName = path + "/cocHana.jasper";
            Map map = new HashMap();
            map.put("lotNumber", jsonObject.getString("inputLotNumber"));
            map.put("orderNumber", jsonObject.getString("inputOrderNumber"));
            map.put("qty", jsonObject.getString("inputQty"));
            map.put("partNumber", jsonObject.getString("inputPartNumber"));
            map.put("revision", jsonObject.getString("inputRevision"));
            map.put("remark", jsonObject.getString("inputRemark"));
            map.put("issueName", jsonObject.getString("inputIssueName"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(fileName, map, ds);

            String pathPdf = request.getRealPath("./resources/fileOutPutPDF/");
            String pdfLink = pathPdf + "/kopeeno/output.pdf";
            File pdf = new File(pdfLink);
            pdf.getParentFile().mkdirs();
            JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
            String urlPdf = "kopeeno/output.pdf";
            return new ResponseEntity<String>("{\"create\":true, \"urlPdf\":\"" + urlPdf + "\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
