package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
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

            val weightStr: String = itextweight.text.toString()
            val heightStr: String = itextheight.text.toString()

        //if empty
            if(weightStr == "" || heightStr =="") {
                //display message
                Snackbar.make(
                    itextweight,
                    "Enter a value!",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {
                val height = heightStr.toFloat()
                val weight = weightStr.toFloat()

                val heightQ2 = height + height
                val result = weight / heightQ2

                //navigate to the next page
                //create a layout next page
                //transfer layout to next page
                //Intent /android class (intention to carry out something)

                val intent = Intent(this, results::class.java)
                intent.putExtra(key_result_imc, result)
                startActivity(intent)

                println("Your IMC is " + result)


            }
        }
    }
}