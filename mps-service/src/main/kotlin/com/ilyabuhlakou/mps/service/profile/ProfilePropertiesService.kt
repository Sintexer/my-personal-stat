package com.ilyabuhlakou.mps.service.profile

import com.ilyabuhlakou.mps.service.dto.ProfilePropertiesDto
import reactor.core.publisher.Mono

interface ProfilePropertiesService {

    fun getProfileProperties(profileId: String): Mono<ProfilePropertiesDto>

}