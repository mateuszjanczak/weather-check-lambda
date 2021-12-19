package com.serverless

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.serverless.service.DefaultWeatherService
import com.serverless.service.WeatherService

class Bootstrap {

    fun weatherService(): WeatherService = DefaultWeatherService(WeatherConfiguration.create(), objectMapper())

    fun objectMapper(): ObjectMapper = jacksonObjectMapper()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
}