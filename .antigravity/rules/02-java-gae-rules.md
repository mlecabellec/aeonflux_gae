# Directives Backend Google App Engine Java pour Antigravity Agent

1. **Architecture Spring Boot :** Implémenter l'architecture en couches (Controllers -> Services -> Repositories) avec une séparation stricte des responsabilités. Tout l'I/O bound doit exploiter la réactivité ou le multithreading asynchrone géré (pas de threads bruts, utiliser les TaskExecutors Spring).
2. **Quality & Formatting :** Les règles de qualité strictes exigent le respect de Checkstyle (style Google Java), PMD (détection de bugs et mauvaises pratiques) et SpotBugs (analyse statique avancée). Aucun avertissement bloquant ne doit être toléré au build.
3. **Datastore Mode Firestore :** L'accès aux données dans Google Cloud Firestore en mode Datastore doit être géré via Spring Cloud GCP Datastore ou l'API native Google Cloud Datastore Client v1.
4. **App Check Verification :** Valider obligatoirement les jetons Firebase App Check (`X-App-Check-Token`) sur tous les endpoints critiques pour protéger le backend contre le spam et le scraping.
5. **App Engine Compatibility :** L'application doit démarrer rapidement et respecter les contraintes de l'environnement Standard Java 21 (pas de threads système incontrôlés, écriture sur système de fichiers local restreinte aux dossiers temporaires).
