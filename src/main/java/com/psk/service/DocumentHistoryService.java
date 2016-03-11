package com.psk.service;

import com.psk.dao.imp.DocumentHistoryDAOImpl;
import com.psk.domain.DocumentHistory;
import com.psk.manager.DocumentHistoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
@Service
public class DocumentHistoryService implements DocumentHistoryManager {

    @Autowired
    private DocumentHistoryDAOImpl documentHistoryDAO;

    @Override
    @Transactional
    public void insertDocumentHistory(DocumentHistory documentHistory) {
        documentHistoryDAO.insertDocumentHistory(documentHistory);
    }

    @Override
    public List<DocumentHistory> findAllDocumentHistory() {
        return documentHistoryDAO.findAllDocumentHistory();
    }

    @Override
    public DocumentHistory findDocumentHistory(Long id) {
        return documentHistoryDAO.findDocumentHistory(id);
    }
}
