package com.serverless

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.serverless.service.DefaultWeatherService
import com.serverless.service.WeatherService

class Bootstrap {

    fun weatherService(): WeatherService = DefaultWeatherService("749561a315b14523a8f5f1ef95e45864", objectMapper())

    fun objectMapper(): ObjectMapper = jacksonObjectMapper()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
}