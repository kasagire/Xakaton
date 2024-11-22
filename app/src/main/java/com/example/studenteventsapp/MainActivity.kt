package com.example.studenteventsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Кнопка для перехода на экран выбора интереса
        val buttonInterests = findViewById<Button>(R.id.buttonInterests)
        buttonInterests.setOnClickListener {
            val intent = Intent(this@MainActivity, InterestSelectionActivity::class.java)
            startActivity(intent)
        }

        // Кнопка для перехода на экран с мероприятиями
        val openEventButton = findViewById<Button>(R.id.buttonEvents)
        openEventButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ActivityEvent::class.java)
            startActivity(intent)
        }
    }
}