package com.bigshot.flutter_gtpush

import android.app.Activity
import android.widget.Toast
import com.bigshot.flutter_gtpush.service.MyIntentService
import com.bigshot.flutter_gtpush.service.MyPushService
import com.igexin.sdk.PushManager
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

    /**
     * 初始化SDK
     */
    private fun init() {
        //初始化个推SDK
        PushManager.getInstance().initialize(activity.applicationContext, MyPushService::class.java)
        //注册第三方服务
        PushManager.getInstance().registerPushIntentService(activity.applicationContext, MyIntentService::class.java)
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
