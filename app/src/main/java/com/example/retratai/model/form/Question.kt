package com.example.retratai.model.form

sealed class Question() {

    data class Text(
        val questionTitle: String,
        val questionHint: String,
        val inputType: Int,
        val isRequired: Boolean = true
    ): Question()

    data class Select(
        val questionTitle: String,
        val selectItems: List<String>,
        val isRequired: Boolean = true
    ): Question()
}
