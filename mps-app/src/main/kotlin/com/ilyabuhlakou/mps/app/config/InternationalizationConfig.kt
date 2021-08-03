package com.ilyabuhlakou.mps.app.config

import com.ilyabuhlakou.mps.app.locale.HttpHeaderLocaleResolver
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.server.i18n.LocaleContextResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*

@Configuration
class InternationalizationConfig : WebMvcConfigurer {

    /**
     * HttpHeaderLocaleResolver resolves locale request header
     */
    @Bean
    fun localeResolver(): LocaleContextResolver = HttpHeaderLocaleResolver()

    /**
     * Create bean of message source
     */
    @Bean
    fun messageSource(): MessageSource = ReloadableResourceBundleMessageSource().apply {
        setBasename("classpath:messages/messages")
        setDefaultEncoding("UTF-8")
    }

    /**
     * Configure message source for validation error messages
     */
    @Bean
    fun localValidatorFactoryBean(messageSource: MessageSource): LocalValidatorFactoryBean =
        LocalValidatorFactoryBean().apply { setValidationMessageSource(messageSource) }

    companion object {
        const val LOCALE_CHANGE_PARAM_NAME = "lang"
        val DEFAULT_LOCALE: Locale = Locale.US
    }

}