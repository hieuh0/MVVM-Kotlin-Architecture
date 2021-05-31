package com.nta.mvvm_kotlin.utils.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import com.nta.mvvm_kotlin.databinding.LayoutItemToolbarBinding

class CustomToolbar@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Toolbar(context, attrs, defStyleAttr) {

    init {
        initView(context,attrs,defStyleAttr)
    }

    private lateinit var binding : LayoutItemToolbarBinding

    private fun initView(context: Context,
                         attrs: AttributeSet?,
                         defStyleAttr: Int){
        binding = LayoutItemToolbarBinding.inflate(LayoutInflater.from(context),this,true)
//        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_item_toolbar, this, true)
        this.setPadding(0, 0, 0, 0)//for tab otherwise give space in tab
        this.setContentInsetsAbsolute(0, 0)
    }

}