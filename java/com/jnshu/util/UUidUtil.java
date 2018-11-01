package com.jnshu.util;

import java.util.UUID;
//获得随机字符串
public class UUidUtil {
	public static String getuuit(){
		return UUID.randomUUID().toString().replace("-", "");
		
	}	
	public static void main(String[] args){		
		System.out.println(UUidUtil.getuuit());		
	}
	
	
}
