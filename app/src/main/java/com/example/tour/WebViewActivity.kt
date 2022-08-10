package com.example.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.tour.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var v: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(v.root)
        setSupportActionBar(v.toolBar)

        val imageUrl = intent.getStringExtra("url")

        val myWebView = v.webView
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl(imageUrl!!)

        if(supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        v.toolBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}