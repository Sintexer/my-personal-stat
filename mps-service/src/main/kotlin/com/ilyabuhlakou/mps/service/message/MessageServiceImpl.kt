package com.ilyabuhlakou.mps.service.message

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageServiceImpl @Autowired constructor(
    private val messageSource: MessageSource
) : MessageService {

    override fun get(key: String, vararg args: Any): String? {
        return messageSource.getMessage(key, args, null, Locale.getDefault())
    }

    override fun getOrEmpty(key: String, vararg args: Any): String {
        return get(key = key, args = args) ?: ""
    }

}