package com.farhad.example.hexagonalorderdemo.shop.archunit;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

public class DependencyRuleTest {
	
	private static final String ROOT_PACKAGE = "com.farhad.example.hexagonalorderdemo.shop";
	private static final String MODEL_PACKAGE = "model";
	private static final String APPLICATION_PACKAGE = "application";
	private static final String PORT_PACKAGE = "application.port";
	private static final String SERVICE_PACKAGE = "application.service";
	private static final String ADAPTER_PACKAGE = "adapter";


	@Test
	public void checkDependencyRule() {
		JavaClasses classesToCheck = new ClassFileImporter().importPackages(ROOT_PACKAGE + "..");
		System.out.println("=====================================");
		System.out.println(Arrays.asList(classesToCheck.toArray()));
		System.out.println("=====================================");
		checkNoDependencyFromTo(MODEL_PACKAGE, APPLICATION_PACKAGE, classesToCheck);
		checkNoDependencyFromTo(MODEL_PACKAGE, ADAPTER_PACKAGE, classesToCheck);

		checkNoDependencyFromTo(APPLICATION_PACKAGE, ADAPTER_PACKAGE, classesToCheck);

		checkNoDependencyFromTo(PORT_PACKAGE, SERVICE_PACKAGE, classesToCheck);
		checkNoDependencyFromTo(ADAPTER_PACKAGE, SERVICE_PACKAGE, classesToCheck);
	}


	private void checkNoDependencyFromTo(String fromPackage, String toPackage, JavaClasses classesToCheck) {
		ArchRuleDefinition.noClasses()
			.that()
			.resideInAPackage(fullyQualified(fromPackage))
			.should()
			.dependOnClassesThat()
			.resideInAPackage(fullyQualified(toPackage))
			// .allowEmptyShould(true)
			.check(classesToCheck);
	}
	private String fullyQualified(String packageName) {	
		return ROOT_PACKAGE + "." + packageName;
	}
}
