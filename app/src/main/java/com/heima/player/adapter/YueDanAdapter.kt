package com.heima.player.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.heima.player.widget.YueDanItemView

class YueDanAdapter: RecyclerView.Adapter<YueDanAdapter.YueDanHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): YueDanHolder {
        return YueDanHolder(YueDanItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(p0: YueDanHolder, p1: Int) {
    }

    class YueDanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}