package com.aeonflux.backend.api;

import com.aeonflux.backend.models.CatalogFeed;
import com.aeonflux.backend.services.CatalogService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    public record SubmitFeedRequest(
        @NotBlank(message = "feed_url is required")
        String feedUrl,
        
        @NotBlank(message = "declared_type is required")
        @Pattern(regexp = "^(RSS|PODCAST|BLUESKY)$", message = "declared_type must be RSS, PODCAST, or BLUESKY")
        String declaredType
    ) {}

    public record SubmitFeedResponse(
        String status,
        String message,
        String taskId
    ) {}

    public record SearchResponse(
        long total,
        int page,
        int limit,
        List<CatalogFeed> results
    ) {}

    @PostMapping("/submit")
    public ResponseEntity<SubmitFeedResponse> submitFeed(@Valid @RequestBody SubmitFeedRequest request) {
        String taskId = catalogService.enqueueValidation(request.feedUrl(), request.declaredType());
        
        return ResponseEntity.status(HttpStatus.ACCEPTED)
            .body(new SubmitFeedResponse("QUEUED", "Feed URL queued for validation and catalog ingestion.", taskId));
    }

    @GetMapping("/search")
    public ResponseEntity<SearchResponse> searchCatalog(
            @RequestParam(required = false) String q,
            @RequestParam(required = false, defaultValue = "ALL") String type,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit) {
        
        List<CatalogFeed> results = catalogService.searchCatalog(q, type, page, limit);
        long total = catalogService.countSearchResults(q, type);
        
        return ResponseEntity.ok(new SearchResponse(total, page, limit, results));
    }
}
