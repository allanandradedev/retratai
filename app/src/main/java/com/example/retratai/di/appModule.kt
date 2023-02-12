package com.example.retratai.di

import com.example.retratai.data.helpers.RetrofitBuilder
import com.example.retratai.data.repository.openai.OpenAiRepositoryImpl
import com.example.retratai.data.repository.questions.QuestionRepositoryImpl
import com.example.retratai.data.service.OpenAiService
import com.example.retratai.ui.form.FormViewModel
import com.example.retratai.ui.result.ResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory { QuestionRepositoryImpl() }

    factory { RetrofitBuilder.getRetrofit().create(OpenAiService::class.java) }
    factory { OpenAiRepositoryImpl(openAiService = get()) }

    viewModel {
        ResultViewModel(
            openAiRepositoryImpl = get()
        )
    }

    viewModel {
        FormViewModel(questionRepositoryImpl = get())
    }
}