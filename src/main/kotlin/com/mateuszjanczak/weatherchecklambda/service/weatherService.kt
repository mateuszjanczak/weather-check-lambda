package com.mateuszjanczak.weatherchecklambda.service

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import khttp.responses.Response

interface WeatherService {
    fun getWeatherByCity(city: String): Weather
}

class DefaultWeatherService(
    private val weatherConfiguration: WeatherConfiguration,
    private val objectMapper: ObjectMapper
) : WeatherService {

    override fun getWeatherByCity(city: String): Weather {
        val result: Response = try {
            khttp.get(url = getApiUrl(city))
        } catch (e: Exception) {
            throw Exception("Failed to fetch data from API", e)
        }

        return try {
            objectMapper.readValue(result.text, Weather::class.java)
        } catch (e: JsonProcessingException) {
            throw Exception("Failed to parse data from API", e)
        }
    }

    private fun getApiUrl(city: String) = weatherConfiguration.apiUrl
        .replace("%CITY%", city)
        .replace("%APIKEY%", weatherConfiguration.apiKey)
}