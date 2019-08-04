package com.heima.player.net

import com.heima.player.model.HomeBean

class HomeRequest(type: Int, url: String, iResponse: IResponse<HomeBean>):
        BaseRequest<HomeBean>(type, url, iResponse) {



}