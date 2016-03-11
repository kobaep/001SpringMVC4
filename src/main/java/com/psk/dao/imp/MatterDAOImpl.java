package com.psk.dao.imp;

import com.psk.dao.MatterDAO;
import com.psk.domain.Matter;
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
public class MatterDAOImpl implements MatterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertMatter(Matter matter) {
        entityManager.persist(matter);
    }

    @Override
    public List<Matter> findAllMatter() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matter> cq = builder.createQuery(Matter.class);
        Root<Matter> root = cq.from(Matter.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public Matter findMatter(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matter> cq = builder.createQuery(Matter.class);
        Root<Matter> root = cq.from(Matter.class);
        cq.where(builder.equal(root.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
