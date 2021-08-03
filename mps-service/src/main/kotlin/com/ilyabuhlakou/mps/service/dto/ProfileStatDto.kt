package com.ilyabuhlakou.mps.service.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.ilyabuhlakou.mps.data.entity.ProfileStat
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

fun ProfileStatDto.toProfileStat() = ProfileStat(
    id = id,
    name = name,
    dateRegistered = dateRegistered,
    dateUpdated = dateUpdated
)

fun ProfileStat.toProfileStatDto() = ProfileStatDto(
    id = id,
    name = name,
    dateRegistered = dateRegistered,
    dateUpdated = dateUpdated
)