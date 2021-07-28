package com.ilyabuhlakou.mps.app.model

import java.time.LocalDateTime

data class ProfileStatModel(
    val id: String,
    val name: String,
    val dateRegistered: LocalDateTime,
    val dateUpdated: LocalDateTime
)