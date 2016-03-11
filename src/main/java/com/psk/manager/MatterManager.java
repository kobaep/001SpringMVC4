package com.psk.manager;

import com.psk.domain.Matter;

import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
public interface MatterManager {

    public void insertMatter(Matter matter);

    public List<Matter> findAllMatter();

    public Matter findMatter(Long id);
}
