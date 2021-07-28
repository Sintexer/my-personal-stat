package com.ilyabuhlakou.mps.data.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class ProfileStat(
    @Id
    val id: String?,
    val name: String,
    @CreatedDate
    val dateRegistered: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    val dateUpdated: LocalDateTime = LocalDateTime.now()
)