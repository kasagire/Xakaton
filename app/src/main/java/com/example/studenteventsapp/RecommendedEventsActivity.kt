package com.example.studenteventsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class RecommendedEventsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventAdapter
    private var selectedInterest: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommended_events)

        // Получаем переданный интерес
        selectedInterest = intent.getStringExtra("interest")

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EventAdapter(emptyList())
        recyclerView.adapter = adapter

        loadRecommendedEvents()
    }

    private fun loadRecommendedEvents() {
        val url = "http://192.168.0.72:5000/events" // URL для получения всех мероприятий

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@RecommendedEventsActivity, "Ошибка подключения к серверу", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val responseData = response.body?.string()
                    if (responseData != null) {
                        val events = Gson().fromJson(responseData, Array<Event>::class.java).toList()

                        // Фильтруем мероприятия по выбранному интересу
                        val filteredEvents = events.filter { it.interest == selectedInterest }

                        runOnUiThread {
                            adapter.updateData(filteredEvents)
                        }
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(this@RecommendedEventsActivity, "Ошибка на сервере: ${response.code}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}
