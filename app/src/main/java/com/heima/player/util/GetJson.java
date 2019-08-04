package com.heima.player.util;

import com.google.gson.Gson;
import com.heima.player.model.HomeBean;

public class GetJson {

    public HomeBean toBean(String json) {
        Gson gson = new Gson();
        HomeBean bean = gson.fromJson(json, HomeBean.class);

        return bean;
    }

}
