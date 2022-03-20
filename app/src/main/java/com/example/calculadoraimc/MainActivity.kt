package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import androidx.activity.viewModels
import com.example.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()

        val peso = binding.inputPeso.text
        val altura = binding.inputAltura.text

        binding.buttonCalculateImc.setOnClickListener {
            if (peso.isNotEmpty() && altura.isNotEmpty()) {
                val pesoDouble = peso.toString().toDouble()
                val alturaDouble = altura.toString().toDouble()
                val imc = String.format("%.2f", viewModel.calcularImc(pesoDouble, alturaDouble)).toDouble()
                val classificacao = viewModel.retornarClassificacao(imc)
                val intent = Intent(this, ResultadoImcActivity::class.java).apply {
                    putExtra("IMC", imc.toString())
                    putExtra("CLASSIFICACAO", classificacao)
                }
                startActivity(intent)
            }
            else {
                Toast.makeText(applicationContext, "Inserir valores", Toast.LENGTH_LONG).show()
            }
        }
    }
}