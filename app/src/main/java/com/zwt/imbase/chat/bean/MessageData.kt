package com.zwt.imbase.chat.bean

/**
 * 消息类 可扩展
 */
open class MessageData {
    /**
     * 聊天类型 群聊单聊
     */
    var chatType = 0

    /**
     * 消息类型
     */
    var msgType: Int = 0

    /**
     * 消息文本
     */
    var msgText: String? = null

    /**
     * 图片消息地址
     */
    var msgImageUrl: String? = null

    /**
     * 语音消息地址
     */
    var msgVoiceUrl: String? = null

    /**
     * 语音消息时长
     */
    var msgVoiceDuration: String? = null

    /**
     * 发送者信息 可以是json串
     */
    var from: String? = null

    /**
     * 消息Id
     */
    var msgId: String? = null

    /**
     * 接收者信息 可以是json串
     */
    var to: String? = null

    /**
     * 时间戳
     */
    var timestamp: Long = 0

    /**
     * 消息状态
     */
    var msgStatus: Int = 0
}