package com.zwt.imbase.chat.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zwt.imbase.chat.ImUtil
import com.zwt.imbase.chat.bean.MessageData
import com.zwt.imbase.chat.widget.*

class ChatAdapter(private val context: Context, private val messageList: MutableList<MessageData>, private val mChatItemClickListener: ChatItemBaseView.ChatItemClickListener) :
    RecyclerView.Adapter<ChatAdapter.ChatItemViewHolder>() {

    inner class ChatItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(
            messageData: MessageData,
            position: Int,
            itemClickListener: ChatItemBaseView.ChatItemClickListener
        ) {
            if (itemView is ChatItemBaseView<*>) {
                itemView.setUpView(messageData, position, itemClickListener)
            }
        }
    }

    private fun getChatItemView(viewType: Int): ChatItemBaseView<*> {
        return when (viewType) {
            ImUtil.MSG_TEXT -> ChatTextItemView(context, this)
            ImUtil.MSG_IMAGE -> ChatImgItemView(context, this)
            ImUtil.MSG_VOICE -> ChatVoiceItemView(context, this)
            else -> ChatEmptyItemView(context, this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatItemViewHolder {
        return ChatItemViewHolder(getChatItemView(viewType))
    }

    override fun onBindViewHolder(holder: ChatItemViewHolder, position: Int) {
        holder.setData(messageList[position], position, mChatItemClickListener)
    }

    override fun getItemCount(): Int {
        return if (messageList.size > 0) messageList.size else 0
    }

    override fun getItemViewType(position: Int): Int {
        return messageList[position].msgType
    }

    fun getItem(position: Int): MessageData? {
        if (messageList.size > 0) {
            return messageList[position]
        }
        return null
    }


}