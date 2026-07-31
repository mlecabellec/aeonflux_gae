# Mémoire de Contexte AeonFlux - GAE Java Backend

## État d'Avancement du Projet
- **Phase Actuelle :** Kick-Off & Initialisation de la structure du projet.
- **Dernières Actions :**
  - Pivot architectural : utilisation de Java 21, Spring Boot et Gradle à la place de Python/FastAPI sur Google App Engine Standard.
  - Définition du package Java global : `com.aeonflux.backend`.
  - Intégration des règles de qualité strictes (Checkstyle, PMD, SpotBugs, ArchUnit).
  - Initialisation de la structure de répertoires `.antigravity/` pour gouverner le développement autonome de l'agent.

## Prochaines Étapes
1. Définir et implémenter la configuration Gradle racine (`build.gradle.kts` et `settings.gradle.kts`) avec intégration des linters de qualité.
2. Créer l'arborescence des packages Java et générer le code squelette pour `core` (App Check validation), `api` (Endpoints REST `/api/v1/catalog/submit` et `/api/v1/catalog/search`), `models` (CatalogFeed entity) et `services`.
3. Configurer `app.yaml` pour le déploiement sur Google App Engine (Java 21 runtime).
4. Configurer les linters Checkstyle, PMD, et SpotBugs dans le répertoire `config/`.
