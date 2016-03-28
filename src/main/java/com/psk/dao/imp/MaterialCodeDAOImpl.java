package com.psk.dao.imp;

import com.psk.dao.MaterialCodeDAO;
import com.psk.domain.MaterialCode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
@Repository
public class MaterialCodeDAOImpl implements MaterialCodeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteMaterialCode(MaterialCode materialCode) {
        MaterialCode m = entityManager.find(MaterialCode.class, materialCode);
        entityManager.getTransaction().begin();
        entityManager.remove(m);
        entityManager.getTransaction().commit();
    }

    @Override
    public void insertMaterialCode(MaterialCode materialCode) {
        entityManager.merge(materialCode);
    }

    @Override
    public List<MaterialCode> findAllMaterialCode() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MaterialCode> cq = builder.createQuery(MaterialCode.class);
        Root<MaterialCode> root = cq.from(MaterialCode.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public MaterialCode findMaterialCode(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MaterialCode> cq = builder.createQuery(MaterialCode.class);
        Root<MaterialCode> root = cq.from(MaterialCode.class);
        cq.where(builder.equal(root.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public MaterialCode findMaterialCodeLink(String code) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MaterialCode> cq = builder.createQuery(MaterialCode.class);
        Root<MaterialCode> root = cq.from(MaterialCode.class);
        cq.where(builder.equal(root.get("codeName"), code));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
