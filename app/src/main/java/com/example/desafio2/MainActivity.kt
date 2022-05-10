package com.example.desafio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.SeekBar
import android.widget.Toast
import com.example.desafio2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var calculoAltura : Double = 0.0
    private var calculoPeso : Double = 0.0

    var calculo: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        seekBarProgressHeight()
        seekBarProgressWeight()




        binding.btResult.setOnClickListener{
            var segundaTela : Intent = Intent(this, SegundaTela::class.java)
            var b = Bundle()
            calculo = (calculoPeso / (calculoAltura * calculoAltura))
            b.putDouble("Resultado",calculo)
            segundaTela.putExtras(b)
            startActivity(segundaTela)
        }

    }

    private fun seekBarProgressHeight() {
        binding.sbProgressHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                calculoAltura = progress.toDouble()/100
                binding.tvHeight.text = "Altura: $calculoAltura m"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun seekBarProgressWeight() {
        binding.sbProgressWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                calculoPeso = progress.toDouble()/100
                binding.tvWeight.text = "Peso: $calculoPeso kg"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}