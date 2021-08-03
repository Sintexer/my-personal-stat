package com.ilyabuhlakou.mps.service.profile

import com.ilyabuhlakou.mps.data.repository.ProfileStatRepository
import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import com.ilyabuhlakou.mps.service.dto.toProfileStat
import com.ilyabuhlakou.mps.service.dto.toProfileStatDto
import com.ilyabuhlakou.mps.service.profile.exception.ProfileStatNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProfileStatServiceImpl @Autowired constructor(
    private val profileStatRepository: ProfileStatRepository
) : ProfileStatService {

    override fun saveProfileStat(profileStatDtoMono: Mono<ProfileStatDto>): Mono<ProfileStatDto> {
        return profileStatDtoMono.flatMap { dto ->
            profileStatRepository.save(dto.toProfileStat())
                .flatMap { Mono.just(it.toProfileStatDto()) }
        }
    }

    override fun findProfileStat(profileStatId: String): Mono<ProfileStatDto> {
        return profileStatRepository.findById(profileStatId)
            .flatMap { Mono.just(it.toProfileStatDto()) }
            .switchIfEmpty(Mono.error(ProfileStatNotFoundException()))
    }

    override fun getAll(): Flux<ProfileStatDto> {
        return profileStatRepository.findAll().concatMap { Mono.just(it.toProfileStatDto()) }
    }
}