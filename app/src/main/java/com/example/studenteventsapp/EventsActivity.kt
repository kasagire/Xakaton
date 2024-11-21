package com.example.studenteventsapp

import Event
import EventsAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenteventsapp.R
class EventActivity : AppCompatActivity() {

    private lateinit var eventsRecyclerView: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter
    private val eventsList = mutableListOf<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        eventsRecyclerView = findViewById(R.id.eventsRecyclerView)
        eventsAdapter = EventsAdapter(eventsList)
        eventsRecyclerView.adapter = eventsAdapter
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)

        fetchEvents()
    }

    private fun fetchEvents() {
        // Здесь должен быть вызов API для получения списка мероприятий
        // Пример статических данных:
        eventsList.add(Event(1, "Научная конференция", "Внутри ВУЗа", "2024-12-01", "Описание мероприятия"))
        eventsList.add(Event(2, "Спортивные соревнования", "Городские", "2024-12-05", "Описание мероприятия"))

        eventsAdapter.notifyDataSetChanged()
    }
}