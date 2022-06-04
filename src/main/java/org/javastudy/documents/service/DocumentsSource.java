package org.javastudy.documents.service;

import org.javastudy.documents.entity.Document;

import java.util.List;

/**
 * Источник данных.
 */
public interface DocumentsSource {
    List<Document> getSourceDocuments();
}
