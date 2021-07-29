package com.ilyabuhlakou.mps.service.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime

data class ProfileStatDto (
    @set:JsonIgnore
    var id: String? = null,
    val name: String,
    @set:JsonIgnore
    var dateRegistered: LocalDateTime = LocalDateTime.now(),
    @set:JsonIgnore
    var dateUpdated: LocalDateTime = LocalDateTime.now()
)