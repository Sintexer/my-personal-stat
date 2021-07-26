package com.ilyabuhlakou.mps.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collation = "PersonalStat")
data class PersonalStatEntity(
    @Id
    val id: String,
    val name: String,
    val dateCreated: LocalDateTime,
    val lists: Map<String, List<StatEntryEntity>>
)
