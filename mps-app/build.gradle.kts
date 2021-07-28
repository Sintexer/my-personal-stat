val springdocVersion = "1.5.10"

dependencies {
    //Module dependencies
    implementation(project(":mps-service"))
    implementation(project(":mps-data"))

    //API Documentation
    implementation("org.springdoc:springdoc-openapi-webflux-ui:$springdocVersion")

    //Web
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

tasks.bootJar {
    archiveFileName.set("mps-backend.jar")
}