package com.mateuszjanczak.weatherchecklambda.service

data class Weather(
    val name: String,
    val main: Temperature
)

data class Temperature(
   val temp: Double
)