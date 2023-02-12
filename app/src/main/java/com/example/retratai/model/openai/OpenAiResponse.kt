package com.example.retratai.model.openai

data class OpenAiResponse (
    val created: Int,
    val data: List<Url>
    )