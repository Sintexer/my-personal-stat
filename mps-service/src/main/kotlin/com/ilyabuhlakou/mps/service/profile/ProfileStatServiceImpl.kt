package com.ilyabuhlakou.mps.service.profile

import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ProfileStatServiceImpl : ProfileStatService {

    override fun saveProfileStat(profileStatDtoMono: Mono<ProfileStatDto>) {
    }

}