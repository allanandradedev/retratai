package com.example.retratai.data.repository.openai

import com.example.retratai.data.helpers.ResultHandler
import com.example.retratai.model.openai.OpenAiRequest
import com.example.retratai.model.openai.OpenAiResponse
import retrofit2.Response

interface OpenAiRepository {
    suspend fun getSketch(openAiRequest: OpenAiRequest): Response<OpenAiResponse>
}