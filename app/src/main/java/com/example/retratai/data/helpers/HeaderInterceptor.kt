package com.example.retratai.data.helpers

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor(private val token: String): Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val authorization = "Authorization"
        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader(authorization, token)
                .build()
        )
    }
}