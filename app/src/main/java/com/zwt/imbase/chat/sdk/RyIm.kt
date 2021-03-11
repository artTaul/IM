package com.zwt.imbase.chat.sdk

import android.content.Context
import android.util.Log
import com.zwt.imbase.chat.ImBaseHelper
import com.zwt.imbase.chat.ImCallBack
import com.zwt.imbase.chat.bean.MessageData

/**
 * 具体三方业务
 */
class RyIm : ImBaseHelper() {

    override fun initIM(context: Context, key: String) {
        Log.e("RyIm", "融云IM初始化成功")
    }

    override fun isLogin(): Boolean {
        return true
    }

    override fun login(imCallBack: ImCallBack?) {
        Log.e("RyIm", "登录")
    }

    override fun loginOut(imCallBack: ImCallBack?) {
        Log.e("RyIm", "退出登录")
    }

    override fun sendMessage(msg: MessageData) {
        Log.e("RyIm", "发送消息")
    }

}