package com.bigshot.flutter_gtpush

import android.app.Activity
import android.widget.Toast
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterGtpushPlugin(private var activity: Activity) : MethodCallHandler {
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "flutter_gtpush")
            channel.setMethodCallHandler(FlutterGtpushPlugin(registrar.activity()))
        }
    }

    private fun getCurrentActivity(): Activity {
        return activity
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        when (call.method) {
            "getPlatformVersion" -> result.success("Android ${android.os.Build.VERSION.RELEASE}")
            "getClientId" -> result.success("clientId=454564564564564556165")
            "showToast" -> {
                Toast.makeText(getCurrentActivity(), "ToastAndroid", Toast.LENGTH_SHORT).show()
            }
            else -> result.notImplemented()
        }
    }
}
