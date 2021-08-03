package com.ilyabuhlakou.mps.app.model

import java.time.LocalDateTime

/**
 * Rest Error object
 */
data class ErrorModel(
    val httpStatus: Int = 500,
    val description: String,
    val descriptionKey: String,
    val message: String = "No exception message available",
    val timestamp: LocalDateTime = LocalDateTime.now()
)