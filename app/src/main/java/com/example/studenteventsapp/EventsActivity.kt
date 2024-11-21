package com.example.studenteventsapp


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventActivity : AppCompatActivity() {

    private lateinit var eventsRecyclerView: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter
    private val eventsList = mutableListOf<Event>()
    private val BASE_URL = "http://192.168.56.1:5000/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        eventsRecyclerView = findViewById(R.id.eventsRecyclerView)
        eventsAdapter = EventsAdapter(eventsList, this)
        eventsRecyclerView.adapter = eventsAdapter
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)

        fetchEvents()
    }

    private fun fetchEvents() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        /*apiService.getEvents().enqueue(object : Callback<List<Event>> {
            override fun onResponse(call: Call<List<Event>>,response: Response<List<Event>>) {
                if (response.isSuccessful) {
                    response.body()?.let { events ->
                        eventsList.clear()
                        eventsList.addAll(events)
                        eventsAdapter.notifyDataSetChanged()
                    } ?: run {
                        Log.e("EventActivity", "Response body is null")
                    }
                } else {
                    Log.e("EventActivity", "Error fetching events: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                Log.e("EventActivity", "Failure fetching events", t)
            }
        })*/

    }
    fun onEventClick(event: Event) {

        val intent = Intent(this, EventDetailsActivity::class.java).apply {
            putExtra("EVENT_ID", event.id)
        }
        startActivity(intent)
    }
}