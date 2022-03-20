package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoraimc.databinding.ActivityResultadoImcBinding

class ResultadoImcActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultadoImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoImcBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val imc = intent.getStringExtra("IMC")
        binding.textViewImc.text = "IMC: ${imc}"

        val classificacao = intent.getStringExtra("CLASSIFICACAO")
        binding.textViewClassificacao.text = "Classificação: ${classificacao}"
    }
}