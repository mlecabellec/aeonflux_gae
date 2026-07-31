package com.aeonflux.backend;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.aeonflux.backend")
public class ArchitectureTests {

    @ArchTest
    public static final ArchRule layeredArchitectureRule = layeredArchitecture()
        .consideringAllDependencies()
        .layer("Controller").definedBy("com.aeonflux.backend.api..")
        .layer("Service").definedBy("com.aeonflux.backend.services..")
        .layer("Model").definedBy("com.aeonflux.backend.models..")
        
        .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller");
}
