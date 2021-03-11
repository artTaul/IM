package com.zwt.imbase.chat.sdk

import android.content.Context
import com.zwt.imbase.chat.ImBaseHelper
import com.zwt.imbase.chat.ImCallBack
import com.zwt.imbase.chat.bean.MessageData

class HxIm : ImBaseHelper() {

    override fun initIM(context: Context, key: String) {

    }

    override fun isLogin(): Boolean {
        return true
    }

    override fun login(imCallBack: ImCallBack?) {

    }

    override fun loginOut(imCallBack: ImCallBack?) {

    }

    override fun sendMessage(msg: MessageData) {

    }
}