package com.ilyabuhlakou.mps.app.model.assembler

import com.ilyabuhlakou.mps.app.model.ProfilePropertiesModel
import com.ilyabuhlakou.mps.app.model.toProfilePropertiesModel
import com.ilyabuhlakou.mps.service.dto.ProfilePropertiesDto
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class ProfilePropertiesModelAssembler() :
    ReactiveRepresentationModelAssembler<ProfilePropertiesDto, ProfilePropertiesModel> {

    override fun toModel(entity: ProfilePropertiesDto, exchange: ServerWebExchange): Mono<ProfilePropertiesModel> {
        return Mono.just(
            entity.toProfilePropertiesModel().apply {

            }
        )
    }
}