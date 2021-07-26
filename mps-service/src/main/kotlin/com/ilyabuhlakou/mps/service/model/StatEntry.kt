package com.ilyabuhlakou.mps.service.model

import java.time.LocalDateTime

data class StatEntry(
    val id: String,
    val dateCreated: LocalDateTime,
    val content: String
)