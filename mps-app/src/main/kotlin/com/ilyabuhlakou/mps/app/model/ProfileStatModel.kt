package com.ilyabuhlakou.mps.app.model

import org.springframework.hateoas.RepresentationModel
import java.time.LocalDateTime

/**
 * ProfileStat HATEOAS model
 */
data class ProfileStatModel(
    var id: String,
    var name: String,
    var dateRegistered: LocalDateTime,
    var dateUpdated: LocalDateTime
): RepresentationModel<ProfileStatModel>()