package com.ilyabuhlakou.mps.data.entity

import java.time.LocalDateTime

data class StatEntryEntity (
    val id: String,
    val dateCreated: LocalDateTime,
    val content: String
)