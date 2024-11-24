package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //values for components inputText

        val itextweight = findViewById<TextInputEditText>(R.id.weightInput)
        val itextheight = findViewById<TextInputEditText>(R.id.heightInput)

        // value for result button
        val imcresult = findViewById<Button>(R.id.imcButton)

        // Button click action
        imcresult.setOnClickListener {

            val weight: Float = itextweight.text.toString().toFloat()
            val height: Float = itextheight.text.toString().toFloat()
            val heightQ2 = height + height
            val result = weight / heightQ2

            println("Your IMC is" + result)



        }
    }
}