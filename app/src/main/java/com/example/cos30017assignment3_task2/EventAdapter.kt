package com.example.cos30017assignment3_task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(
	private val events: List<Event>,
	private val onEventClick: (String) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
	class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val image: ImageView = view.findViewById(R.id.eventImage)
		val date: TextView = view.findViewById(R.id.eventDate)
		val title: TextView = view.findViewById(R.id.eventTitle)
		val location: TextView = view.findViewById(R.id.eventLocation)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
		return EventViewHolder(view)
	}

	override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
		val event = events[position]
		holder.date.text = event.date
		holder.title.text = event.title
		holder.location.text = event.location
		holder.image.contentDescription = event.title
		holder.itemView.setOnClickListener { onEventClick(event.url) }

		val imageName = event.image.substringBeforeLast('.')
		val imageId = holder.itemView.resources.getIdentifier(
			imageName, "drawable", holder.itemView.context.packageName
		)
		if (imageId != 0) {
			holder.image.setImageResource(imageId)
		} else {
			holder.image.setImageDrawable(null)
		}
	}

	override fun getItemCount(): Int = events.size
}
