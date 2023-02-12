package com.example.retratai.ui.result

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.retratai.data.helpers.ResultHandler
import com.example.retratai.databinding.ActivityResultBinding
import com.example.retratai.model.openai.OpenAiRequest
import com.example.retratai.ui.home.HomeActivity
import com.example.retratai.utils.DateUtils
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private lateinit var image: ImageView
    private lateinit var date: TextView
    private lateinit var description: TextView
    private lateinit var button: Button

    private val resultViewModel: ResultViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFields(intent)
        setUpFieldListeners()
        updateTexts()
        getSketch()

        resultViewModel.openAiResponse.observe(this, Observer {
            updateImage()
        })
    }

    private fun setUpFields(intent: Intent) {
        image = binding.sketch
        date = binding.date
        description = binding.description
        button = binding.backButton
    }

    private fun setUpFieldListeners() {
        button.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getSketch() {
//        resultViewModel.getSketch(
//            OpenAiRequest(
//                prompt = "Retrato frontal, $sketchDescription",
//                n = 1,
//                size = "512x512"
//            )
//        )
    }

    private fun updateImage() {
        val result = resultViewModel.openAiResponse.value

        if (result is ResultHandler.Success) {
            displayImageFromUrl(image, result.data.data[0].url)
        } else if (result is ResultHandler.Error) {
            Toast.makeText(
                applicationContext,
                result.exception.message.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun updateTexts() {
        date.text = DateUtils().getDate()
    }

    private fun displayImageFromUrl(imageView: ImageView, url: String) {
        Picasso.get()
            .load(url)
            .into(imageView)
    }
}