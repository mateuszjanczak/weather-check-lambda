package com.serverless.service

data class Weather(
    val name: String,
    val main: Temperature
)

data class Temperature(
   val temp: Double
)