package com.heima.player.adapter

import android.content.Context
import com.heima.player.base.BaseListAdapter
import com.heima.player.model.HomeBean
import com.heima.player.widget.HomeItemView

class HomeAdapter: BaseListAdapter<HomeBean.VideoBean, HomeItemView>() {
    override fun refreshItemView(itemView: HomeItemView, data: HomeBean.VideoBean) {
        itemView.setData(data)
    }


    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }

}