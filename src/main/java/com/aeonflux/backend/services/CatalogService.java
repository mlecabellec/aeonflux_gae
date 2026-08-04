package com.aeonflux.backend.services;

import com.aeonflux.backend.models.CatalogFeed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogService {

    // Placeholder list for startup. Real app will query Datastore/Firestore via Google SDK.
    private final List<CatalogFeed> dummyCatalog = new ArrayList<>();

    public String enqueueValidation(String feedUrl, String declaredType) {
        String taskId = "task_" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        log.info("Queued validation task {} for feed URL: {}", taskId, feedUrl);
        // In GAE production, this will invoke Cloud Tasks queue to perform asynchronous validation.
        return taskId;
    }

    public List<CatalogFeed> searchCatalog(String query, String type, int page, int limit) {
        log.info("Searching catalog for query: '{}', type: '{}', page: {}, limit: {}", query, type, page, limit);
        // Implement Firestore Datastore query logic here. Returning empty list for now.
        return new ArrayList<>(dummyCatalog);
    }

    public long countSearchResults(String query, String type) {
        return dummyCatalog.size();
    }
}
