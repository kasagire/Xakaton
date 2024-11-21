package com.example.studenteventsapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EventDetailsActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var categoryTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var descriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)

        titleTextView = findViewById(R.id.eventTitleText)
        categoryTextView = findViewById(R.id.eventCategoryText)
        dateTextView = findViewById(R.id.eventDateText)
        descriptionTextView = findViewById(R.id.eventDescriptionText)

        val eventId = intent.getIntExtra("EVENT_ID", -1)


        if (eventId != -1) {
            titleTextView.text = "Mock Title for Event $eventId"
            categoryTextView.text = "Mock Category"
            dateTextView.text = "2024-12-01"
            descriptionTextView.text = "This is a detailed description of the event."
        }
    }
}
