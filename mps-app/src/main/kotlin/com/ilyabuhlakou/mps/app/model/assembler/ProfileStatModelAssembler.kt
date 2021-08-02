package com.ilyabuhlakou.mps.app.model.assembler

import com.ilyabuhlakou.mps.app.controller.ProfileStatController
import com.ilyabuhlakou.mps.app.exception.EntityIdNotPresentException
import com.ilyabuhlakou.mps.app.model.ProfileStatModel
import com.ilyabuhlakou.mps.data.entity.ProfileStat
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.IanaLinkRelations.SELF
import org.springframework.hateoas.server.mvc.linkTo
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Assembles ProfileStatModel with links to related endpoints
 */
@Component
class ProfileStatModelAssembler :
    ReactiveRepresentationModelAssembler<ProfileStat, ProfileStatModel> {

    override fun toModel(entity: ProfileStat, exchange: ServerWebExchange): Mono<ProfileStatModel> {
        return Mono.just(
            ProfileStatModel(
                id = entity.id ?: throw EntityIdNotPresentException(""),
                name = entity.name,
                dateRegistered = entity.dateRegistered,
                dateUpdated = entity.dateUpdated,
            ).apply {
                add(linkTo<ProfileStatController> { receiveProfileStat(id) }.withRel(SELF))
            })
    }

    override fun toCollectionModel(
        entities: Flux<out ProfileStat>,
        exchange: ServerWebExchange
    ): Mono<CollectionModel<ProfileStatModel>> {
        return super.toCollectionModel(entities, exchange).flatMap{ Mono.just(it.apply {
            add(linkTo<ProfileStatController> { receiveProfileStat("12") }.withRel(SELF))
        }) }
    }
}