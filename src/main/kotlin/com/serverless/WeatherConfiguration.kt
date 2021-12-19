package com.serverless

class WeatherConfiguration(
    val apiKey: String
) {
    companion object {
        fun create(): WeatherConfiguration = WeatherConfiguration(
            System.getenv("API_KEY")
        )
    }
}