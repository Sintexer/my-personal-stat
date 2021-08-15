package com.ilyabuhlakou.mps.service.profile

import com.ilyabuhlakou.mps.data.repository.ProfileStatRepository
import com.ilyabuhlakou.mps.service.dto.ProfilePropertiesDto
import com.ilyabuhlakou.mps.service.dto.toProfilePropertiesDto
import com.ilyabuhlakou.mps.service.profile.exception.ProfileStatNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ProfilePropertiesServiceImpl @Autowired constructor(
    private val profileStatRepository: ProfileStatRepository
) : ProfilePropertiesService {
    override fun getProfileProperties(profileId: String): Mono<ProfilePropertiesDto> {
        return profileStatRepository.findById(profileId)
            .switchIfEmpty(Mono.error(ProfileStatNotFoundException()))
            .flatMap{ Mono.just(it.properties.toProfilePropertiesDto())}
            .switchIfEmpty(Mono.just(ProfilePropertiesDto()))
    }
}