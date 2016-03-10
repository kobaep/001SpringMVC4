package com.psk.web;

import com.psk.domain.AppUser;
import com.psk.manager.AppUserManager;
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

import java.security.Principal;
import java.util.List;

/**
 * Created by apichat on 3/9/2016 AD.
 */
@Controller
public class AppUserControllerJson {

    private final Logger logger = LoggerFactory.getLogger(AppUserControllerJson.class);

    @Autowired
    private AppUserManager appUserManager;

    @RequestMapping(value = "/appuser/create", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> appUserCreate(@RequestParam("data") String data, Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            JSONObject jsonObject = new JSONObject(data);
            AppUser appUser = new AppUser();
            appUser.setUsername(jsonObject.getString("inputUser"));
            appUser.setPassword(jsonObject.getString("inputPassword"));
            appUser.setName(jsonObject.getString("inputName"));
            appUser.setDepartment(jsonObject.getString("inputDepartment"));
            appUser.setDepartmentCode(jsonObject.getString("inputDepartmentCode"));
            appUser.setEnabled(1);
            appUser.setEmailAddress(jsonObject.getString("inputEmail"));
            appUser.setPhoneNumber(jsonObject.getString("inputTelephoneNumber"));
            appUser.setRoleName(jsonObject.getString("inputRoleName"));
            appUserManager.insertAppUser(appUser);
            return new ResponseEntity<String>("{\"create\":true}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"create\":false}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/appuser/datalist", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> appUserDataList(@RequestParam("data") String data) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            JSONArray jsonArray = new JSONArray();
            List<AppUser> appUsers = appUserManager.findAllAppUser();
            int i = 1;
            for (AppUser a : appUsers) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("no", i);
                jsonObject.put("id", a.getId());
                jsonObject.put("user", a.getUsername());
                jsonObject.put("password", a.getPassword());
                jsonObject.put("name", a.getName());
                jsonObject.put("department", a.getDepartment());
                jsonObject.put("email", a.getEmailAddress());
                jsonObject.put("telephone", a.getPhoneNumber());
                jsonArray.put(jsonObject);
            }
            return new ResponseEntity<String>(jsonArray.toString(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
