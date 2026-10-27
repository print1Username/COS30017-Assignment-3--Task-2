package com.example.cos30017assignment3_task2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(R.layout.activity_main)
		val viewPager = findViewById<ViewPager2>(R.id.viewPager)
		val webContainer = findViewById<View>(R.id.webContainer)
		viewPager.adapter = EventPagerAdapter(this)
		val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
		TabLayoutMediator(tabLayout, viewPager) { tab, position ->
			tab.setText(if (position == 0) R.string.social_event else R.string.professional_event)
		}.attach()
		supportFragmentManager.addOnBackStackChangedListener {
			val showingWeb = supportFragmentManager.backStackEntryCount > 0
			viewPager.visibility = if (showingWeb) View.GONE else View.VISIBLE
			webContainer.visibility = if (showingWeb) View.VISIBLE else View.GONE
		}
		tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
			override fun onTabSelected(tab: TabLayout.Tab) {
				if (supportFragmentManager.backStackEntryCount > 0) {
					supportFragmentManager.popBackStack()
				}
			}

			override fun onTabUnselected(tab: TabLayout.Tab) = Unit
			override fun onTabReselected(tab: TabLayout.Tab) = Unit
		})
		val showingWeb = supportFragmentManager.backStackEntryCount > 0
		viewPager.visibility = if (showingWeb) View.GONE else View.VISIBLE
		webContainer.visibility = if (showingWeb) View.VISIBLE else View.GONE
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
	}

	fun openEvent(url: String) {
		supportFragmentManager.beginTransaction()
			.replace(R.id.webContainer, EventWebViewFragment.newInstance(url))
			.addToBackStack(null)
			.commit()
	}
}
