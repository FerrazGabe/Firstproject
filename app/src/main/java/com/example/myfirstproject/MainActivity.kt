package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btncalcular: Button = findViewById(R.id.btncalcular)
        val edtPeso: EditText = findViewById(R.id.editText_peso)
        val edtAltura: EditText = findViewById(R.id.editText_altura)

        btncalcular.setOnClickListener {
            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
                var altura: Float = alturaStr.toFloat()
                var peso: Float = pesoStr.toFloat()
                var alturaFinal: Float = altura * altura
                var result: Float = peso / alturaFinal

                val intent = Intent(this, ResultScreen::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Answer the fields", Toast.LENGTH_LONG).show()
            }
        }
    }}

