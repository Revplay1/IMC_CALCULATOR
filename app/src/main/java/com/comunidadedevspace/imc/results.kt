package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Constant key used for passing the IMC result value between activities
const val key_result_imc = "ResultIMC"

class results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getFloatExtra(key_result_imc, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        var tvClassification = findViewById<TextView>(R.id.tv_classification)

        tvResult.text = result.toString()


        tvClassification.text = when {
            result <= 18.5f -> {
                tvClassification.setTextColor(Color.BLUE)
                "Insufficient Weight"
            }
            result > 18.5f && result <= 24.9f -> {
                tvClassification.setTextColor(Color.GREEN)
                "Normal Weight"
            }
            result > 25f && result <= 29.9f -> {
                tvClassification.setTextColor(Color.YELLOW)
                "Overweight Grade I"
            }
            result > 30f && result <= 39.9f -> {
                tvClassification.setTextColor(Color.MAGENTA)
                "Overweight Grade II (Pre-obesity)"
            }
            else -> {
                tvClassification.setTextColor(Color.RED)
                "Obesity"
            }
        }


    }

}