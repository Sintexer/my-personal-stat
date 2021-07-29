package com.ilyabuhlakou.mps.app.handler

import com.ilyabuhlakou.mps.app.model.ProfileStatModel
import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import com.ilyabuhlakou.mps.service.profile.ProfileStatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Component
class ProfileStatHandlerImpl
@Autowired constructor(
    val profileStatService: ProfileStatService
) : ProfileStatHandler {

    override fun getProfileStat(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                Mono.fromSupplier { ProfileStatModel("1", "Name", LocalDateTime.now(), LocalDateTime.now()) },
                ProfileStatModel::class.java
            )
    }

    override fun saveProfileStat(request: ServerRequest): Mono<ServerResponse> {
        val profileStatDto = request.bodyToMono(ProfileStatDto::class.java)
        val otherMono = profileStatDto.flatMap {
            Mono.just(ProfileStatDto(name = "abc${it.name}"))
        }
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                otherMono,
                ProfileStatDto::class.java
            )
    }
}