package com.ilyabuhlakou.mps.app.router

import com.ilyabuhlakou.mps.app.handler.ProfileStatHandler
import org.springdoc.core.annotations.RouterOperation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class ProfileStatRouter(
    private val profileStatHandler: ProfileStatHandler
) {

    @RouterOperation(path = PROFILE_STAT_PATH, beanClass = ProfileStatHandler::class, beanMethod = "getProfileStat")
    @Bean
    fun route() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET(PROFILE_STAT_PATH, profileStatHandler::getProfileStat)
        }
    }

}