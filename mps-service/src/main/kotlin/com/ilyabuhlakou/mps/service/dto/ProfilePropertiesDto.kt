package com.ilyabuhlakou.mps.service.dto

import com.ilyabuhlakou.mps.data.entity.ProfileProperties

class ProfilePropertiesDto(
    val properties: Map<String, String> = emptyMap()
)

fun ProfilePropertiesDto.toProfileProperties() = ProfileProperties(
    properties = properties.toMap()
)

fun ProfileProperties.toProfilePropertiesDto() = ProfilePropertiesDto(
    properties = properties.toMap()
)