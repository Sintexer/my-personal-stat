package com.ilyabuhlakou.mps.app.controller

import com.ilyabuhlakou.mps.app.model.ProfilePropertiesModel
import com.ilyabuhlakou.mps.app.model.assembler.ProfilePropertiesModelAssembler
import com.ilyabuhlakou.mps.service.profile.ProfilePropertiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/stats/{id}/properties")
class ProfilePropertiesController @Autowired constructor(
    private val profilePropertiesService: ProfilePropertiesService,
    private val profilePropertiesModelAssembler: ProfilePropertiesModelAssembler
) {

    @GetMapping("")
    fun retrieveProperties(@PathVariable id: String, exchange: ServerWebExchange): Mono<ProfilePropertiesModel> {
        return profilePropertiesService.getProfileProperties(id).flatMap {
            profilePropertiesModelAssembler.toModel(it, exchange)
        }
    }

}