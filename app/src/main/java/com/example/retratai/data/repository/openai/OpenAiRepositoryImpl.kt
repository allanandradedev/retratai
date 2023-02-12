package com.example.retratai.data.repository.openai

import com.example.retratai.data.service.OpenAiService
import com.example.retratai.model.openai.OpenAiRequest
import com.example.retratai.model.openai.OpenAiResponse
import retrofit2.Response

class OpenAiRepositoryImpl(private val openAiService: OpenAiService): OpenAiRepository {
    override suspend fun getSketch(openAiRequest: OpenAiRequest): Response<OpenAiResponse> {
        return openAiService.getSketch(openAiRequest)
    }
}