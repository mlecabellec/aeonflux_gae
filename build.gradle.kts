plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    jacoco
    checkstyle
    pmd
    id("com.github.spotbugs") version "6.0.12"
}

group = "com.aeonflux"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    
    // Google Cloud Datastore / Firestore (Standard mode) & Spring Cloud GCP
    implementation("com.google.cloud:google-cloud-datastore:2.19.1")
    
    // Firebase Admin (for App Check verification)
    implementation("com.google.firebase:firebase-admin:9.2.0")

    // Lombok for clean boilerplates
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.tngtech.archunit:archunit-junit5:1.2.1")
    
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// JaCoCo test coverage setup
jacoco {
    toolVersion = "0.8.11"
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

// Checkstyle configurations
checkstyle {
    toolVersion = "10.12.5"
    configFile = file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
    isShowViolations = true
}

// PMD configurations
pmd {
    toolVersion = "6.55.0"
    ruleSetConfig = resources.text.fromFile("config/pmd/ruleset.xml")
    isIgnoreFailures = false
}

// SpotBugs configurations
spotbugs {
    toolVersion.set("4.8.3")
    ignoreFailures.set(false)
    showStackTraces.set(true)
}
