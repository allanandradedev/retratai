package com.example.retratai.data.repository.questions

import com.example.retratai.model.form.Question

interface QuestionRepository {
    fun getQuestions(): List<Question>
}