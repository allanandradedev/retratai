package com.example.retratai.data.repository

import com.example.retratai.model.question.Question

interface QuestionRepository {
    fun getQuestions(): List<Question>
}