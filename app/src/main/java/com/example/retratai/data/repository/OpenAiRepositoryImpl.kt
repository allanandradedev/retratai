package com.example.retratai.data.repository

import com.example.retratai.data.service.OpenAiService
import com.example.retratai.model.openai.OpenAiRequest
import com.example.retratai.model.openai.OpenAiResponse

class OpenAiRepositoryImpl(private val openAiService: OpenAiService): OpenAiRepository {
    override fun getSketch(openAiRequest: OpenAiRequest): Result<OpenAiResponse> {
        return Result.failure(Exception())
    }
}