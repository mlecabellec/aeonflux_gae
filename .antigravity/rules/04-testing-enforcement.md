# Directives Test & Assurance Qualité - Backend

1. **Objectif de Couverture minimum :**
   - 90% de couverture globale par lignes de code via JaCoCo.
2. **Tests Unitaires (JUnit 5 + Mockito) :**
   - Chaque service doit être testé unitairement avec des mocks pour isoler la logique métier des services tiers et du stockage.
3. **Tests d'Intégration (Spring Boot Test + MockMvc) :**
   - Les Controllers REST doivent être testés avec `MockMvc` pour valider le routing, la validation des DTOs, la sérialisation JSON et le comportement d'App Check.
4. **Architecture Tests (ArchUnit) :**
   - Intégrer des tests ArchUnit pour s'assurer qu'aucune dépendance cyclique n'existe et que la couche API n'accède pas directement aux Repositories sans passer par la couche Service.
5. **Static Analysis Enforcement :**
   - Checkstyle, PMD et SpotBugs doivent s'exécuter à chaque compilation Gradle. Le build doit échouer en cas d'erreur ou d'alerte critique.
