package com.zwt.imbase.chat

interface ImCallBack {

    fun onSuccess()

    fun onError()

    fun getTotalUnreadCount(totalUnreadCount: Int): Int {
        return totalUnreadCount
    }

    fun saveGroupUnreadCount(id: String, unreadCount: Int) {

    }

}