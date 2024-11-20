package com.example.studenteventsapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.studenteventsapp.databinding.ActivitySelectInterestsBinding // Импортируйте сгенерированный класс ViewBinding

class SelectInterestsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectInterestsBinding // Объявите переменную для ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectInterestsBinding.inflate(layoutInflater) // Инициализируйте ViewBinding
        setContentView(binding.root) // Установите корневой вид

        binding.submitInterestsButton.setOnClickListener { // Используйте ViewBinding для доступа к элементам
            val interests = mutableListOf<String>()
            if (binding.sportsCheckBox.isChecked) interests.add("Спорт")
            if (binding.cultureCheckBox.isChecked) interests.add("Культура")
            if (binding.scienceCheckBox.isChecked) interests.add("Наука")

            // Передача выбранных интересов в EventsActivity
            val intent = Intent(this, EventsActivity::class.java).apply {
                putExtra("INTERESTS", interests.toTypedArray())
            }
            startActivity(intent)
            finish() // Закрыть текущую активность, если не нужно возвращаться
        }
    }
}