package com.example.homework


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counter.text =counter.toString()
        binding.minus.isEnabled = false


        binding.plus.setOnClickListener {
            if (counter == 49){
                binding.mainText.text = "Все места в автобусе заняты"
                binding.mainText.setTextColor(Color.RED)
                binding.plus.isEnabled = false
                counter++
                binding.reset.visibility = View.VISIBLE
            }else{
                val res = 50 - counter
                counter++
                binding.mainText.text = "Осталось мест ${res}"
                binding.mainText.setTextColor(Color.BLUE)
                binding.minus.isEnabled = true
            }
            binding.counter.text =counter.toString()
        }

        binding.minus.setOnClickListener {
            if (counter ==1){
                counter--
                binding.mainText.text = "Все места свободны"
                binding.mainText.setTextColor(Color.GREEN)
                binding.minus.isEnabled = false
            }else{
                val res = 50 - counter
                binding.mainText.text = "Осталось мест ${res}"
                binding.mainText.setTextColor(Color.BLUE)
                counter--
                binding.plus.isEnabled = true
            }
            binding.counter.text =counter.toString()
        }

        binding.reset.setOnClickListener {
            counter =0
            binding.counter.text =counter.toString()
            binding.minus.isEnabled = false
            binding.mainText.text = "Все места свободны"
            binding.mainText.setTextColor(Color.GREEN)
            binding.plus.isEnabled = true
        }
    }
}