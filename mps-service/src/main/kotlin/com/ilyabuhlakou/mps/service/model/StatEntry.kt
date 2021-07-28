package com.ilyabuhlakou.mps.service.model

import java.time.LocalDateTime

data class StatEntry(
    val dateCreated: LocalDateTime = LocalDateTime.now(),
    val content: String
)