package com.heima.player.view

import com.heima.player.model.HomeBean
import java.util.ArrayList

/**
 * 和Presenter交互
 */
interface IHomeView {

    /**
     * 获取数据失败
     */
    fun onError(message: String?)

    /**
     * 初始化数据或者刷新数据成功
     */
    fun loadSuccess(list: ArrayList<HomeBean.VideoBean>?)

    /**
     * 加载更多数据成功
     */
    fun loadMore(list: ArrayList<HomeBean.VideoBean>?)

}











