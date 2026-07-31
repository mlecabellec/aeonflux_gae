package com.aeonflux.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatalogFeed {
    private String catalogId;
    private String url;
    private String title;
    private String description;
    private String feedType; // RSS, PODCAST, BLUESKY
    private String iconUrl;
    private long subscriberCount;
    private boolean verified;
    private Instant createdAt;
    private Instant lastValidatedAt;
}
