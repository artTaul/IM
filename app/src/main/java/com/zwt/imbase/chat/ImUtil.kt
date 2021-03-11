package com.zwt.imbase.chat

import android.app.Activity
import android.view.inputmethod.InputMethodManager

class ImUtil {
    companion object {
        /**
         * 三方key
         */
        const val RY_KEY = "三方的key"

        /**
         * chat类型
         */
        const val CHAT_SINGLE = 0
        const val CHAT_GROUP = 0

        /**
         * 消息类型
         */
        const val MSG_EMPTY = 0
        const val MSG_TEXT = 1
        const val MSG_IMAGE = 2
        const val MSG_VOICE = 3

        /**
         * 三方实现方案类型
         */
        const val RY_TYPE = 0
        const val HX_TYPE = 1

        fun hideSoftKeyboard(activity: Activity) {
            val view = activity.currentFocus
            if (view != null) {
                val inputMethodManager: InputMethodManager = activity.getSystemService(
                    Activity.INPUT_METHOD_SERVICE
                ) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(
                    view.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }
        }

    }
}