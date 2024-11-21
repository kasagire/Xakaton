package com.example.studenteventsapp

import Interest
import InterestsAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenteventsapp.R
class InterestActivity : AppCompatActivity() {

    private lateinit var interestsRecyclerView: RecyclerView
    private lateinit var interestsAdapter: InterestsAdapter
    private val interestsList = listOf(
        Interest(1, "Наука"),
        Interest(2, "Спорт"),
        Interest(3, "Искусство"),
        // Добавьте другие интересы
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest)

        interestsRecyclerView = findViewById(R.id.interestsRecyclerView)
        interestsAdapter = InterestsAdapter(interestsList) { interest ->
            // Логика обработки выбора интереса
        }
        interestsRecyclerView.adapter = this.interestsAdapter
        interestsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}