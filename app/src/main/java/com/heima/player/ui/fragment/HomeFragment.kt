package com.heima.player.ui.fragment
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.heima.player.R
import com.heima.player.adapter.HomeAdapter

import com.heima.player.base.BaseFragment
import com.heima.player.model.HomeBean
import com.heima.player.presenter.impl.HomePresenterImpl
import com.heima.player.view.IHomeView
import kotlinx.android.synthetic.main.fragement_list.*
import org.jetbrains.anko.support.v4.toast
import java.util.ArrayList

class HomeFragment: BaseFragment(), IHomeView {

    override fun onError(message: String?) {
        refreshLayout.isRefreshing = false

        toast("加载数据成功")
    }

    override fun loadSuccess(list: ArrayList<HomeBean.VideoBean>?) {
        refreshLayout.isRefreshing = false

        if (list == null) return
        adapter.updateList(list)
    }

    override fun loadMore(list: ArrayList<HomeBean.VideoBean>?) {
        refreshLayout.isRefreshing = false

        if (list == null) return
        adapter.loadMore(list)
    }

    val adapter by lazy { HomeAdapter() }
    val homePresenterImpl by lazy { HomePresenterImpl(this) }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragement_list, null)
    }

    override fun initListener() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        // 初始化刷新控件
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        // 下拉刷新
        refreshLayout.setOnRefreshListener {
            homePresenterImpl.loadData()
        }
        // 上拉加载更多
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                // 如果是空闲状态
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount-1) {
                            homePresenterImpl.loadMore()
                        }
                    }
                }
            }
        })
    }

    override fun initData() {
        homePresenterImpl.loadData()
    }

}



