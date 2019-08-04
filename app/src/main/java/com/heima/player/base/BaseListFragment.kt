package com.heima.player.base

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.heima.player.R
import com.heima.player.R.id.recyclerView
import com.heima.player.R.id.refreshLayout
import kotlinx.android.synthetic.main.fragement_list.*
import org.jetbrains.anko.support.v4.toast

/**
 * 可变
 * IHomeView
 * HomeAdapter
 * HomePresenterI
 */
/**
 * 所有具有下拉刷新和上拉加载更多功能的界面的基类
 */
abstract class BaseListFragment<RESPONSE, ITEM_BEAN, ITEM_VIEW:View>: BaseFragment(), IBaseListView<RESPONSE> {

    override fun onError(message: String?) {
        refreshLayout.isRefreshing = false

        toast("加载数据成功")
    }

    override fun loadSuccess(response: RESPONSE?) {
        refreshLayout.isRefreshing = false

        adapter.updateList(getList(response))
    }


    override fun loadMore(response: RESPONSE?) {
        refreshLayout.isRefreshing = false

        adapter.loadMore(getList(response))
    }

    // 获取适配器
    val adapter by lazy { getSpecialAdapter() }
    // 获取Presenter
    val presenter by lazy { getSpecialPresenter() }

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
            presenter.loadData()
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
                            presenter.loadMore()
                        }
                    }
                }
            }
        })
    }

    override fun initData() {
        presenter.loadData()
    }

    /**
     * 获取适配器
     */
    abstract fun getSpecialAdapter(): BaseListAdapter<ITEM_BEAN, ITEM_VIEW>

    /**
     * 获取Presenter
     */
    abstract fun getSpecialPresenter(): IBaseListPresenter

    /**
     * 获取列表数据集合
     */
    abstract fun getList(response: RESPONSE?): List<ITEM_BEAN>?

}
