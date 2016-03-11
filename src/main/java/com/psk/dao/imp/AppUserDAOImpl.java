package com.psk.dao.imp;

import com.psk.dao.AppUserDAO;
import com.psk.domain.AppUser;
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
import java.util.List;

/**
 * Created by apichat on 3/9/2016 AD.
 */
@Repository
public class AppUserDAOImpl implements AppUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertAppUser(AppUser appUser) {
        entityManager.persist(appUser);
    }

    @Override
    public List<AppUser> findAllAppUser() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AppUser> cq = builder.createQuery(AppUser.class);
        Root<AppUser> root = cq.from(AppUser.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public AppUser findAppUser(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AppUser> cq = builder.createQuery(AppUser.class);
        Root<AppUser> root = cq.from(AppUser.class);
        cq.where(builder.equal(root.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public AppUser findAppUserByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AppUser> cq = builder.createQuery(AppUser.class);
        Root<AppUser> root = cq.from(AppUser.class);
        cq.where(builder.equal(root.get("username"), name));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
