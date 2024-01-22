import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22" apply false
	id("org.springframework.boot") version "3.1.8" apply false
	id("io.spring.dependency-management") version "1.1.4" apply false
	kotlin("plugin.jpa") version "1.8.22"
}

allprojects {
	repositories {
		mavenCentral()
	}
}

//subprojects {
//
//	tasks.withType<KotlinCompile> {
//		kotlinOptions {
//			freeCompilerArgs += "-Xjsr305=strict"
//			jvmTarget = "17"
//		}
//	}
//
//	tasks.withType<Test> {
//		useJUnitPlatform()
//	}
//}


//tasks.bootBuildImage {
//	builder.set("paketobuildpacks/builder-jammy-base:latest")
//}

//tasks.getByName("bootJar") {
//	enabled = false
//}

//tasks.getByName("jar") {
//	enabled = true;
//}





