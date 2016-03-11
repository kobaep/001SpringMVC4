package com.psk.service;

import com.psk.dao.MaterialCodeDAO;
import com.psk.domain.MaterialCode;
import com.psk.manager.MaterialCodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
@Service
public class MaterialCodeService implements MaterialCodeManager {

    @Autowired
    private MaterialCodeDAO materialCodeDAO;

    @Override
    @Transactional
    public void insertMaterialCode(MaterialCode matter) {
        materialCodeDAO.insertMaterialCode(matter);
    }

    @Override
    public List<MaterialCode> findAllMaterialCode() {
        return materialCodeDAO.findAllMaterialCode();
    }

    @Override
    public MaterialCode findMaterialCode(Long id) {
        return materialCodeDAO.findMaterialCode(id);
    }
}
