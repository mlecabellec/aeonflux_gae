# Directives Architecture Clean Code - Backend

1. **Architecture en Couches (Layered Architecture) :**
   - **API (Web/REST) Layer :** Contient les Controllers, DTOs (Request/Response) et la gestion des exceptions globales. Ne contient aucune logique métier.
   - **Service (Domain/Business) Layer :** Contient les services métier. Cette couche contient la logique pure de traitement des abonnements, de déduplication, d'appel aux APIs tierces (Bluesky, RSS, OpenAI/Gemini), et d'orchestration des tâches asynchrones.
   - **Repository (Infrastructure/Data) Layer :** Gère l'accès à Google Cloud Datastore / Firestore et Redis.
2. **Principe SOLID & Injection de Dépendances :**
   - Utiliser l'injection par constructeur dans les beans Spring.
   - Favoriser l'usage d'interfaces pour découpler les services (ex: `FeedIngestionService` interface et son implémentation).
3. **Immutabilité & Validation :**
   - Utiliser les Java `record` pour les DTOs afin de garantir l'immutabilité des requêtes et réponses API.
   - Valider systématiquement les entrées avec `@Valid` et `jakarta.validation.constraints`.
