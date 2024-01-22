import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java {
    sourceCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(group= "jakarta.validation", name= "jakarta.validation-api", version= "2.0.2")

    implementation(group= "org.springframework", name= "spring-core", version= "5.3.27")
    implementation(group= "org.springframework", name= "spring-context", version= "5.3.27")
    // kotlin
    // object mapper
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk17")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// kotiln 컴파일 버전 설정
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

