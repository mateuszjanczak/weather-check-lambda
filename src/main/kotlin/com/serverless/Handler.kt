package com.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.logging.log4j.LogManager

class Handler : RequestHandler<Map<String, Any>, Response> {

    override fun handleRequest(input: Map<String, Any>, context: Context): Response {
        LOG.info("Received: $input")
        val body = getBodyFromInput(input)
        return Response(body["city"] ?: "Cracow")
    }

    private fun getBodyFromInput(input: Map<String, Any>): Map<String, String> =
        ObjectMapper().readValue<Map<String, String>>(input["body"] as String, object : TypeReference<Map<String, String>>() {})

    companion object {
        private val LOG = LogManager.getLogger(Handler::class.java)
    }
}