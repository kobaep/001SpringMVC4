package com.psk.service;

import com.psk.dao.MaterialTypeDAO;
import com.psk.domain.MaterialType;
import com.psk.manager.MaterialTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
@Service
public class MaterialTypeService implements MaterialTypeManager{

    @Autowired
    private MaterialTypeDAO materialTypeDAO;

    @Override
    @Transactional
    public void insertMaterialType(MaterialType materialType) {
        materialTypeDAO.insertMaterialType(materialType);
    }

    @Override
    public List<MaterialType> findAllMaterialType() {
        return materialTypeDAO.findAllMaterialType();
    }

    @Override
    public MaterialType findMaterialType(Long id) {
        return materialTypeDAO.findMaterialType(id);
    }
}
