package com.berrypay.global.kyc_sdk

import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel
import com.wiseai.ekyc110.*

class MainActivity : FlutterActivity() {

    private val CHANNEL = "com.wiseai.ekyc"
    private lateinit var wiseAiApp: WiseAiApp
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        val messenger: BinaryMessenger = flutterEngine.dartExecutor.binaryMessenger
        val methodChannel = MethodChannel(messenger, CHANNEL)
        methodChannel.setMethodCallHandler { call, result ->
            when (call.method) {
                "initialize" -> {
                    val token = call.argument<String>("token")
                    val urlEndpoint = call.argument<String>("urlEndpoint")
                    if (token != null) {
                        if (urlEndpoint != null) {
                            initializeWiseAI(token, urlEndpoint)
                        }
                    }
                    result.success(null)
                }
                else -> {
                    result.notImplemented()
                }
            }
        }
    }

    private fun initializeWiseAI(token: String, urlEndpoint: String) {
        wiseAiApp = WiseAiApp()
        wiseAiApp.init(this, token, urlEndpoint)
    }

}
