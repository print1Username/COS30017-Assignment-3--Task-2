package com.example.cos30017assignment3_task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

class EventWebViewFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View = inflater.inflate(R.layout.fragment_event_webview, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		val webView = view.findViewById<WebView>(R.id.eventWebView)
		webView.webViewClient = WebViewClient()
		webView.settings.javaScriptEnabled = true
		webView.loadUrl(requireArguments().getString(ARG_URL).orEmpty())
	}

	companion object {
		private const val ARG_URL = "url"

		fun newInstance(url: String): EventWebViewFragment = EventWebViewFragment().apply {
			arguments = Bundle().apply { putString(ARG_URL, url) }
		}
	}
}
