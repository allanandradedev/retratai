package com.example.retratai.data.helpers

sealed class Result<out T> {
    data class Sucess<out T>(val data: T): Result<T>()
    data class Error(val exception: Exception): Result<Nothing>()
}