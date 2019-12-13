package com.bigshot.flutter_gtpush.service

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver(activity: Activity) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val tag = "MyReceiver"
        //发送clientId
        val clientId = intent!!.getStringExtra("clientId")
        Log.d(tag, "接受到广播$clientId")
//        FlutterPluginSend.sendMsg(flutterView, clientId);
        //        FlutterPluginSend.sendMsg(flutterView, clientId);
    }
}