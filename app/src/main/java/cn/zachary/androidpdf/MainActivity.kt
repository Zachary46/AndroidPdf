package cn.zachary.androidpdf

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        initWebSettings()
        var url = "http://xxxx"
        //wv.loadUrl("file:///android_asset/mypdf.html?pdfpath=" + url)
        wv.loadUrl("file:///android_asset/mypdf.html?pdfpath="+"http://housing.dev.shangyouth.com/api/resource/8a80807d6a4def9e016a4e5ca6040003")
    }

    private fun initWebSettings() {
        //去掉横向滚动条
        wv.setHorizontalScrollBarEnabled(false)
        //去掉纵向滚动条
        wv.setVerticalScrollBarEnabled(false)

        val webSettings = wv!!.settings ?: return
        //设置字体缩放倍数，默认100
        webSettings.textZoom = 100
        // 支持 Js 使用
        webSettings.javaScriptEnabled = true
        // 开启DOM缓存
        webSettings.domStorageEnabled = true
        // 开启数据库缓存
        webSettings.databaseEnabled = true
        // 支持启用缓存模式
        webSettings.setAppCacheEnabled(true)
        // 设置 AppCache 最大缓存值(现在官方已经不提倡使用，已废弃)
        webSettings.setAppCacheMaxSize((8 * 1024 * 1024).toLong())
        // Android 私有缓存存储，如果你不调用setAppCachePath方法，WebView将不会产生这个目录
        webSettings.setAppCachePath(cacheDir.absolutePath)
        // 关闭密码保存提醒功能
        webSettings.savePassword = false
        // 支持缩放
        webSettings.setSupportZoom(true)
        //设置内置的缩放控件
        webSettings.setBuiltInZoomControls(true)
        //不显示webview缩放按钮
        webSettings.setDisplayZoomControls(false);
        // 设置 UserAgent 属性
        webSettings.userAgentString = ""
        // 允许加载本地 html 文件/false
        webSettings.allowFileAccess = true
    }
}
