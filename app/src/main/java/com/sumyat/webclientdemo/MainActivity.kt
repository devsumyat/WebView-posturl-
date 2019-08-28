package com.sumyat.webclientdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://devsumyat.github.io/"
        val postData = "postkey=value1&postkey=value2"

        val webv = findViewById<View>(R.id.webview) as WebView
        webv.settings.javaScriptEnabled = true
        webv.settings.useWideViewPort = true
        webv.settings.builtInZoomControls = true

        webv.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        webv.postUrl(url, postData.toByteArray())
    }
}
