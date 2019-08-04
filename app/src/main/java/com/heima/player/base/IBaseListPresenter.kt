package com.heima.player.base

/**
 * 所用下拉刷新和上拉加载更多列表界面presenter的基类
 */
interface IBaseListPresenter {
    companion object {
        val TYPE_INIT_OR_REFRESH = 1
        val TYPE_LOAD_MORE = 2

        var maxTime: String? = null
    }

    fun loadData()
    fun loadMore()

    // 解绑presenter和view
    fun destoryView()
}