package com.example.demopostauthorization.repository;

import com.example.demopostauthorization.model.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentRepository {

    private Map<String, Document> document =
            Map.of(
                    "abc123", new Document("john"),
                    "qwe123", new Document("john"),
                    "asd555", new Document("warwar"),
                    "efg123", new Document("koko")
            );

    public Document findDocument(String code) {
        return document.get(code);
    }

}
