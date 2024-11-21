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
        buttonInterests.setOnClickListener {
            val intent = Intent(this@MainActivity, InterestActivity::class.java)

            startActivity(intent)
        }

        val openEventButton = findViewById<Button>(R.id.buttonEvents)
        openEventButton.setOnClickListener {
            // Start EventActivity when the button is clicked
            val intent = Intent(this@MainActivity, ActivityEvent::class.java)
            startActivity(intent)
        }
       }
}