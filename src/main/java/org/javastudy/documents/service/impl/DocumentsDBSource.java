package org.javastudy.documents.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javastudy.documents.data.DocumentRepository;
import org.javastudy.documents.entity.Document;
import org.javastudy.documents.service.DocumentsSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentsDBSource implements DocumentsSource {
    private final DocumentRepository documentRepository;

    @Override
    public List<Document> getSourceDocuments() {
        try {
            var documents = documentRepository.findAll();
            log.info("Load {} documents from db", documents.size());
            return documents;
        } catch (Exception e) {
            log.error("Error loading documents", e);
            return List.of();
        }
    }
}
