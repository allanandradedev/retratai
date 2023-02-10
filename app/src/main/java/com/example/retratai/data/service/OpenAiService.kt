package com.example.retratai.data.service

import com.example.retratai.model.openai.OpenAiRequest
import com.example.retratai.model.openai.OpenAiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.Response

interface OpenAiService {
    @GET(URL)
    suspend fun getSketch(@Body request: OpenAiRequest): Response<OpenAiResponse>

    companion object {
        private const val URL: String = "images/generations"
    }
}