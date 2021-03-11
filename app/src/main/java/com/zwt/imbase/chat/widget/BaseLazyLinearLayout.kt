package com.zwt.imbase.chat.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseLazyLinearLayout<E : ViewDataBinding> : LinearLayout {

    open lateinit var dataBinding: E

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet?, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    ) {
        initView()
    }

    private fun initView() {
        orientation = LinearLayout.VERTICAL
        setBackgroundColor(Color.parseColor("#f1f1f5"))
        layoutParams =
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        var dataBindingView: View?
        dataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), getRootViewIds(), this, false)
        dataBindingView = dataBinding.root
        addView(dataBindingView)
    }

    abstract fun getRootViewIds(): Int

}