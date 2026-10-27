package com.example.cos30017assignment3_task2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class EventPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
	override fun getItemCount(): Int = 2

	override fun createFragment(position: Int): Fragment =
		if (position == 0) SocialEventsFragment() else ProfessionalEventsFragment()
}
