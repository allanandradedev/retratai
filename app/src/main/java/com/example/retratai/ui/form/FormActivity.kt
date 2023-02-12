package com.example.retratai.ui.form

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.retratai.databinding.ActivityMainBinding
import com.example.retratai.model.form.Question
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var questionText: TextView
    private lateinit var questionInput: TextInputEditText

    private lateinit var questionSpinner: Spinner

    private lateinit var advanceButton: Button
    private lateinit var backButton: Button

    private val formViewModel: FormViewModel by viewModel()

    private lateinit var progressBar: LinearProgressIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFields()
        setUpFieldListeners()
        formViewModel.reset()
        formViewModel.updateForm()

        formViewModel.question.observe(this, Observer {
            when(it) {
                is Question.Select -> {
                    questionInput.visibility = View.GONE
                    questionSpinner.visibility = View.VISIBLE
                    questionText.text = it.questionTitle

                    val adapter = ArrayAdapter(
                        this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        it.selectItems
                    )

                    questionSpinner.adapter = adapter
                }
                is Question.Text -> {
                    questionSpinner.visibility = View.GONE
                    questionInput.visibility = View.VISIBLE
                    questionText.text = it.questionTitle
                    questionInput.hint = it.questionHint
                }
            }
        })

        formViewModel.currentStep.observe(this, Observer {
            progressBar.progress = ((100.0 / formViewModel.steps) * (it + 1)).roundToInt()
        })

    }

    private fun setUpFields() {
        questionText = binding.questionText
        questionInput = binding.questionTextInputEditText

        questionSpinner = binding.questionSpinner

        advanceButton = binding.advanceButton
        backButton = binding.backButton

        progressBar = binding.progressIndicator
    }

    private fun setUpFieldListeners() {
        advanceButton.setOnClickListener {
//            if(formViewModel.lastStep.value!!) {
//                intent = Intent(this, ResultActivity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                formViewModel.nextStep()
//                questionInput.setText("")
//            }
            formViewModel.nextStep()
        }
        backButton.setOnClickListener {
//            if(formViewModel.currentStep.value!! == 0) {
//                intent = Intent(this, HomeActivity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                formViewModel.prevStep()
//            }
            formViewModel.prevStep()
        }

//        questionInput.doAfterTextChanged {
//            formViewModel.updateAnswer(it.toString())
//        }
//
//        questionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                formViewModel.updateAnswer(parent?.getItemAtPosition(position) as String)
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//
//            }
//
//        }
    }
}