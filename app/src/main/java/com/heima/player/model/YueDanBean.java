package com.heima.player.model;

import java.util.ArrayList;

public class YueDanBean {

	public InfoBean info;
	
	public class InfoBean {
		public String vendor;
		public int count;
		public int page;

		public String maxid;
		public String maxtime;
	}
	
	public ArrayList<VideoBean> list;
	
	public class VideoBean {
		public String text;
//		public String profile_image;
		public String bimageuri;
		public String videouri;
	}

}
