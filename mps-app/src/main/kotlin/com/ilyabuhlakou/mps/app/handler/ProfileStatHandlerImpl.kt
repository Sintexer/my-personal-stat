package com.ilyabuhlakou.mps.app.handler

import com.ilyabuhlakou.mps.app.model.ProfileStatModel
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Component
class ProfileStatHandlerImpl : ProfileStatHandler {
    override fun getProfileStat(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                Mono.fromSupplier { ProfileStatModel("1", "Name", LocalDateTime.now(), LocalDateTime.now()) },
                ProfileStatModel::class.java
            )
    }
}