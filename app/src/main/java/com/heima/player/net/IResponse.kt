package com.heima.player.net

/**
 * 请求回调
 */
interface IResponse<RESPONSE> {

    fun onError(type: Int, msg: String?)

    fun onSuccess(type: Int, result: RESPONSE)

}