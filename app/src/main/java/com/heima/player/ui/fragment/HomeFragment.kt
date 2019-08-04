package com.heima.player.ui.fragment

import com.heima.player.adapter.HomeAdapter
import com.heima.player.base.BaseListAdapter
import com.heima.player.base.BaseListFragment
import com.heima.player.base.IBaseListPresenter
import com.heima.player.model.HomeBean
import com.heima.player.presenter.impl.HomePresenterImpl
import com.heima.player.widget.HomeItemView


class HomeFragment: BaseListFragment<HomeBean, HomeBean.VideoBean, HomeItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<HomeBean.VideoBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getSpecialPresenter(): IBaseListPresenter {
        return HomePresenterImpl(this)
    }

    override fun getList(response: HomeBean?): List<HomeBean.VideoBean>? {
        return response?.list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destoryView()
    }


}



