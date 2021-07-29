package com.ilyabuhlakou.mps.service.profile

import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import reactor.core.publisher.Mono

interface ProfileStatService {

    fun saveProfileStat(profileStatDtoMono: Mono<ProfileStatDto>)

}