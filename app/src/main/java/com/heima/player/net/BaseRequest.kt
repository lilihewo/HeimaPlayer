package com.heima.player.net

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

open class BaseRequest<RESPONSE>(val type: Int, val url: String, val iResponse: IResponse<RESPONSE>) {

    fun parseResult(result: String?) : RESPONSE{
        val gson = Gson()
        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        val bean = gson.fromJson<RESPONSE>(result, type)

        return bean
    }

    /**
     * 发送网络请求
     */
    fun excute() {
        NetManager.netManager.sendRequest(this)
    }

}