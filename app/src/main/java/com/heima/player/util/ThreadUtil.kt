package com.heima.player.util

import android.os.Handler
import android.os.Looper

/**
 * 静态类
 */
object ThreadUtil {

    val handler = Handler(Looper.getMainLooper())

    fun runOnMainThread(runnable: Runnable) {
        handler.post(runnable)
    }

}