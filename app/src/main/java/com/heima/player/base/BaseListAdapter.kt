package com.heima.player.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.heima.player.widget.LoadMoreView

/**
 * 所有下拉刷新和上拉加载更多列表界面adapter的基类
 */
abstract class BaseListAdapter<ITEM_BEAN, ITEM_VIEW:View>: RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {

    private var mList = ArrayList<ITEM_BEAN>()

    fun updateList(list: List<ITEM_BEAN>) {
        this.mList.clear()
        this.mList.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list: List<ITEM_BEAN>) {
        this.mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListAdapter.BaseListHolder {
        if (viewType == endViewType) { // 如果是最后的条目
            return BaseListHolder(LoadMoreView(parent.context))
        } else { // 如果是普通条目
            return BaseListHolder(getItemView(parent.context))
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

    override fun onBindViewHolder(holder: BaseListAdapter.BaseListHolder, position: Int) {
        // 如果是最后一条，不需要刷新数据
        if (position == mList.size) return

        // 条目数据
        val data = mList.get(position)
        // 条目view
        val itemView = holder.itemView as ITEM_VIEW
        // 条目刷新
        refreshItemView(itemView, data)
    }


    class BaseListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    /**
     * 刷新条目
     */
    abstract fun refreshItemView(itemView: ITEM_VIEW, data: ITEM_BEAN)

    /**
     * 获取条目view
     */
    abstract fun getItemView(context: Context?): ITEM_VIEW



}