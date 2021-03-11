package com.zwt.imbase.chat

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.zwt.imbase.chat.bean.MessageEventData
import com.zwt.imbase.evnet.EventBusUtil
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class ImBaseActivity : Activity() {
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        ImBaseHelper.getInstance(ImUtil.RY_TYPE).initIM(this, ImUtil.RY_KEY)
        EventBusUtil.register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEventData) {
        onReceiveIMEvent(event)
    }

    override fun onResume() {
        super.onResume()
        ImBaseHelper.getInstance(ImUtil.RY_TYPE).login(null)
    }

    abstract fun onReceiveIMEvent(event: MessageEventData)

    override fun onDestroy() {
        super.onDestroy()
        EventBusUtil.unregister(this)
    }

}