package com.ilyabuhlakou.mps.service.model

import java.time.LocalDateTime

data class PersonalStat(
    val name: String,
    val dateCreated: LocalDateTime = LocalDateTime.now(),
    val lists: Map<String, List<StatEntry>> = mapOf()
)