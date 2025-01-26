package com.example.mswdoapp

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webview)
        val backButton = findViewById<Button>(R.id.back_button)

        // Enable JavaScript for the WebView
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true // Enable JavaScript
        webSettings.setSupportZoom(true) // Allow zooming
        webSettings.builtInZoomControls = true // Enable zoom controls
        webSettings.displayZoomControls = false // Hide zoom controls
        webSettings.loadWithOverviewMode = true // Scale to fit WebView's width
        webSettings.useWideViewPort = true // Use wide viewport
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW // Allow mixed content (HTTP and HTTPS)
        webView.webViewClient = WebViewClient() // Handle links within WebView
        // Handle links within the WebView


        // Load your Laravel website URL
        webView.clearCache(true)
        webView.clearHistory()
        webView.loadUrl("http://192.168.188.128:8000")

        // Set click listener for the back button
        backButton.setOnClickListener {
            // Go back in WebView history if possible, otherwise finish the activity
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                finish()  // Exit the activity if no history to go back to
            }
        }
    }
}
