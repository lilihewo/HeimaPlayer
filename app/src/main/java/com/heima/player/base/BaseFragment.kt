package com.heima.player.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast


/**
 * Fragment的基类
 */
abstract class BaseFragment: Fragment(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    /**
     * fragment初始化
     */
    protected fun init() {

    }

    /**
     * 显示布局
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initView()
    }

    /**
     * 获取布局view
     */
    abstract fun initView(): View?

    /**
     * 数据加载
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    /**
     * 初始化数据
     */
    open protected fun initData() {

    }

    /**
     * adapter listener
     */
    open protected fun initListener() {

    }

    fun showToast(msg: String) {
//        context!!.runOnUiThread { toast(msg) }
    }

}