package com.psk.dao;

import com.psk.domain.DocumentHistory;

import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
public interface DocumentHistoryDao {

    public void insertDocumentHistory(DocumentHistory documentHistory);

    public List<DocumentHistory> findAllDocumentHistory();

    public DocumentHistory findDocumentHistory(Long id);
}
