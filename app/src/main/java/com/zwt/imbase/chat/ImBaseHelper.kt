package com.zwt.imbase.chat

import android.content.Context
import com.zwt.imbase.chat.bean.MessageData
import com.zwt.imbase.chat.sdk.HxIm
import com.zwt.imbase.chat.sdk.RyIm

abstract class ImBaseHelper {

    companion object {
        var type: Int = 0
        private var instance: ImBaseHelper? = null
            get() {
                if (field == null) {
                    when (type) {
                        ImUtil.RY_TYPE -> field = RyIm()
                        ImUtil.HX_TYPE -> field = HxIm()
                    }
                }
                return field
            }

        fun getInstance(type: Int): ImBaseHelper {
            this.type = type
            return instance!!
        }
    }

    abstract fun initIM(context: Context, key: String)

    abstract fun isLogin(): Boolean

    abstract fun login(imCallBack: ImCallBack?)

    abstract fun loginOut(imCallBack: ImCallBack?)

    abstract fun sendMessage(msg: MessageData)


}