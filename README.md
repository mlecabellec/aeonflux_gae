# AeonFlux GAE Backend

Scalable central directory catalog backend written in Java and Spring Boot for Google App Engine Standard Environment. It serves as a community catalog of RSS, podcasts, and Bluesky feeds, managing ingestion validation, deduplication, and search indexing.

## Features & Specifications

Based on the [AeonFlux specifications](doc/specifications/aeon_flux.md):

* **Anonymized Ingestion (`/api/v1/catalog/submit`):**
  * Allows clients to submit proposed RSS, Podcast, or Bluesky feeds.
  * Validation tasks executed asynchronously via Google Cloud Tasks to check connectivity, parse metadata, and deduct UTM/tracking parameters.
  * Fully decoupled and anonymous submission pipeline protecting user privacy.
* **Community Directory Search (`/api/v1/catalog/search`):**
  * Fully paginated multi-criteria text search over the Catalog.
  * Counter-based ranking prioritizing popular streams according to anonymous subscriptions.
* **Firebase App Check Protection:**
  * Enforces authenticity of requests through `X-App-Check-Token` header verification protecting against scrapers.

## Tech Stack & Architecture

* **Language & Runtime:** Java 21 on Google App Engine Standard.
* **Framework:** Spring Boot 3.x.
* **Build System:** Gradle (Groovy DSL).
* **Database:** Google Cloud Firestore in Datastore Mode.
* **Security:** Firebase Admin SDK (App Check Verification).
* **Asynchrony:** Google Cloud Tasks.
* **Quality Assurance:**
  * Strict Google-Style Checkstyle rules.
  * PMD (Error-prone, Best Practices, Design categories).
  * SpotBugs static analysis.
  * ArchUnit architecture constraint enforcement.
  * JaCoCo test coverage reporting.

## Project Structure

```
aeonflux_gae/
├── .antigravity/            # Antigravity agent configuration and governance rules
├── config/
│   ├── checkstyle/          # Checkstyle ruleset configuration (checkstyle.xml)
│   └── pmd/                 # PMD ruleset configuration (ruleset.xml)
├── src/
│   ├── main/
│   │   ├── java/com/aeonflux/backend/
│   │   │   ├── api/         # Spring Boot Controllers and request DTO records
│   │   │   ├── core/        # App Check verification, interceptors, and security configurations
│   │   │   ├── models/      # Datastore entities (CatalogFeed)
│   │   │   └── services/    # Business services (CatalogService)
│   │   └── resources/
│   │       ├── application.yml   # Spring Boot application configuration
│   │       └── app.yaml          # Google App Engine deployment descriptor
│   └── test/                # Unit, integration, and ArchUnit architecture tests
├── build.gradle             # Gradle build script (Groovy DSL)
├── gradle.properties        # Gradle properties
├── LICENSE                  # Apache 2.0 License
└── settings.gradle          # Gradle settings script
```

## Running & Testing

### Running Tests and Quality Checks

To run unit tests, integration tests, checkstyle, PMD, and SpotBugs validation, execute:

```bash
./gradlew build
```

The build will fail if any Checkstyle, PMD, SpotBugs, or ArchUnit test asserts an issue.

### Running Locally

```bash
./gradlew bootRun
```

The application will listen on port `8080` (accessible at `http://localhost:8080`).

### Deploying to Google App Engine Standard

Make sure you have Google Cloud SDK installed and configured, then deploy:

```bash
gcloud app deploy
```

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
