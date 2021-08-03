package com.ilyabuhlakou.mps.app.model.assembler

import com.ilyabuhlakou.mps.app.controller.ProfileStatController
import com.ilyabuhlakou.mps.app.exception.EntityIdNotPresentException
import com.ilyabuhlakou.mps.app.model.ProfileStatModel
import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import org.springframework.hateoas.IanaLinkRelations.COLLECTION
import org.springframework.hateoas.IanaLinkRelations.CREATE_FORM
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

/**
 * Assembles ProfileStatModel with links to related endpoints
 */
@Component
class ProfileStatModelAssembler :
    ReactiveRepresentationModelAssembler<ProfileStatDto, ProfileStatModel> {

    override fun toModel(entity: ProfileStatDto, exchange: ServerWebExchange): Mono<ProfileStatModel> {
        return Mono.just(
            ProfileStatModel(
                id = entity.id ?: throw EntityIdNotPresentException(),
                name = entity.name,
                dateRegistered = entity.dateRegistered,
                dateUpdated = entity.dateUpdated,
            ).apply {
                add(linkTo<ProfileStatController> { receiveProfileStat(id, exchange) }.withSelfRel())
                add(linkTo<ProfileStatController> { getAll(exchange) }.withRel(COLLECTION))
                add(linkTo<ProfileStatController> {
                    saveProfileStat(
                        Mono.just(entity),
                        exchange
                    )
                }.withRel(CREATE_FORM))
            })
    }

}