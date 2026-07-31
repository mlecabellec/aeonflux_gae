# Base de Connaissance : Schéma Datastore / Firestore (Mode Datastore)

Le backend Google App Engine utilise Firestore en mode Datastore. C'est une base de données NoSQL orientée entités/propriétés, structurée sous forme de clé-valeur avec support d'indexations complexes.

## Entités GAE

### Kind: `CatalogFeed` (Flux du Catalogue)
Représente un flux agrégé et partagé au sein du catalogue communautaire.
- **Key :** ID généré ou dérivé (ex: hash SHA-256 de l'URL normalisée pour déduplication unique).
- **Properties :**
  - `url` : String (Indexé). URL brute normalisée (sans tracking parameters).
  - `title` : String. Titre du flux.
  - `description` : String. Description optionnelle.
  - `feedType` : String (Indexé). RSS, PODCAST, ou BLUESKY.
  - `iconUrl` : String. URL de l'icône.
  - `subscriberCount` : Integer (Indexé). Compteur incrémenté anonymement lors des soumissions de clients.
  - `verified` : Boolean (Indexé). Indique si le flux a été vérifié et nettoyé par l'équipe administrative.
  - `createdAt` : Date/Time. Date de création de l'enregistrement.
  - `lastValidatedAt` : Date/Time. Date de dernière tâche de validation HTTP réussie.

### Kind: `CatalogFeedValidationTask` (Historique des tâches de validation)
Historique des validations asynchrones asynchrones lancées via Google Cloud Tasks.
- **Key :** ID autogénéré ou UUID.
- **Properties :**
  - `feedUrl` : String.
  - `status` : String (Indexé). QUEUED, SUCCESS, FAILED.
  - `errorMessage` : String. Message en cas d'échec.
  - `checkedAt` : Date/Time.
