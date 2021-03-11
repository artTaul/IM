package com.zwt.imbase.evnet

import org.greenrobot.eventbus.EventBus

object EventBusUtil {
    fun register(`object`: Any?) {
        try {
            EventBus.getDefault().register(`object`)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    fun unregister(`object`: Any?) {
        try {
            EventBus.getDefault().unregister(`object`)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    fun post(`object`: Any?) {
        try {
            EventBus.getDefault().post(`object`)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    /**
     * 黏性事件
     * 先发布事件，后订阅  接收注解处 加 sticky = true
     * 例如 @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
     *
     * @param object
     */
    fun postSticky(`object`: Any?) {
        try {
            EventBus.getDefault().postSticky(`object`)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    /**
     * 终止事件
     *
     * @param object
     */
    fun cancelEventDelivery(`object`: Any?) {
        try {
            EventBus.getDefault().cancelEventDelivery(`object`)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    /**
     * 移除某一粘性事件
     *
     * @param object
     */
    fun removeStickyEvent(`object`: Any?) {
        try {
            EventBus.getDefault().removeStickyEvent(`object`)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    /**
     * 移除所有粘性事件
     */
    fun removeAllStickyEvents() {
        try {
            EventBus.getDefault().removeAllStickyEvents()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    /**
     * 是否有订阅事件
     */
    fun hasSubscriberForEvent(eventClass: Class<*>?): Boolean {
        var hasSubscriber = false
        try {
            hasSubscriber = EventBus.getDefault().hasSubscriberForEvent(eventClass)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return hasSubscriber
    }
}