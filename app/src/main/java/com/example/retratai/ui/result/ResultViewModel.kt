package com.example.retratai.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retratai.data.helpers.ResultHandler
import com.example.retratai.data.repository.openai.OpenAiRepositoryImpl
import com.example.retratai.model.openai.OpenAiRequest
import com.example.retratai.model.openai.OpenAiResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class ResultViewModel(
    private val openAiRepositoryImpl: OpenAiRepositoryImpl,
    ): ViewModel() {

    private val _openAiResponse = MutableLiveData<ResultHandler<OpenAiResponse>>()
    val openAiResponse: LiveData<ResultHandler<OpenAiResponse>>
        get() = _openAiResponse

    fun getSketch(openAiRequest: OpenAiRequest) {
        viewModelScope.launch {
            val response = openAiRepositoryImpl.getSketch(openAiRequest)
            if (response.isSuccessful) {
                _openAiResponse.value = ResultHandler.Success(data = response.body()!!)
            } else {
                _openAiResponse.value = ResultHandler.Error(Exception("Error while fetching data"))
            }
        }
    }
}