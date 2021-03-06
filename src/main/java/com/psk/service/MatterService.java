package com.psk.service;

import com.psk.dao.MatterDAO;
import com.psk.domain.Matter;
import com.psk.manager.MatterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
@Service
public class MatterService implements MatterManager{

    @Autowired
    private MatterDAO matterDAO;

    @Override
    @Transactional
    public void insertMatter(Matter matter) {
        matterDAO.insertMatter(matter);
    }

    @Override
    public List<Matter> findAllMatter() {
        return matterDAO.findAllMatter();
    }

    @Override
    public List<Matter> findAllMatterByStatus(String status) {
        return matterDAO.findAllMatterByStatus(status);
    }

    @Override
    public List<Matter> findAllMatterByStatusAndStatus(String status1, String status2) {
        return matterDAO.findAllMatterByStatusAndStatus(status1, status2);
    }

    @Override
    public Matter findMatter(Long id) {
        return matterDAO.findMatter(id);
    }

    @Override
    public List<Matter> findAllMaterialGe(Date date) {
        return matterDAO.findAllMaterialGe(date);
    }

}
