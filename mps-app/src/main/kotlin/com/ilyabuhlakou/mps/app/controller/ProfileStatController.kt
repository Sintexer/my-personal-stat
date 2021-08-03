package com.ilyabuhlakou.mps.app.controller

import com.ilyabuhlakou.mps.app.model.ProfileStatModel
import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import com.ilyabuhlakou.mps.service.profile.ProfileStatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import javax.validation.constraints.NotBlank

/**
 * ProfileStatController manages operations with ProfileStats
 */
@RestController
@RequestMapping("/stats")
class ProfileStatController @Autowired constructor(
    private val profileStatService: ProfileStatService,
    private val profileStatModelAssembler: ReactiveRepresentationModelAssembler<ProfileStatDto, ProfileStatModel>
) {

    /**
     * Get ProfileStat by id
     */
    @GetMapping("/{id}")
    fun receiveProfileStat(
        @PathVariable @NotBlank id: String,
        exchange: ServerWebExchange
    ): Mono<ProfileStatModel> {
        return profileStatService.findProfileStat(id)
            .flatMap { profileStatModelAssembler.toModel(it, exchange) }
    }

    @PostMapping("")
    fun saveProfileStat(
        @RequestBody profileStatDtoMono: Mono<ProfileStatDto>,
        exchange: ServerWebExchange
    ): Mono<ProfileStatModel> {
        return profileStatService.saveProfileStat(profileStatDtoMono)
            .flatMap { profileStatModelAssembler.toModel(it, exchange) }
    }

    @GetMapping("")
    fun getAll(
        exchange: ServerWebExchange
    ): Mono<CollectionModel<ProfileStatModel>> {
        return profileStatService.getAll().let {
            profileStatModelAssembler.toCollectionModel(it, exchange)
        }
    }

}