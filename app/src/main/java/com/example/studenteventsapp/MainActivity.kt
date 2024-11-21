package com.example.studenteventsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Кнопки для перехода на экраны интересов и мероприятий
        val buttonInterests = findViewById<Button>(R.id.buttonInterests)
        val buttonEvents = findViewById<Button>(R.id.buttonEvents)

        buttonInterests.setOnClickListener {
            val intent = Intent(this, InterestActivity::class.java)
            startActivity(intent)
        }

        buttonEvents.setOnClickListener {
            val intent = Intent(this, EventActivity::class.java)
            startActivity(intent)
        }
    }
}