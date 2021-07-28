val springdocVersion = "1.5.9"

dependencies {
	//Module dependencies
	implementation(project(":mps-service"))
	implementation(project(":mps-data"))

	//API Documentation
	implementation("org.springdoc:springdoc-openapi-kotlin:$springdocVersion")
	implementation("org.springdoc:springdoc-openapi-hateoas:$springdocVersion")
	implementation("org.springdoc:springdoc-openapi-ui:$springdocVersion")
//	implementation("org.springdoc:springdoc-openapi-security:1.5.9")

	//Web
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

tasks.bootJar{
	archiveFileName.set("mps-backend.jar")
}