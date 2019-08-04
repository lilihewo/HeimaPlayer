package com.heima.player.presenter.impl

import com.heima.player.base.IBaseListPresenter.Companion.TYPE_INIT_OR_REFRESH
import com.heima.player.base.IBaseListPresenter.Companion.TYPE_LOAD_MORE
import com.heima.player.base.IBaseListPresenter.Companion.maxTime
import com.heima.player.base.IBaseListView
import com.heima.player.model.Constants
import com.heima.player.model.HomeBean
import com.heima.player.net.HomeRequest
import com.heima.player.net.IResponse
import com.heima.player.presenter.interf.IHomePresenter
import com.heima.player.view.IHomeView

class HomePresenterImpl(var homeView: IBaseListView<HomeBean>?) : IHomePresenter, IResponse<HomeBean> {

    override fun destoryView() {
        homeView = null
    }

    override fun onError(type: Int, msg: String?) {
        homeView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: HomeBean) {
        maxTime = result.info.maxtime
        // 区分初始化数据  加载更多数据
        when (type) {
            TYPE_INIT_OR_REFRESH-> homeView?.loadSuccess(result)
            TYPE_LOAD_MORE->homeView?.loadMore(result)
        }
    }

    /**
     * 初始化数据或者刷新
     */
    override fun loadData() {
        HomeRequest(TYPE_INIT_OR_REFRESH, Constants.BU_DE_JIE_VIDEO_URL, this).excute()
    }

    /**
     * 加载更多
     */
    override fun loadMore() {
        val url = Constants.BU_DE_JIE_VIDEO_URL + "&maxtime=" + maxTime
        HomeRequest(TYPE_LOAD_MORE, url, this).excute()
    }

}