package com.example.retratai.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.retratai.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var registerButton: Button;
    private lateinit var enterButton: Button;
    private lateinit var binding: ActivityHomeBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFields(binding)
        setUpFieldListeners()

    }

    private fun setUpFields(binding: ActivityHomeBinding) {
        registerButton = binding.registerButton
        enterButton = binding.enterButton
    }

    private fun setUpFieldListeners() {
        enterButton.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        registerButton.setOnClickListener { }
    }
}