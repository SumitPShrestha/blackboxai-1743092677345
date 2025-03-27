package com.cm.cmconfigurationservice.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class WebServerConfiguration {
    private val corsOriginPatterns: String = "http://localhost:8001"

    @Bean
    fun corsFilter(): CorsFilter {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.allowedOrigins = listOf("http://localhost:4200") // Add your Angular app's URL
        corsConfiguration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
        corsConfiguration.allowedHeaders = listOf("Authorization", "Content-Type", "Accept")
            corsConfiguration.allowCredentials =        true
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("*", corsConfiguration)
        return CorsFilter(source)
    }
}