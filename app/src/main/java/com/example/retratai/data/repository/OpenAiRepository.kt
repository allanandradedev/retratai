package com.example.retratai.data.repository

import com.example.retratai.model.openai.OpenAiRequest
import com.example.retratai.model.openai.OpenAiResponse

interface OpenAiRepository {
    fun getSketch(openAiRequest: OpenAiRequest): Result<OpenAiResponse>
}