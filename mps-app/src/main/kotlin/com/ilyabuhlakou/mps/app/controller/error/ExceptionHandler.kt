package com.ilyabuhlakou.mps.app.controller.error

import com.ilyabuhlakou.mps.app.exception.EXCEPTION_WITHOUT_MESSAGE_KEY
import com.ilyabuhlakou.mps.app.exception.MessagedException
import com.ilyabuhlakou.mps.app.model.ErrorModel
import com.ilyabuhlakou.mps.service.message.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler @Autowired constructor(
    private val messageService: MessageService
) {

    @ExceptionHandler(MessagedException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleAnyMessagedException(exception: MessagedException): ErrorModel = exception.run {
        ErrorModel(
            httpStatus,
            messageService.getOrEmpty(descriptionKey, args),
            exception.descriptionKey,
            message ?: "No exception message"
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleUnhandledException(exception: Exception): ErrorModel = ErrorModel(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        messageService.get(EXCEPTION_WITHOUT_MESSAGE_KEY) ?: "Exception doesn't have internationalized description",
        EXCEPTION_WITHOUT_MESSAGE_KEY,
        exception.message ?: "No exception message"
    )
}
