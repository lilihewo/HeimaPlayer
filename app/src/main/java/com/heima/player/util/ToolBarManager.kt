package com.heima.player.util

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.heima.player.R
import com.heima.player.ui.activity.SettingActivity
import org.jetbrains.anko.startActivity


interface ToolBarManager {

    val toolbar: Toolbar

    fun initSettingToolBar() {
        toolbar.setTitle("设置")
    }

    fun initMainToolBar() {
        toolbar.setTitle("黑马影音")
        toolbar.inflateMenu(R.menu.main)
//        toolbar.setOnMenuItemClickListener {
//            // 跳转到设置界面
//            toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
//            true
//        }

        toolbar.setOnMenuItemClickListener(object: Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item?.itemId) {
                    R.id.setting->{
                        // 跳转到设置界面
                        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
                    }
                }
                return true
            }
        })
    }

}











