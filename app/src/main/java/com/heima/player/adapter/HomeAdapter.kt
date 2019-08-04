package com.heima.player.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.heima.player.model.HomeBean
import com.heima.player.widget.HomeItemView
import com.heima.player.widget.LoadMoreView

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var mList = ArrayList<HomeBean.VideoBean>()

    fun updateList(list: List<HomeBean.VideoBean>) {
        this.mList.clear()
        this.mList.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list: List<HomeBean.VideoBean>) {
        this.mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if (viewType == endViewType) { // 如果是最后的条目
            return HomeHolder(LoadMoreView(parent.context))
        } else { // 如果是普通条目
            return HomeHolder(HomeItemView(parent.context))
        }
    }

    var endViewType = 1 // 最后一条
    var cardViewType = 2 // 普通条目
    override fun getItemViewType(position: Int): Int {
        if (position == mList.size) {
            // 最后一条
            return endViewType
        } else {
            return cardViewType
        }
    }

    override fun getItemCount(): Int {
        return mList.size + 1
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        // 如果是最后一条，不需要刷新数据
        if (position == mList.size)
            return

        // 条目数据
        val data = mList.get(position)
        // 条目view
        val itemView = holder.itemView as HomeItemView

        itemView.setData(data)
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}