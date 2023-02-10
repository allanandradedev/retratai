package com.example.retratai.model.openai

data class OpenAiRequest(
    val prompt: String,
    val n: Int,
    val size: String
    )
