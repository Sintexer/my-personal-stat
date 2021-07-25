package com.ilyabuhlakou.mps.app

import com.ilyabuhlakou.mps.service.SampleService
import com.ilyabuhlakou.mps.service.ServiceComponentScanMarker
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackageClasses = [ServiceComponentScanMarker::class])
class MpsAppApplication

fun main(args: Array<String>) {
	SampleService().doSmth()
	runApplication<MpsAppApplication>(*args)
}
