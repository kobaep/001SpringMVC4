package com.psk.manager;

import com.psk.domain.AppUser;

import java.util.List;

/**
 * Created by apichat on 3/9/2016 AD.
 */
public interface AppUserManager {

    public void insertAppUser(AppUser appUser);

    public List<AppUser> findAllAppUser();

    public AppUser findAppUser(Long id);

    public AppUser findAppUserByName(String name);

}
