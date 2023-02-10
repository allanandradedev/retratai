package com.example.retratai.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.retratai.R
import com.example.retratai.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private lateinit var image: ImageView
    private lateinit var date: TextView
    private lateinit var description: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFields()
        setUpFieldListeners()
    }

    private fun setUpFields() {
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
}