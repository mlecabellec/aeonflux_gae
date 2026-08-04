# AeonFlux GAE Backend Governance Index

This directory details static analysis configurations and coding rules.

## Quality Enforcements

* **Static Analysis:** Strict Checkstyle (Google ruleset), PMD, and SpotBugs are configured and run as build tasks.
* **Architecture Testing:** ArchUnit checks inside JUnit tests ensure code styling and layer separation are respected.
* **Coverage Target:** Minimum of 90% test coverage using JaCoCo.

## Related Configuration Files

* [Java GAE Rules](../../../.antigravity/rules/02-java-gae-rules.md) - Coding style, frameworks, and patterns for the backend.
* [Clean Code Rules](../../../.antigravity/rules/03-architecture-clean-code.md) - SOLID principles and design patterns.
* [Testing Rules](../../../.antigravity/rules/04-testing-enforcement.md) - Testing boundaries and goals.
