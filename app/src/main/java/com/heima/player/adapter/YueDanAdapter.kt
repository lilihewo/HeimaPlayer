package com.heima.player.adapter

import android.content.Context
import com.heima.player.base.BaseListAdapter
import com.heima.player.model.YueDanBean
import com.heima.player.widget.YueDanItemView

class YueDanAdapter: BaseListAdapter<YueDanBean.VideoBean, YueDanItemView>() {
    override fun refreshItemView(itemView: YueDanItemView, data: YueDanBean.VideoBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): YueDanItemView {
        return YueDanItemView(context)
    }


}