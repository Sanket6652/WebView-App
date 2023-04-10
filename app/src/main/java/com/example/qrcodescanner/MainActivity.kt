package com.example.qrcodescanner

import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.qrcodescanner.databinding.ActivityMainBinding
import java.net.URL

import com.google.android.gms.vision.CameraSource

class MainActivity : AppCompatActivity() {
    private val CAMERA_PERMISSION_REQUEST_CODE = 100
    private val URL="https://blog.minhazav.dev/research/html5-qrcode"
    private lateinit var webView: WebView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webView = binding.webview
        webView.apply {
            loadUrl(URL)
            webViewClient = WebViewClient()
            webView.settings.javaScriptEnabled = true
            webView.settings.domStorageEnabled = true
            webView.settings.javaScriptCanOpenWindowsAutomatically=true
            webView.settings.builtInZoomControls=true
            webView.settings.allowFileAccess=true
            webView.settings.mediaPlaybackRequiresUserGesture = true
            webView.setWebChromeClient(WebChromeClient())

        }

    }


    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        }
        else {
            super.onBackPressed()
        }
    }

}