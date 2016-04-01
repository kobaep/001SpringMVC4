package com.psk.dao;

import com.psk.domain.Matter;

import java.util.Date;
import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
public interface MatterDAO {

    public void insertMatter(Matter matter);

    public List<Matter> findAllMatter();

    public List<Matter> findAllMatterByStatus(String status);

    public Matter findMatter(Long id);

    public List<Matter> findAllMaterialGe(Date date);

    public List<Matter> findAllMatterByStatusAndStatus(String status1,String status2);
}
