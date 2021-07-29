package com.ilyabuhlakou.mps.app.router

import com.ilyabuhlakou.mps.app.handler.ProfileStatHandler
import com.ilyabuhlakou.mps.service.dto.ProfileStatDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.reactive.function.server.router

@Configuration
class RouteConfiguration(
    private val profileStatHandler: ProfileStatHandler
) {

    @RouterOperations(
        RouterOperation(path = PROFILE_STAT_PATH, method = arrayOf(RequestMethod.GET), beanClass = ProfileStatHandler::class, beanMethod = "getProfileStat"),
        RouterOperation(path = PROFILE_STAT_PATH, method = arrayOf(RequestMethod.POST), beanClass = ProfileStatHandler::class, beanMethod = "saveProfileStat",
            operation = Operation(operationId = "saveProfileStat",
                requestBody = RequestBody(required = true, content = [Content(schema = Schema(implementation = ProfileStatDto::class))]))
        )
    )
    @Bean
    fun profileStatRouter() = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET(PROFILE_STAT_PATH, profileStatHandler::getProfileStat)
            POST(PROFILE_STAT_PATH, profileStatHandler::saveProfileStat)
        }
    }

}