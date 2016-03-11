package com.psk.manager;

import com.psk.domain.DocumentHistory;

import java.util.List;

/**
 * Created by apichat on 3/11/2016 AD.
 */
public interface DocumentHistoryManager {

    public void insertDocumentHistory(DocumentHistory documentHistory);

    public List<DocumentHistory> findAllDocumentHistory();

    public DocumentHistory findDocumentHistory(Long id);
}
