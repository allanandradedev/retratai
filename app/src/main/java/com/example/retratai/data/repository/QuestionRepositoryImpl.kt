package com.example.retratai.data.repository

import android.text.InputType
import com.example.retratai.model.question.Question

class QuestionRepositoryImpl: QuestionRepository {
    override fun getQuestions(): List<Question> {
        return listOf(
            Question("Qual o gênero?", "Ex: Masculino", InputType.TYPE_CLASS_TEXT),
            Question("Qual a idade?", "Ex: 19", InputType.TYPE_CLASS_NUMBER),
            Question("Qual o tipo corporal?", "Ex: Magro", InputType.TYPE_CLASS_TEXT),
            Question("Qual a descendência?", "Ex: Asiático", InputType.TYPE_CLASS_TEXT),
            Question("Qual a cor da pele?", "Ex: Branco", InputType.TYPE_CLASS_TEXT),
            Question("Qual a cor do cabelo?", "Ex: Preto", InputType.TYPE_CLASS_TEXT),
            Question("Qual o tamanho do cabelo?", "Ex: Longo", InputType.TYPE_CLASS_TEXT),
            Question("Qual a cor da sobrancelha?", "Ex: Preto", InputType.TYPE_CLASS_TEXT),
            Question("Qual a expessura da sobrancelha?", "Ex: Grossa", InputType.TYPE_CLASS_TEXT),
            Question("Qual a cor dos olhos?", "Ex: Pretos", InputType.TYPE_CLASS_TEXT),
            Question("Como é a barba/bigode?", "Ex: Barba cheia com bigode", InputType.TYPE_CLASS_TEXT),
            Question("Qual o tamanho da barba/bigode?", "Ex: Grande", InputType.TYPE_CLASS_TEXT),
            Question("Qual a cor da barba/bigode?", "Ex: Preto", InputType.TYPE_CLASS_TEXT),
            Question("Como é o nariz?", "Ex: Fino", InputType.TYPE_CLASS_TEXT),
            Question("Qual o formato do rosto?", "Ex: Redondo", InputType.TYPE_CLASS_TEXT),
        )
    }
}