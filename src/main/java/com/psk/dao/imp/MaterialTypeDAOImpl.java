package com.psk.dao.imp;

import com.psk.dao.MaterialTypeDAO;
import com.psk.domain.MaterialType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
@Repository
public class MaterialTypeDAOImpl implements MaterialTypeDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertMaterialType(MaterialType materialType) {
        entityManager.persist(materialType);
    }

    @Override
    public List<MaterialType> findAllMaterialType() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MaterialType> cq = builder.createQuery(MaterialType.class);
        Root<MaterialType> root = cq.from(MaterialType.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public MaterialType findMaterialType(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MaterialType> cq = builder.createQuery(MaterialType.class);
        Root<MaterialType> root = cq.from(MaterialType.class);
        cq.where(builder.equal(root.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
