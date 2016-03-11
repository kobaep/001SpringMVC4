package com.psk.web;

import com.psk.domain.AppUser;
import com.psk.domain.MaterialType;
import com.psk.manager.AppUserManager;
import com.psk.manager.MaterialTypeManager;
import com.psk.service.MaterialTypeService;
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

import java.security.Principal;
import java.util.Date;

/**
 * Created by apichat on 3/11/2016 AD.
 */
@Controller
public class MtmsControllerJson {

    private final Logger logger = LoggerFactory.getLogger(MtmsControllerJson.class);

    @Autowired
    private MaterialTypeManager materialTypeManager;

    @Autowired
    private AppUserManager appUserManager;

    @RequestMapping(value = "/matter/create", method = RequestMethod.POST, headers = "Accept=application/json")
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

            logger.debug("-=== Material Type --> {} ===-", materialTypeManager.findAllMaterialType().toString());
            return new ResponseEntity<String>("{\"create\":true}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
