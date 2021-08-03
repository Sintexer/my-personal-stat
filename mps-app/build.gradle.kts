val springdocVersion = "1.5.10"
val hateoasVersion = "1.3.3"
val webmvcVersion = "5.3.9"

dependencies {
    //Module dependencies
    implementation(project(":mps-data"))
    implementation(project(":mps-service"))

    //API Documentation
    implementation("org.springdoc:springdoc-openapi-webflux-ui:$springdocVersion")

    //Web
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    //HATEOAS
    implementation("org.springframework.hateoas:spring-hateoas:$hateoasVersion")
    implementation("org.springframework:spring-webmvc:$webmvcVersion")

}

tasks.bootJar {
    archiveFileName.set("mps-backend.jar")
}