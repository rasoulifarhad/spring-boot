package com.farhad.example.shop_demo;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;


public class InternalPackageTests {
  
    private static final String BASE_PACKAGE = "com.farhad.example.shop_demo";    
    private final JavaClasses analyzedClasses = new ClassFileImporter().importPackages(BASE_PACKAGE);

    @Test
    void internalPackagesAreNotAccessedFromOutside() throws IOException {

        // so that the test will break when the base package is re-named
        assertPackageExists(BASE_PACKAGE);

        List<String> internalPackages = internalPackages(BASE_PACKAGE);

        for (String internalPackage : internalPackages) {
            assertPackageExists(internalPackage);
            assertPackageIsNotAccessedFromOutside(internalPackage);
        }
    }

    /**
     * Finds all packages with the name "internal"
     **/
    private List<String> internalPackages(String basePackage) { 
        Reflections reflections = new Reflections(basePackage, Scanners.SubTypes.filterResultsBy(s -> true));
        return reflections.getSubTypesOf(Object.class).stream()
                .map(t -> t.getPackage().getName())
                .filter(p -> p.startsWith(basePackage))
                .filter(p -> p.endsWith(".internal"))
                .distinct()
                .collect(toList());
    }

    void assertPackageIsNotAccessedFromOutside(String internalPackage) {
        noClasses()
                .that()
                .resideOutsideOfPackage(packageMatcher(internalPackage))
                .should()
                .dependOnClassesThat()
                .resideInAPackage(packageMatcher(internalPackage))
                .check(analyzedClasses);
    }

    void assertPackageExists(String packageName) {
        assertThat(analyzedClasses.containPackage(packageName))
                .as("package %s exists", packageName)
                .isTrue();
    }

    private String packageMatcher(String fullyQualifiedPackage) {
        return fullyQualifiedPackage + "..";
    }    
}
