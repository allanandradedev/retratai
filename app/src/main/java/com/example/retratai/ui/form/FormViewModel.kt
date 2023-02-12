package com.example.retratai.ui.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retratai.data.repository.questions.QuestionRepositoryImpl
import com.example.retratai.model.form.Question

class FormViewModel(
    questionRepositoryImpl: QuestionRepositoryImpl
): ViewModel() {

    private val questions: List<Question> = questionRepositoryImpl.getQuestions()

    val steps = questions.size

    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    private val _currentStep = MutableLiveData<Int>(0)
    val currentStep: LiveData<Int>
        get() = _currentStep

    fun updateForm() {
        _question.value = questions[currentStep.value!!]
    }

    fun nextStep() {
        if(_currentStep.value!! < steps - 1) {
            _currentStep.value = _currentStep.value!! + 1
            updateForm()
        }
    }

    fun prevStep() {
        if(_currentStep.value!! > 0) {
            _currentStep.value = _currentStep.value!! - 1
            updateForm()
        }
    }

    fun reset() {
    }

}