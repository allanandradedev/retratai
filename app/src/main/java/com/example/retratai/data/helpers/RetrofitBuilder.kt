package com.example.retratai.data.helpers

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    fun getRetrofit(): Retrofit {
        val client = OkHttpClient().newBuilder()
            .addInterceptor(HeaderInterceptor(token = "Bearer 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"))
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}