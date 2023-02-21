package com.clusterdev.malayalamkeyboar.uimain

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.*
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.clusterdev.malayalamkeyboar.DedMvvm
import com.clusterdev.malayalamkeyboar.R
import com.clusterdev.malayalamkeyboar.golk.DedEst
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebConst : AppCompatActivity() {

    private var tyyop: ValueCallback<Array<Uri>>? = null
    private val dfol =
        registerForActivityResult(ActivityResultContracts.GetMultipleContents()) {
            tyyop?.onReceiveValue(it.toTypedArray())
        }

    private lateinit var wab: WebView
    private lateinit var fol:LottieAnimationView

    private val vb by viewModels<DedMvvm>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_const)

        wab = findViewById(R.id.eip)
        fol = findViewById(R.id.uop)
        wab.loadUrl(intent.getStringExtra("deda")!!)
        wab.settings.domStorageEnabled = true
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (wab.canGoBack()) wab.goBack()
            }
        })
        wab.settings.userAgentString =
            wab.settings.userAgentString.replace("wv", "")
        wab.settings.javaScriptEnabled = true
        CookieManager.getInstance().setAcceptCookie(true)
        wab.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                this@WebConst.tyyop = filePathCallback
                dfol.launch("image/*")
                return true
            }
        }
        CookieManager.getInstance().setAcceptThirdPartyCookies(wab, true)

        wab.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String) {
                super.onPageFinished(view, url)
                CookieManager.getInstance().flush()
                if (url == "https://cleolife.online/"){
                    vb.workGoogleIndia(url,application)
                    startActivity(Intent(this@WebConst, DedEst::class.java))
                    finish()
                }else{
                    fol.visibility = View.GONE
                    wab.visibility = View.VISIBLE
                    CookieManager.getInstance().flush()
                    vb.workGameGolDeda(application,url)
                }
            }
        }
    }
}