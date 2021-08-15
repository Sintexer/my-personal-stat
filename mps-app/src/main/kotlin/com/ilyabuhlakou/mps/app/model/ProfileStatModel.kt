package com.ilyabuhlakou.mps.app.model

import com.ilyabuhlakou.mps.app.exception.EntityIdNotPresentException
import com.ilyabuhlakou.mps.service.dto.ProfilePropertiesDto
import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import org.springframework.hateoas.RepresentationModel
import java.time.LocalDateTime

/**
 * ProfileStat HATEOAS model
 */
data class ProfileStatModel(
    var id: String,
    var name: String,
    var dateRegistered: LocalDateTime,
    var dateUpdated: LocalDateTime,
    var properties: ProfilePropertiesModel
): RepresentationModel<ProfileStatModel>()

fun ProfileStatDto.toProfileStatModel() = ProfileStatModel(
    id = id ?: throw EntityIdNotPresentException(),
    name = name,
    dateRegistered = dateRegistered,
    dateUpdated = dateUpdated,
    properties = properties.toProfilePropertiesModel()
)