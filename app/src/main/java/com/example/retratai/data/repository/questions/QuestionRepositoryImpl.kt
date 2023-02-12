package com.example.retratai.data.repository.questions

import android.text.InputType
import com.example.retratai.model.form.Question

class QuestionRepositoryImpl: QuestionRepository {
    override fun getQuestions(): List<Question> {
        return listOf(
            Question.Select(
                "Qual o gênero?",
                listOf("Feminino", "Masculino"),
            ),
            Question.Text(
                "Qual a idade?",
                "Ex: 19",
                InputType.TYPE_CLASS_NUMBER
            ),
            Question.Text(
                "Qual a descendência?",
                "Ex: Asiático",
                InputType.TYPE_CLASS_TEXT
            ),
            Question.Select(
                "Qual a cor da pele?",
                listOf("Negro", "Pardo", "Branco", "Indigena")
            ),
            Question.Text(
                "Qual a cor do cabelo?",
                "Ex: Preto",
                InputType.TYPE_CLASS_TEXT
            ),
            Question.Select(
                "Qual o tamanho do cabelo?",
                listOf("Curto", "Médio", "Longo")
            ),
            Question.Select(
                "Expessura da sobrancelha",
                listOf("Fina", "Média", "Grossa")
            ),
            Question.Text(
                "Qual a cor dos olhos?",
                "Ex: Pretos",
                InputType.TYPE_CLASS_TEXT
            ),
            Question.Text(
                "Como é a barba? (Deixe em branco caso não tenha)",
                "Ex: Barba cheia com bigode",
                InputType.TYPE_CLASS_TEXT,
                false
            ),
            Question.Select(
                "Como é o nariz",
                listOf("Fino", "Grosso")
            ),
            Question.Select(
                "Qual o formato do rosto?",
                listOf("Oval", "Redondo", "Quadrado", "Triangular")
            )
        )
    }
}