package com.ilyabuhlakou.mps.app.handler

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

interface ProfileStatHandler {

    fun getProfileStat(request: ServerRequest): Mono<ServerResponse>
    fun saveProfileStat(request: ServerRequest): Mono<ServerResponse>

}