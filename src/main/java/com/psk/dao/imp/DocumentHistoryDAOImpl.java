package com.psk.dao.imp;

import com.psk.dao.DocumentHistoryDao;
import com.psk.domain.DocumentHistory;
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
public class DocumentHistoryDAOImpl implements DocumentHistoryDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertDocumentHistory(DocumentHistory documentHistory) {
        entityManager.merge(documentHistory);
    }

    @Override
    public List<DocumentHistory> findAllDocumentHistory() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DocumentHistory> cq = builder.createQuery(DocumentHistory.class);
        Root<DocumentHistory> root = cq.from(DocumentHistory.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public DocumentHistory findDocumentHistory(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DocumentHistory> cq = builder.createQuery(DocumentHistory.class);
        Root<DocumentHistory> root = cq.from(DocumentHistory.class);
        cq.where(builder.equal(root.get("id"), id));
        return entityManager.createQuery(cq).getSingleResult();
    }
}
