package com.ilyabuhlakou.mps.app.controller

import com.ilyabuhlakou.mps.app.model.ProfileStatModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@RestController
@RequestMapping("/stat")
class ProfileStatController {

    @GetMapping("/{id}")
    fun receiveProfileStat(@PathVariable id: String): Mono<ProfileStatModel> {
        return Mono.fromSupplier { ProfileStatModel("1", "Name", LocalDateTime.now(), LocalDateTime.now()) }
    }

}