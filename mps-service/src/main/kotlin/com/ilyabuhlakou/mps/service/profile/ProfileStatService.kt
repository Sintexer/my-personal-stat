package com.ilyabuhlakou.mps.service.profile

import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ProfileStatService {

    fun saveProfileStat(profileStatDtoMono: Mono<ProfileStatDto>): Mono<ProfileStatDto>
    fun findProfileStat(profileStatId: String): Mono<ProfileStatDto>
    fun getAll(): Flux<ProfileStatDto>

}