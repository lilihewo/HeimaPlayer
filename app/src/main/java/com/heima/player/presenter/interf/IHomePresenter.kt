package com.heima.player.presenter.interf

interface IHomePresenter {

    companion object {
        val TYPE_INIT_OR_REFRESH = 1
        val TYPE_LOAD_MORE = 2

        var maxTime: String? = null
    }

    fun loadData()
    fun loadMore()
}