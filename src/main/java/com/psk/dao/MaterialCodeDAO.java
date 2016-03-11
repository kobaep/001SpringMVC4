package com.psk.dao;

import com.psk.domain.MaterialCode;

import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
public interface MaterialCodeDAO {

    public void insertMaterialCode(MaterialCode matter);

    public List<MaterialCode> findAllMaterialCode();

    public MaterialCode findMaterialCode(Long id);
}
