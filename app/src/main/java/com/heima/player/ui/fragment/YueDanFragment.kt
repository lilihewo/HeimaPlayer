package com.heima.player.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.heima.player.R
import com.heima.player.adapter.YueDanAdapter
import com.heima.player.base.BaseFragment
import com.heima.player.model.YueDanBean
import com.heima.player.presenter.impl.YueDanPresenterImpl
import com.heima.player.view.IYueDanView
import kotlinx.android.synthetic.main.fragement_list.*
import org.jetbrains.anko.support.v4.toast
import java.util.ArrayList

/**
 * 悦单界面
 */
class YueDanFragment: BaseFragment(), IYueDanView {
    override fun onError(message: String?) {
        refreshLayout.isRefreshing = false
        toast("加载数据失败")
    }

    override fun loadSuccess(list: ArrayList<YueDanBean.VideoBean>?) {
        refreshLayout.isRefreshing = false
        if (list == null) return
        adapter.updateList(list)
    }

    override fun loadMore(list: ArrayList<YueDanBean.VideoBean>?) {
        refreshLayout.isRefreshing = false

        if (list == null) return
        adapter.loadMore(list)
    }

    val adapter by lazy { YueDanAdapter() }

    val presenterImpl by lazy { YueDanPresenterImpl(this) }

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
            presenterImpl.loadData()
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
                            presenterImpl.loadMore()
                        }
                    }
                }
            }
        })
    }

    override fun initData() {
        // 加载数据
        presenterImpl.loadData()
    }


}












