package com.zwt.imbase.chat.widget

import android.content.Context
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.zwt.imbase.chat.adapter.ChatAdapter
import com.zwt.imbase.chat.bean.MessageData
import com.zwt.imbase.chat.bean.TimeInfo
import java.text.SimpleDateFormat
import java.util.*

abstract class ChatItemBaseView<E : ViewDataBinding>(
    context: Context,
    var adapter: ChatAdapter
) : BaseLazyLinearLayout<E>(context) {

    lateinit var messageData: MessageData
    var position: Int = 0
    private lateinit var itemClickListener: ChatItemClickListener

    fun setUpView(
        messageData: MessageData,
        position: Int,
        itemClickListener: ChatItemBaseView.ChatItemClickListener
    ) {
        this.messageData = messageData
        this.position = position
        this.itemClickListener = itemClickListener
        setUpItemView()
    }

    abstract fun setUpItemView()

    fun setTimestamp(timestamp: TextView?) {
        timestamp?.let {
            if (position == 0) {
                it.text = "1秒钟"
            } else {
                var preMsgData = adapter.getItem(position - 1)
                preMsgData?.let {
                    if (isCloseEnough(messageData.timestamp, preMsgData.timestamp)) {
                        timestamp.visibility = GONE
                    } else {
                        timestamp.text = getConsultChartTime(messageData.timestamp)
                        timestamp.visibility = visibility
                    }
                }
            }
        }
    }

    private fun isCloseEnough(timestamp1: Long, timestamp2: Long): Boolean {
        var timestamp3 = timestamp2 - timestamp1
        if (timestamp3 < 0L) {
            timestamp3 = -timestamp3
        }
        return timestamp3 < 30000L;
    }

    open fun getConsultChartTime(timestamp: Long): String? {
        return when {
            isSameDay(timestamp) -> {
                SimpleDateFormat("HH:mm", Locale.getDefault()).format(timestamp)
            }
            isSameYear(timestamp) -> {
                SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(timestamp)
            }
            else -> {
                SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(timestamp)
            }
        }
    }

    open fun isSameDay(timestamp: Long): Boolean {
        val timeInfo: TimeInfo = getTodayStartAndEndTime()
        return timestamp > timeInfo.startTime && timestamp < timeInfo.endTime
    }

    open fun isSameYear(timestamp: Long): Boolean {
        val start = Calendar.getInstance()
        start.timeInMillis = System.currentTimeMillis()
        val curYear = start[Calendar.YEAR]
        start.timeInMillis = timestamp
        val year = start[Calendar.YEAR]
        return year == curYear
    }

    open fun getTodayStartAndEndTime(): TimeInfo {
        val start = Calendar.getInstance()
        start[Calendar.HOUR_OF_DAY] = 0
        start[Calendar.MINUTE] = 0
        start[Calendar.SECOND] = 0
        start[Calendar.MILLISECOND] = 0
        val end = Calendar.getInstance()
        end[Calendar.HOUR_OF_DAY] = 23
        end[Calendar.MINUTE] = 59
        end[Calendar.SECOND] = 59
        end[Calendar.MILLISECOND] = 999
        val timeInfo = TimeInfo()
        timeInfo.startTime = start.timeInMillis
        timeInfo.endTime = end.timeInMillis
        return timeInfo
    }


    interface ChatItemClickListener {
        fun onClick();
    }
}