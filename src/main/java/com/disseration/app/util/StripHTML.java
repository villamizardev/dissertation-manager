package com.disseration.app.util;

public class StripHTML {
	
	public static String strip(String str) {
		str = str.replaceAll("\\<.*?\\>", "");
		str = str.replace("&nbsp;"," "); 
		return str;
	}
}
