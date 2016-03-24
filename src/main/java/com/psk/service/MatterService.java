package com.psk.service;

import com.psk.dao.MatterDAO;
import com.psk.domain.Matter;
import com.psk.manager.MatterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Matter findMatter(Long id) {
        return matterDAO.findMatter(id);
    }
}
