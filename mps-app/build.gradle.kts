dependencies {
	implementation(project(":mps-service"))
	implementation(project(":mps-data"))
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

tasks.bootJar{
	archiveFileName.set("mps-backend.jar")
}