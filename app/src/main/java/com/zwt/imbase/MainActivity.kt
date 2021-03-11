package com.zwt.imbase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zwt.imbase.chat.ImBaseActivity
import com.zwt.imbase.chat.ImUtil
import com.zwt.imbase.chat.adapter.ChatAdapter
import com.zwt.imbase.chat.bean.MessageData
import com.zwt.imbase.chat.bean.MessageEventData
import com.zwt.imbase.chat.widget.ChatItemBaseView
import com.zwt.imbase.evnet.EventBusUtil


class MainActivity : ImBaseActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mNameView: TextView
    private lateinit var mMsgEditView: EditText
    private lateinit var mSendView: Button
    private lateinit var mAdapter: ChatAdapter;
    private var list: MutableList<MessageData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMsgEditView = findViewById(R.id.msg_view)
        mNameView = findViewById(R.id.name_view)
        mSendView = findViewById(R.id.send_view)
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.layoutManager = LinearLayoutManager(this)
        list.add(getMsgData("001", "你好我是小岳岳!"))
        mAdapter = ChatAdapter(context, list, object : ChatItemBaseView.ChatItemClickListener {
            override fun onClick() {
                // 点击了某一条消息
            }
        })
        recyclerView.adapter = mAdapter

        mNameView.setOnClickListener {
            //模拟发送端
            EventBusUtil.post(MessageEventData(getMsgData("001", "你好我是小岳岳！")))
        }
        mSendView.setOnClickListener {
            val content = mMsgEditView.text.toString()
            list.add(getMsgData("000", content))
            mAdapter.notifyDataSetChanged()
            mMsgEditView.setText("")
            ImUtil.hideSoftKeyboard(this)
            recyclerView.smoothScrollToPosition(list.size)

        }
    }

    override fun onReceiveIMEvent(event: MessageEventData) {
        if (event.data != null) {
            list.add(getMsgData("001", "你好我是小岳岳！"))
            mAdapter.notifyDataSetChanged()
            recyclerView.smoothScrollToPosition(list.size)
        }
    }

    private fun getMsgData(from: String, msg: String): MessageData {
        val bean = MessageData()
        bean.msgType = ImUtil.MSG_TEXT
        bean.from = from
        bean.timestamp = System.currentTimeMillis();
        bean.msgText = msg
        return bean
    }

}