package com.example.studenteventsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InterestSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest_selection)

        // Кнопки для выбора интереса
        val buttonScience = findViewById<Button>(R.id.buttonScience)
        val buttonSport = findViewById<Button>(R.id.buttonSport)
        val buttonArt = findViewById<Button>(R.id.buttonArt)

        // Обработчики нажатия для кнопок
        buttonScience.setOnClickListener {
            openRecommendedEvents("Наука")
        }

        buttonSport.setOnClickListener {
            openRecommendedEvents("Спорт")
        }

        buttonArt.setOnClickListener {
            openRecommendedEvents("Искусство")
        }
    }

    private fun openRecommendedEvents(interest: String) {
        val intent = Intent(this, RecommendedEventsActivity::class.java)
        intent.putExtra("interest", interest)  // Передаем выбранную категорию
        startActivity(intent)
    }
}
