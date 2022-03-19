package com.example.calculadoraimc

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun calcularImc(peso: Double, altura: Double): Double {
        return peso / (altura * altura)
    }

    fun retornarClassificacao(imc: Double): String {
        return when {
            imc < 16.0 -> "Magreza grave"
            imc >= 16.0 && imc < 17.0 -> "Magreza moderada"
            imc >= 17.0 && imc < 18.5 -> "Magreza leve"
            imc >= 18.5 && imc < 25.0 -> "Saudável"
            imc >= 25.0 && imc < 30.0 -> "Sobrepeso"
            imc >= 30.0 && imc < 35.0 -> "Obesidade Grau I"
            imc >= 35.0 && imc < 40.0 -> "Obesidade Grau II (severa)"
            else -> "Obesidade Grau III (mórbida)"
        }
    }

}