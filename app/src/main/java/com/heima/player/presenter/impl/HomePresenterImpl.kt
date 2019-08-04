package com.heima.player.presenter.impl

import com.heima.player.model.Constants
import com.heima.player.model.HomeBean
import com.heima.player.net.HomeRequest
import com.heima.player.net.IResponse
import com.heima.player.presenter.interf.IHomePresenter
import com.heima.player.presenter.interf.IHomePresenter.Companion.TYPE_INIT_OR_REFRESH
import com.heima.player.presenter.interf.IHomePresenter.Companion.TYPE_LOAD_MORE
import com.heima.player.presenter.interf.IHomePresenter.Companion.maxTime
import com.heima.player.view.IHomeView

class HomePresenterImpl(var iHomeView: IHomeView?) : IHomePresenter, IResponse<HomeBean> {

    fun destoryView() {
        iHomeView = null
    }


    override fun onError(type: Int, msg: String?) {
        iHomeView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: HomeBean) {
        maxTime = result.info.maxtime
        // 区分初始化数据  加载更多数据
        when (type) {
            TYPE_INIT_OR_REFRESH-> iHomeView?.loadSuccess(result.list)
            TYPE_LOAD_MORE->iHomeView?.loadMore(result.list)
        }
    }

    /**
     * 初始化数据或者刷新
     */
    override fun loadData() {
        HomeRequest(TYPE_INIT_OR_REFRESH, Constants.BU_DE_JIE_VIDEO_URL, this).excute()

//        val url = Constants.BU_DE_JIE_VIDEO_URL
//        val request = HomeRequest(url, object : IResponse<HomeBean> {
//            // 主线程
//            override fun onError(msg: String?) {
//                iHomeView.onError(msg)
//            }
//
//            override fun onSuccess(result: HomeBean) {
//                maxTime = result.info.maxtime
//                iHomeView.loadSuccess(result.list)
//            }
//        }).excute()
//        NetManager.netManager.sendRequest(request)

//        val url = Constants.BU_DE_JIE_VIDEO_URL
//        val client = OkHttpClient()
//        val request = Request.Builder().addHeader("User-Agent", "").url(url).get().build()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                ThreadUtil.runOnMainThread(object : Runnable {
//                    override fun run() {
//                        // 回调到view层处理
//                        iHomeView.onError(e.message)
//                    }
//                })
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                // 如果获取数据失败
//                if (response.code == 403) return
//
//                // 获取json
//                val result = response.body?.string()
//                val gson = Gson()
//                val bean = gson.fromJson(result, HomeBean::class.java)
//                Log.i("yang", result)
//                maxTime = bean.info.maxtime
//                // 刷新列表
//                ThreadUtil.runOnMainThread(object : Runnable {
//                    override fun run() {
//                        // 回调到view层处理
//                        iHomeView.loadSuccess(bean.list)
//                    }
//                })
//            }
//        })
    }

    /**
     * 加载更多
     */
    override fun loadMore() {
        val url = Constants.BU_DE_JIE_VIDEO_URL + "&maxtime=" + maxTime
        HomeRequest(TYPE_LOAD_MORE, url, this).excute()
//        NetManager.netManager.sendRequest(request)

//        val url = Constants.BU_DE_JIE_VIDEO_URL + "&maxtime=" + maxTime
//        val client = OkHttpClient()
//        val request = Request.Builder().addHeader("User-Agent", "").url(url).get().build()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                ThreadUtil.runOnMainThread(object : Runnable {
//                    override fun run() {
//                        iHomeView.onError(e.message)
//                    }
//                })
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                // 如果获取数据失败
//                if (response.code == 403) return
//
//                // 获取json
//                val result = response.body?.string()
//                val gson = Gson()
//                val bean = gson.fromJson(result, HomeBean::class.java)
//                // 刷新列表
//                ThreadUtil.runOnMainThread(object : Runnable {
//                    override fun run() {
//                        // 回调到view层处理
//                        iHomeView.loadMore(bean.list)
//                    }
//                })
//            }
//        })
    }

}