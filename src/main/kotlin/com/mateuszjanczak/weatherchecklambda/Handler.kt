package com.mateuszjanczak.weatherchecklambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.mateuszjanczak.weatherchecklambda.service.WeatherService
import org.apache.logging.log4j.LogManager

class Handler(
    private val weatherService: WeatherService = Bootstrap().weatherService(),
    private val objectMapper: ObjectMapper = Bootstrap().objectMapper()
) : RequestHandler<Map<String, Any>, Response> {

    override fun handleRequest(input: Map<String, Any>, context: Context): Response {
        LOG.info("Received: $input")

        val body = getBodyFromInput(input)
        val city = body["city"] ?: "Cracow"
        val weather = weatherService.getWeatherByCity(city)

        return Response("City: ${weather.name} Temperature: ${weather.main.temp} °C")
    }

    private fun getBodyFromInput(input: Map<String, Any>): Map<String, String> =
        objectMapper.readValue<Map<String, String>>(input["body"] as String, object : TypeReference<Map<String, String>>() {})

    companion object {
        private val LOG = LogManager.getLogger(Handler::class.java)
    }
}