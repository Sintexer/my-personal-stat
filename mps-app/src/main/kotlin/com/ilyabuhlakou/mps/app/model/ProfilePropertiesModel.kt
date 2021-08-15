package com.ilyabuhlakou.mps.app.model

import com.ilyabuhlakou.mps.service.dto.ProfilePropertiesDto
import org.springframework.hateoas.RepresentationModel

data class ProfilePropertiesModel(
    val properties: Map<String, String> = emptyMap()
): RepresentationModel<ProfilePropertiesModel>()

fun ProfilePropertiesDto.toProfilePropertiesModel() = ProfilePropertiesModel(
    properties = properties.toMap()
)