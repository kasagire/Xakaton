package com.example.studenteventsapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnEventClickListener {
    fun onEventClick(event: Event)
}
class EventsAdapter(private val events: List<Event>, private val listener: EventActivity) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Event) {
            itemView.findViewById<TextView>(R.id.eventTitle).text = event.title
            itemView.findViewById<TextView>(R.id.eventCategory).text = event.category
            itemView.findViewById<TextView>(R.id.eventDate).text = event.date
            itemView.setOnClickListener {
                listener.onEventClick(event)
                // Логика обработки нажатия на мероприятие
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size
}