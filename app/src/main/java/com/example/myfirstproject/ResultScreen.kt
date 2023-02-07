package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_result_screen)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

          val tvResult = findViewById<TextView>(R.id.textview_result)
          val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

          val result = intent.getFloatExtra("EXTRA_RESULT", 0.01f)

          tvResult.text = result.toString()


        /* MENOR QUE 18.5		MAGREZA
         * ENTRE 18.5 E 24.9	NORMAL
         * ENTRE 25 E 29.9		SOBREPESO
         * ENTRE 30 E 39.9		OBESIDADE
         * MAIOR QUE 40			OBESIDADE GRAVE
         */

        val classificacao = when {
            result < 18.5f -> "Under weight"
            result in 18.6f..24.9f -> "Normal"
            result in 25f..29.9f -> "Overweight"
            result in 30f..39.9f -> "Obesity"
            else -> "Severe obesity"
        }

        tvClassificacao.text = classificacao

    }

       override fun onOptionsItemSelected(item: MenuItem): Boolean {
           finish()
           return super.onOptionsItemSelected(item)
       }       }