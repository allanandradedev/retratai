package com.example.retratai.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retratai.data.repository.QuestionRepositoryImpl
import com.example.retratai.databinding.ActivityMainBinding
import com.example.retratai.model.question.Question
import com.example.retratai.model.sketch.Sketch
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var questionText: TextView
    private lateinit var questionInput: TextInputEditText

    private lateinit var advanceButton: Button
    private lateinit var backButton: Button

    private lateinit var progressBar: LinearProgressIndicator

    private lateinit var questionRepository: QuestionRepositoryImpl
    private lateinit var questions: List<Question>
    private var step = 0
    private var sketch: Sketch = Sketch()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFields()
        setUpFieldListeners()
        updateView()
    }

    private fun setUpFields() {
        questionText = binding.questionText
        questionInput = binding.questionTextInputEditText

        advanceButton = binding.advanceButton
        backButton = binding.backButton

        progressBar = binding.progressIndicator

        questionRepository = QuestionRepositoryImpl()
        questions = questionRepository.getQuestions()
    }

    private fun setUpFieldListeners() {
        advanceButton.setOnClickListener {
            if (nextStep()) {
                updateSketch()
                step ++
                updateView()
            } else {
                intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        backButton.setOnClickListener {
            if (previousStep()) {
                step --
                updateView()
            } else {
                intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun nextStep(): Boolean {
        return step + 2 < questions.size
    }

    private fun previousStep(): Boolean {
        return step > 0
    }

    private fun updateView() {
        val actualQuestion = questions[step]

        questionText.text = actualQuestion.title
        setQuestionInputText()
        questionInput.hint = actualQuestion.hint
        questionInput.inputType = actualQuestion.inputType

        progressBar.progress = ((100.0 / questions.size) * (step + 1)).roundToInt()
    }

    private fun setQuestionInputText() {
        when (step) {
            0 -> questionInput.setText(if (sketch.gender == "") "" else sketch.gender)
            1 -> questionInput.setText(if (sketch.age == "") "" else sketch.age)
            2 -> questionInput.setText(if (sketch.bodyType == "") "" else sketch.bodyType)
            3 -> questionInput.setText(if (sketch.ancestry == "") "" else sketch.ancestry)
            4 -> questionInput.setText(if (sketch.skinColor == "") "" else sketch.skinColor)
            5 -> questionInput.setText(if (sketch.hairColor == "") "" else sketch.hairColor)
            6 -> questionInput.setText(if (sketch.hairSize == "") "" else sketch.hairSize)
            7 -> questionInput.setText(if (sketch.eyebrowColor == "") "" else sketch.eyebrowColor)
            8 -> questionInput.setText(if (sketch.eyebrowThickness == "") "" else sketch.eyebrowThickness)
            9 -> questionInput.setText(if (sketch.eyeColor == "") "" else sketch.eyeColor)
            10 -> questionInput.setText(if (sketch.beardAndMoustache == "") "" else sketch.beardAndMoustache)
            11 -> questionInput.setText(if (sketch.beardAndMoustacheSize == "") "" else sketch.beardAndMoustacheSize)
            12 -> questionInput.setText(if (sketch.beardAndMoustacheColor == "") "" else sketch.beardAndMoustacheColor)
            13 -> questionInput.setText(if (sketch.noseType == "") "" else sketch.noseType)
            else -> questionInput.setText(if (sketch.faceType == "") "" else sketch.faceType)
        }
    }

    private fun updateSketch() {
        when(step) {
            0 -> sketch.gender = questionInput.text.toString().trim()
            1 -> sketch.age = questionInput.text.toString().trim()
            2 -> sketch.bodyType = questionInput.text.toString().trim()
            3 -> sketch.ancestry = questionInput.text.toString().trim()
            4 -> sketch.skinColor = questionInput.text.toString().trim()
            5 -> sketch.hairColor = questionInput.text.toString().trim()
            6 -> sketch.hairSize = questionInput.text.toString().trim()
            7 -> sketch.eyebrowColor = questionInput.text.toString().trim()
            8 -> sketch.eyebrowThickness = questionInput.text.toString().trim()
            9 -> sketch.eyeColor = questionInput.text.toString().trim()
            10 -> sketch.beardAndMoustache = questionInput.text.toString().trim()
            11 -> sketch.beardAndMoustacheSize = questionInput.text.toString().trim()
            12 -> sketch.beardAndMoustacheColor = questionInput.text.toString().trim()
            13 -> sketch.noseType = questionInput.text.toString().trim()
            else -> sketch.faceType = questionInput.text.toString().trim()
        }
    }
}