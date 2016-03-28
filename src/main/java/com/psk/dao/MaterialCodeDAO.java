package com.psk.dao;

import com.psk.domain.MaterialCode;

import java.util.Date;
import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
public interface MaterialCodeDAO {

    public void deleteMaterialCode(MaterialCode materialCode);

    public void insertMaterialCode(MaterialCode materialCode);

    public List<MaterialCode> findAllMaterialCode();

    public MaterialCode findMaterialCode(Long id);

    public MaterialCode findMaterialCodeLink(String code);
}
