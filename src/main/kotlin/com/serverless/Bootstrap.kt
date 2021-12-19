package com.serverless

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.serverless.service.DefaultWeatherService
import com.serverless.service.WeatherConfiguration
import com.serverless.service.WeatherService

class Bootstrap {

    fun weatherService(): WeatherService = DefaultWeatherService(weatherConfiguration(), objectMapper())

    private fun weatherConfiguration(): WeatherConfiguration = WeatherConfiguration(System.getenv("API_URL"), System.getenv("API_KEY"))

    fun objectMapper(): ObjectMapper = jacksonObjectMapper()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
}