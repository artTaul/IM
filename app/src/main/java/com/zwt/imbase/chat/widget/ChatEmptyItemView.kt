package com.zwt.imbase.chat.widget

import android.content.Context
import android.view.View
import com.zwt.imbase.R
import com.zwt.imbase.chat.adapter.ChatAdapter
import com.zwt.imbase.databinding.ChatItemEmptyViewBinding

class ChatEmptyItemView(context: Context, adapter: ChatAdapter) :
    ChatItemBaseView<ChatItemEmptyViewBinding>(context, adapter) {
    override fun getRootViewIds(): Int {
        return R.layout.chat_item_empty_view
    }

    override fun setUpItemView() {
        TODO("Not yet implemented")
    }
}