package com.ilyabuhlakou.mps.app.locale

import org.springframework.context.i18n.LocaleContext
import org.springframework.context.i18n.SimpleLocaleContext
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.i18n.LocaleContextResolver
import java.util.*


class HttpHeaderLocaleResolver() : LocaleContextResolver {

    override fun resolveLocaleContext(exchange: ServerWebExchange): LocaleContext {
        val language = exchange.request.headers.getFirst("Accept-Language")
        val targetLocale = if (language.isNullOrEmpty()) {
            Locale.forLanguageTag(language)
        } else {
            Locale.getDefault()
        }
        return SimpleLocaleContext(targetLocale)
    }


    override fun setLocaleContext(exchange: ServerWebExchange, localeContext: LocaleContext?) {
        throw UnsupportedOperationException("Not Supported")
    }
}