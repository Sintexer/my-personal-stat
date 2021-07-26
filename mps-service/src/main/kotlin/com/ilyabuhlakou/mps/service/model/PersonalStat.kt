package com.ilyabuhlakou.mps.service.model

import java.time.LocalDateTime

data class PersonalStat(
    val id: String,
    val name: String,
    val dateCreated: LocalDateTime,
    val lists: Map<String, List<StatEntry>>
)