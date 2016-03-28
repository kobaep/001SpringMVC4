package com.psk.dao.imp;

import com.psk.dao.MatterDAO;
import com.psk.domain.Matter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.EntityType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.sql.rowset.Predicate;
import java.util.Date;
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
        entityManager.merge(matter);
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
    public List<Matter> findAllMatterByStatus(String status) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matter> cq = builder.createQuery(Matter.class);
        Root<Matter> root = cq.from(Matter.class);
        cq.where(builder.equal(root.get("status"), status));
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

    @Override
    public List<Matter> findAllMaterialGe(Date date) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matter> cq = builder.createQuery(Matter.class);
        Root<Matter> root = cq.from(Matter.class);
        cq.where(
                builder.or(
                        builder.lessThanOrEqualTo(root.<Date>get("rohsAlertDateTest"), date),
                        builder.lessThanOrEqualTo(root.<Date>get("msdsAlertDateTest"), date),
                        builder.lessThanOrEqualTo(root.<Date>get("specAlertDateTest"), date),
                        builder.lessThanOrEqualTo(root.<Date>get("specAlertDateTest"), date)
                )
        );
        return entityManager.createQuery(cq).getResultList();
    }
}
