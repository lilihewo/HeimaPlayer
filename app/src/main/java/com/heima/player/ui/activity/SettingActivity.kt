package com.heima.player.ui.activity

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.heima.player.R
import com.heima.player.base.BaseActivity
import com.heima.player.util.ToolBarManager
import org.jetbrains.anko.find

class SettingActivity: BaseActivity(), ToolBarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar ) }

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        initSettingToolBar()
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val isPush = sp.getBoolean("push", false)
        println("推送=$isPush")
    }

}
