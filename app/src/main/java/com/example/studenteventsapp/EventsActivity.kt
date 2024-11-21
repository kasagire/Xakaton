package com.example.studenteventsapp

import com.example.studenteventsapp.EventAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class ActivityEvent : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        // Настройка RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EventAdapter(emptyList())
        recyclerView.adapter = adapter

        // Загрузка мероприятий
        loadEvents()
    }

    fun loadEvents() {
        val url = "http://127.0.0.1:5000/events"

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@ActivityEvent, "Ошибка подключения к серверу", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val responseData = response.body?.string()
                    if (responseData != null) {
                        val events = Gson().fromJson(responseData, Array<Event>::class.java).toList()
                        runOnUiThread {
                            adapter.updateData(events)
                        }
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(this@ActivityEvent, "Ошибка на сервере: ${response.code}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}
