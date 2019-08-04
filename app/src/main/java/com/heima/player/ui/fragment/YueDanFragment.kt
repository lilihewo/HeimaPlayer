package com.heima.player.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.heima.player.R
import com.heima.player.adapter.YueDanAdapter
import com.heima.player.base.BaseFragment
import kotlinx.android.synthetic.main.fragement_list.*

/**
 * 悦单界面
 */
class YueDanFragment: BaseFragment() {

    val yueDanAdapter by lazy { YueDanAdapter() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragement_list, null)
    }

    override fun initListener() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = yueDanAdapter
    }


}












