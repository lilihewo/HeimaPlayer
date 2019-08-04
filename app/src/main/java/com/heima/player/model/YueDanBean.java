package com.heima.player.model;

import java.util.ArrayList;

//http://api.budejie.com/api/api_open.php?a=list&c=data&type=10
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
//		public String bimageuri;
//		public String videouri;
		public String image0;
	}

}
