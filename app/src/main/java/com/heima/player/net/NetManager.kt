package com.heima.player.net

import android.util.Log
import com.google.gson.Gson
import com.heima.player.model.Constants
import com.heima.player.model.HomeBean
import com.heima.player.util.ThreadUtil
import okhttp3.*
import java.io.IOException

/**
 * 发送网络请求
 */
class NetManager private constructor(){

    val client by lazy { OkHttpClient() }

    companion object {
        val netManager by lazy { NetManager() }
    }

    fun <RESPONSE>sendRequest(baseRequest: BaseRequest<RESPONSE>) {
        val request = Request.Builder().addHeader("User-Agent", "").url(baseRequest.url).get().build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        baseRequest.iResponse.onError(baseRequest.type, e.message)
                    }
                })
            }

            override fun onResponse(call: Call, response: Response) {
                // 如果获取数据失败
                if (response.code == 403) return

                // 获取json
                val result = response.body?.string()
                val bean = baseRequest.parseResult(result)
                // 刷新列表
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        baseRequest.iResponse.onSuccess(baseRequest.type, bean)
//                        // 回调到view层处理
//                        iHomeView.loadSuccess(bean.list)
                    }
                })
            }
        })
    }

}












