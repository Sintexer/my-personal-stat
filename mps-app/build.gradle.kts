val springdocVersion = "1.5.10"
val hateoasVersion = "1.3.3"

dependencies {
    //Module dependencies
    implementation(project(":mps-service"))
    implementation(project(":mps-data"))

    //API Documentation
    implementation("org.springdoc:springdoc-openapi-webflux-ui:$springdocVersion")

    //Web
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    //HATEOAS
    implementation("org.springframework.hateoas:spring-hateoas:$hateoasVersion")
}

tasks.bootJar {
    archiveFileName.set("mps-backend.jar")
}