package com.heima.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.heima.player.R

import com.heima.player.model.YueDanBean
import kotlinx.android.synthetic.main.item_yue_dan.view.*

/**
 * 悦单界面每个条目的自定义view
 */
class YueDanItemView: RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_yue_dan, this)
    }

    fun setData(data: YueDanBean.VideoBean) {
        title.setText(data.text)
//        desc.setText(data.text)
        // 背景图片
//        Picasso.with(context).load(data.profile_image).into(bg)
//        Glide.with(context).load(data.bimageuri).into(bg)
        Glide.with(context).load(data.image0).into(bg)
    }

}








