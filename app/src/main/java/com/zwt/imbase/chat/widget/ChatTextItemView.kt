package com.zwt.imbase.chat.widget

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.RelativeLayout
import com.zwt.imbase.R
import com.zwt.imbase.chat.adapter.ChatAdapter
import com.zwt.imbase.databinding.ChatItemTextViewBinding

class ChatTextItemView(context: Context, adapter: ChatAdapter) :
    ChatItemBaseView<ChatItemTextViewBinding>(context, adapter) {

    override fun getRootViewIds(): Int {
        return R.layout.chat_item_text_view
    }

    override fun setUpItemView() {
        setTimestamp(dataBinding.timestampView);
        val layoutParams: RelativeLayout.LayoutParams =
            dataBinding.msgContentView.layoutParams as RelativeLayout.LayoutParams
        if (TextUtils.equals(messageData.from, "000")) {
            dataBinding.leftHeaderView.visibility = GONE
            dataBinding.rightHeaderView.visibility = VISIBLE
            layoutParams.addRule(RelativeLayout.LEFT_OF, 0)
            layoutParams.addRule(RelativeLayout.RIGHT_OF, R.id.right_header_view)
            layoutParams.addRule(RelativeLayout.ALIGN_END)
            dataBinding.msgContentView.setBackgroundResource(R.drawable.chat_to_bg_normal)
        } else {
            dataBinding.leftHeaderView.visibility = VISIBLE
            dataBinding.rightHeaderView.visibility = GONE
            layoutParams.addRule(RelativeLayout.ALIGN_START)
            layoutParams.addRule(RelativeLayout.LEFT_OF, R.id.left_header_view)
            layoutParams.addRule(RelativeLayout.RIGHT_OF, 0)
            dataBinding.msgContentView.setBackgroundResource(R.drawable.chat_from_bg_normal)
        }
        if (!TextUtils.isEmpty(messageData.msgText)) {
            dataBinding.msgContentView.text = messageData.msgText
        } else {
            dataBinding.msgContentView.text = ""
        }
    }
}