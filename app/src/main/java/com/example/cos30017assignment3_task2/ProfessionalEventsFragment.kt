package com.example.cos30017assignment3_task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ProfessionalEventsFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View = inflater.inflate(R.layout.fragment_event_list, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		val eventList = view.findViewById<RecyclerView>(R.id.eventList)
		eventList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
		eventList.adapter = EventAdapter(EventData.load(requireContext(), "professional"))
	}
}
