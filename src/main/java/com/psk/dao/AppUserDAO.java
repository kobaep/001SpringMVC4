package com.psk.dao;

import com.psk.domain.AppUser;

import java.util.List;

/**
 * Created by apichat on 3/9/2016 AD.
 */
public interface AppUserDAO {

    public void insertAppUser(AppUser appUser);

    public List<AppUser> findAllAppUser();

    public AppUser findAppUser(Long id);
}
