package com.bigshot.flutter_gtpush.service

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.bigshot.flutter_gtpush.NotificationUtil
import com.igexin.sdk.GTIntentService
import com.igexin.sdk.message.GTCmdMessage
import com.igexin.sdk.message.GTNotificationMessage
import com.igexin.sdk.message.GTTransmitMessage


class MyIntentService : GTIntentService() {

    /**
     * 收到推送消息
     */
    override fun onReceiveMessageData(context: Context?, message: GTTransmitMessage?) {
        val appId: String = message!!.appid
        val taskId: String = message!!.taskId
        val messageId: String = message!!.messageId
        val payload: ByteArray = message!!.payload
        val pkg: String = message!!.pkgName
        val cid: String = message!!.clientId

//        NotificationUtil.showNotification(context!!, "测试推送", "这是一条测试消息。。。$messageId")
        Toast.makeText(context, "fffff$messageId", Toast.LENGTH_SHORT).show()
    }

    override fun onNotificationMessageArrived(context: Context?, p1: GTNotificationMessage?) {
    }

    override fun onReceiveServicePid(context: Context?, p1: Int) {
    }

    override fun onNotificationMessageClicked(context: Context?, p1: GTNotificationMessage?) {
    }

    override fun onReceiveCommandResult(context: Context?, p1: GTCmdMessage?) {
    }

    /**
     * 收到clientId
     */
    override fun onReceiveClientId(context: Context?, clientId: String?) {
        Log.d(TAG, "onReceiveClientId$clientId")
        val intent = Intent("com.example.communication.RECEIVER")
        intent.putExtra("clientId", clientId)
        sendBroadcast(intent)
    }

    override fun onReceiveOnlineState(context: Context?, p1: Boolean) {
    }
}