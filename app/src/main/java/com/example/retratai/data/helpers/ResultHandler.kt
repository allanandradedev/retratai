package com.example.retratai.data.helpers

sealed class ResultHandler<out T> {
    data class Success<out T>(val data: T): ResultHandler<T>()
    data class Error(val exception: Exception): ResultHandler<Nothing>()
}