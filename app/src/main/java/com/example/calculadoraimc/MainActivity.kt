package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import com.example.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()

        val peso = binding.inputPeso.toString()
        val altura = binding.inputAltura.toString()

        binding.buttonCalculateImc.setOnClickListener {
            if (peso != "" && altura != "") {
                val pesoDouble = peso.toDouble()
                val alturaDouble = altura.toDouble()
                val imc = viewModel.calcularImc(pesoDouble, alturaDouble)
                Toast.makeText(applicationContext, "IMC: ${imc}", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(applicationContext, "Inserir valores", Toast.LENGTH_LONG).show()
            }
        }
    }
}