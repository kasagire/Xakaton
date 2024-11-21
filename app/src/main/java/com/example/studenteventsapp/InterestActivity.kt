package com.example.studenteventsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InterestActivity : AppCompatActivity() {

    private lateinit var interestsRecyclerView: RecyclerView
    private lateinit var interestsAdapter: InterestsAdapter
    private val interestsList = listOf(
        Interest(1, "Наука"),
        Interest(2, "Спорт"),
        Interest(3, "Искусство"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest)

        interestsRecyclerView = findViewById(R.id.interestsRecyclerView)
        interestsAdapter = InterestsAdapter(interestsList, this)
        interestsRecyclerView.adapter = this.interestsAdapter
        interestsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun onInterestClick(interest: Interest) {
        Toast.makeText(this, "Вы выбрали интерес: ${interest.name}", Toast.LENGTH_SHORT).show()

    }
}
