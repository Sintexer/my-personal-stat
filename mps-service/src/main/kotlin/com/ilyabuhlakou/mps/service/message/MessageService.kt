package com.ilyabuhlakou.mps.service.message

interface MessageService {

    fun get(key: String, vararg args: Any = emptyArray()): String?
    fun getOrEmpty(key: String, vararg args: Any = emptyArray()): String

}