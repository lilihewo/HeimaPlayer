package com.heima.player.base


/**
 * 所有下拉刷新和上拉加载更多列表界面的view的基类
 */
interface IBaseListView<RESPONSE> {
    /**
     * 获取数据失败
     */
    fun onError(message: String?)

    /**
     * 初始化数据或者刷新数据成功
     */
    fun loadSuccess(list: RESPONSE?)

    /**
     * 加载更多数据成功
     */
    fun loadMore(list: RESPONSE?)

}