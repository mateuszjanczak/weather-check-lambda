package com.mateuszjanczak.weatherchecklambda

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mateuszjanczak.weatherchecklambda.service.DefaultWeatherService
import com.mateuszjanczak.weatherchecklambda.service.WeatherConfiguration
import com.mateuszjanczak.weatherchecklambda.service.WeatherService

class Bootstrap {

    fun weatherService(): WeatherService = DefaultWeatherService(weatherConfiguration(), objectMapper())

    private fun weatherConfiguration(): WeatherConfiguration = WeatherConfiguration(System.getenv("API_URL"), System.getenv("API_KEY"))

    fun objectMapper(): ObjectMapper = jacksonObjectMapper()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
}