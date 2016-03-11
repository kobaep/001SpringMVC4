package com.psk.manager;

import com.psk.domain.MaterialType;

import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
public interface MaterialTypeManager {

    public void insertMaterialType(MaterialType materialType);

    public List<MaterialType> findAllMaterialType();

    public MaterialType findMaterialType(Long id);
}
