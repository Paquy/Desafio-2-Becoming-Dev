package com.example.desafio2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio2.databinding.ActivitySegundaTelaBinding

private lateinit var binding: ActivitySegundaTelaBinding
class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i=intent.extras
        var result= i!!.getDouble("Resultado")
        binding.tvResultado.setText(String.format("%.2f",result))

        IMC(result)

        binding.itBack.setOnClickListener{
            var voltarTela : Intent = Intent(this, MainActivity::class.java)
            startActivity(voltarTela)
        }

    }

    private fun IMC(result: Double) {
        var grau: Double = result
        when (grau) {
            in grau..18.5 -> {
                binding.tvGrau.text = "Leve"
                binding.tvSobre.text = getString(R.string.pesoLeve)
            }
            in grau..24.9 -> {
                binding.tvGrau.text = "Normal"
                binding.tvSobre.text = getString(R.string.pesoNormal)
            }
            in grau..29.9 -> {
                binding.tvGrau.text = "Sobre Peso"
                binding.tvSobre.text = getString(R.string.pesoAcima)
            }
            in grau..40.0 -> {
                binding.tvGrau.text = "Obesidade"
                binding.tvSobre.text = getString(R.string.obesidade)
            }
            else -> {
                binding.tvGrau.text = "Obesidade Grave"
                binding.tvSobre.text = getString(R.string.obesidadeGrave)
            }
        }
    }
}
