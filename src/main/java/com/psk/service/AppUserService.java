package com.psk.service;

import com.psk.dao.AppUserDAO;
import com.psk.domain.AppUser;
import com.psk.manager.AppUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by apichat on 3/9/2016 AD.
 */
@Service
public class AppUserService implements AppUserManager{

    @Autowired
    private AppUserDAO appUserDAO;

    @Override
    @Transactional
    public void insertAppUser(AppUser appUser) {
        appUserDAO.insertAppUser(appUser);
    }

    @Override
    public List<AppUser> findAllAppUser() {
        return appUserDAO.findAllAppUser();
    }

    @Override
    public AppUser findAppUser(Long id) {
        return appUserDAO.findAppUser(id);
    }
}
