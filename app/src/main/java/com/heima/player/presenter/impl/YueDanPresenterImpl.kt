package com.heima.player.presenter.impl

import com.heima.player.base.IBaseListPresenter.Companion.TYPE_INIT_OR_REFRESH
import com.heima.player.base.IBaseListPresenter.Companion.TYPE_LOAD_MORE
import com.heima.player.base.IBaseListPresenter.Companion.maxTime
import com.heima.player.model.Constants
import com.heima.player.model.YueDanBean
import com.heima.player.net.IResponse
import com.heima.player.net.YueDanRequest
import com.heima.player.presenter.interf.IYueDanPresenter
import com.heima.player.view.IYueDanView

class YueDanPresenterImpl(var iYueDanView: IYueDanView?): IYueDanPresenter, IResponse<YueDanBean> {

    override fun destoryView() {
        if (iYueDanView != null)
            iYueDanView = null
    }

    override fun onError(type: Int, msg: String?) {
        iYueDanView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: YueDanBean) {
        maxTime = result.info.maxtime
        // 区分初始化数据  加载更多数据
        when (type) {
            TYPE_INIT_OR_REFRESH -> iYueDanView?.loadSuccess(result.list)
            TYPE_LOAD_MORE ->iYueDanView?.loadMore(result.list)
        }
    }

    /**
     * 初始化数据或者刷新数据
     */
    override fun loadData() {
        YueDanRequest(TYPE_INIT_OR_REFRESH, Constants.BU_DE_JIE_VIDEO_URL, this).excute()
    }

    /**
     * 加载更多数据
     */
    override fun loadMore() {
        val url = Constants.BU_DE_JIE_VIDEO_URL + "&maxtime=" + maxTime
        YueDanRequest(TYPE_LOAD_MORE, url, this).excute()
    }
}