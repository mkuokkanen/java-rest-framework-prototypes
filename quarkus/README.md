# Quarkus

Framework combining
RestEasy for JAX-RS,
Jackson or jsonb for JSON,
and lots of other stuff. 

Glue code is hidden with Maven/Gradle plugin magic.

Functionality can be added as modules called extensions.

No template engine extension currently available.

Reminds me of Spring Boot.

Some commands:
* Run dev mode `mvn compile quarkus:dev`
* List extensions `mvn quarkus:list-extensions`
* Dependency tree `mvn quarkus-bootstrap:build-tree`