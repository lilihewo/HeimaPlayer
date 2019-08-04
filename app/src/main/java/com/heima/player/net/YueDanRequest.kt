package com.heima.player.net

import com.heima.player.model.YueDanBean

/**
 * 悦单界面网络请求request
 */
class YueDanRequest(type: Int, url: String, iResponse: IResponse<YueDanBean>):
        BaseRequest<YueDanBean>(type, url, iResponse) {
}