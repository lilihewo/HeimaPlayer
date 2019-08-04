package com.heima.player.util

import com.heima.player.R
import com.heima.player.base.BaseFragment
import com.heima.player.ui.fragment.HomeFragment
import com.heima.player.ui.fragment.MvFragment
import com.heima.player.ui.fragment.VBangFragment
import com.heima.player.ui.fragment.YueDanFragment

class FragmentUtil private constructor() {

    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vBangFragment by lazy { VBangFragment() }
    val yueDanFragment by lazy { YueDanFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    fun getFragment(tabId: Int): BaseFragment? {
        when (tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_mv  -> return mvFragment
            R.id.tab_vbang -> return vBangFragment
            R.id.tab_yuedan -> return yueDanFragment
        }

        return null
    }

}