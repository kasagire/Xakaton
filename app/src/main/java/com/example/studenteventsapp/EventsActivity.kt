package com.example.studenteventsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenteventsapp.R
class EventsActivity : AppCompatActivity() {

    private lateinit var recyclerViewEvents: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        recyclerViewEvents = findViewById(R.id.recyclerViewEvents)

        // Настройка RecyclerView с адаптером (не забудьте создать адаптер)
        recyclerViewEvents.layoutManager = LinearLayoutManager(this)

        // Здесь вы можете установить адаптер и передать данные о мероприятиях
    }
}