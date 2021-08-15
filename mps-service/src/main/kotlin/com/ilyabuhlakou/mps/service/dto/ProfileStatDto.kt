package com.ilyabuhlakou.mps.service.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.ilyabuhlakou.mps.data.entity.ProfileStat
import java.time.LocalDateTime

data class ProfileStatDto (
    @JsonIgnore
    var id: String? = null,
    val name: String,
    @JsonIgnore
    var dateRegistered: LocalDateTime = LocalDateTime.now(),
    @JsonIgnore
    var dateUpdated: LocalDateTime = LocalDateTime.now(),
    @JsonIgnore
    val properties: ProfilePropertiesDto = ProfilePropertiesDto()
)

fun ProfileStatDto.toProfileStat() = ProfileStat(
    id = id,
    name = name,
    dateRegistered = dateRegistered,
    dateUpdated = dateUpdated,
    properties = properties.toProfileProperties()
)

fun ProfileStat.toProfileStatDto() = ProfileStatDto(
    id = id,
    name = name,
    dateRegistered = dateRegistered,
    dateUpdated = dateUpdated,
    properties = properties.toProfilePropertiesDto()
)