package com.ilyabuhlakou.mps.app

import com.ilyabuhlakou.mps.data.DataComponentScanMarker
import com.ilyabuhlakou.mps.service.ServiceComponentScanMarker
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackageClasses = [
	DataComponentScanMarker::class,
	ServiceComponentScanMarker::class,
	MpsApplication::class
])
class MpsApplication

fun main(args: Array<String>) {
	runApplication<MpsApplication>(*args)
}
