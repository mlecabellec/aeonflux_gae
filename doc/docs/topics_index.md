# Navigation by Developer Topics

This index organizes the AeonFlux GAE Backend documentation by developer topics and operational areas. Use this page as a starting point depending on your discipline.

---

## ☁️ Topic A: Google App Engine & Cloud Services
Focuses on Spring Boot layered architecture, Firestore in Datastore Mode persistence, and Firebase App Check anti-scraping filters.
- [Architecture Overview](architecture/README.md): Details on backend service layers, Datastore integrations, and security checks.
- [Spring Application Entry](file:///home/m/git/aeonflux_gae/src/main/java/com/aeonflux/backend/AeonFluxBackendApplication.java): Application main method.
- [Feed REST Controller](file:///home/m/git/aeonflux_gae/src/main/java/com/aeonflux/backend/api/CatalogController.java): REST endpoints for submits and searches.

---

## ⚙️ Topic B: Asynchronous Worker Validation
Focuses on Cloud Tasks worker triggers, URL validation, and background processing models.
- [Catalog Service Handler](file:///home/m/git/aeonflux_gae/src/main/java/com/aeonflux/backend/services/CatalogService.java): Mocked Cloud Task enqueuer.
- [Datastore Model Schema](../../.antigravity/knowledge_base/gae_datastore_schema.md): NoSQL schema layouts.

---

## 🧪 Topic C: Project Rules & Guidelines
Focuses on general code quality, AI agent guidelines, and Java backend coding standards.
- [Rules Index](architecture/rules_index.md): Entry point for project rules.
- [CS-0010 Quality Standards](architecture/CS-0010.md): Traceability and comment formats.
- [CS-0020 AI Agent Rules](architecture/CS-0020.md): Rules for agent contributions and testing.
- [CS-0030 Java Standards](architecture/CS-0030.md): Parameter defense, null-safety, and OOP patterns.

---

## 🛠️ Topic D: Project Operations & Task Management
Focuses on repository build commands, project roadmap milestones, and task logs.
- [Project Tasks Overview](project/milestones/README.md): Milestones roadmap.
- [Active Documentation Task](project/tasks/TSK-20260804-001.md): First documentation set up task.
