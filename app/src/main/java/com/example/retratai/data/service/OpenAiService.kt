package com.example.retratai.data.service

import com.example.retratai.model.openai.OpenAiRequest
import com.example.retratai.model.openai.OpenAiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAiService {
    @POST(URL)
    suspend fun getSketch(@Body request: OpenAiRequest): Response<OpenAiResponse>

    companion object {
        private const val URL: String = "images/generations"
    }
}