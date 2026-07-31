# AeonFlux GAE Backend Architecture Index

This directory details the backend service architecture.

## Architecture Guidelines

* **Layered Architecture:** Implemented in Java/Spring Boot (Controllers ➔ Services ➔ Repositories).
* **Datastore mode Firestore:** NoSQL entity storage representing CatalogFeeds and validation tasks.
* **App Check Verification:** Integration of Firebase App Check inside the REST layer for anti-scraping security.
* **Asynchronous Workers:** Task scheduling using Google Cloud Tasks for asynchronous URL verification and ingestion.

## Documents

* [Datastore Schema](../../.antigravity/knowledge_base/gae_datastore_schema.md) - NoSQL Datastore Mode schemas and properties.
