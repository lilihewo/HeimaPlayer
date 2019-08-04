package com.heima.player.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.heima.player.ui.activity.MainActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Activity的基类
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
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

    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int

    /**
     * 显示Toast
     */
    protected fun showToast(msg: String) {
//        runOnUiThread { toast(msg) }
    }

    /**
     * 跳转界面并销毁当前界面
     */
    inline fun <reified T: BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }

}

