package com.ilyabuhlakou.mps.app.controller

import com.ilyabuhlakou.mps.app.model.ProfileStatModel
import com.ilyabuhlakou.mps.data.entity.ProfileStat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

/**
 * ProfileStatController manages operations with ProfileStats
 */
@RestController
@RequestMapping("/stat")
class ProfileStatController @Autowired constructor(
    private val profileStatModelAssembler: ReactiveRepresentationModelAssembler<ProfileStat, ProfileStatModel>
) {

    /**
     * Get ProfileStat by id
     */
    @GetMapping("/{id}")
    fun receiveProfileStat(@PathVariable @NotBlank id: String): Mono<ProfileStatModel> {
        return Mono.fromSupplier { ProfileStatModel("1", "Name", LocalDateTime.now(), LocalDateTime.now()) }
    }

}