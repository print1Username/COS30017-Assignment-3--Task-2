package com.example.cos30017assignment3_task2

import android.content.Context

object EventData {
	fun load(context: Context, type: String): List<Event> {
		val events = mutableListOf<Event>()
		val fields = mutableMapOf<String, String>()
		val requiredFields = setOf("type", "title", "date", "location", "url", "image")

		context.assets.open("data.txt").bufferedReader().useLines { lines ->
			lines.filter { it.isNotBlank() }.forEach { line ->
				val key = line.substringBefore(':').trim()
				val value = line.substringAfter(':').trim()
				fields[key] = value

				if (fields.keys.containsAll(requiredFields)) {
					events.add(
						Event(
							type = fields.getValue("type"),
							title = fields.getValue("title"),
							date = fields.getValue("date"),
							location = fields.getValue("location"),
							url = fields.getValue("url"),
							image = fields.getValue("image")
						)
					)
					fields.clear()
				}
			}
		}

		return events.filter { it.type == type }
	}
}
