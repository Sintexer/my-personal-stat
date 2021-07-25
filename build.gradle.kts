import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.5.21" apply false
    kotlin("plugin.spring") version "1.5.21" apply false
    id("org.springframework.boot") version "2.5.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
}

val app_version by extra("0.0.1")

group = "com.ilyabuhlakou"
version = app_version
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

allprojects{
    repositories {
        mavenCentral()
    }
}

subprojects{

    apply {
        plugin("java")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin( "org.jetbrains.kotlin.plugin.spring")
    }

    group = "com.ilyabuhlakou.mps"
    version = app_version
    java.sourceCompatibility = JavaVersion.VERSION_11

    dependencies{
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
