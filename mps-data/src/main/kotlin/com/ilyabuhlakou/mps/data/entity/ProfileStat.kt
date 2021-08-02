package com.ilyabuhlakou.mps.data.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

/**
 * ProfileStat entity managed in MongoDB
 */
@Document
data class ProfileStat(
    @Id
    val id: String?,
    var name: String,
    @CreatedDate
    var dateRegistered: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    var dateUpdated: LocalDateTime = LocalDateTime.now()
)