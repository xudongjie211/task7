package com.jnshu.util;

import java.util.Random;



//生成n位随机数

public class VerifyNumUtil {
	private static String[] strs = {  "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
//"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p", "q", "r",
//    "s", "t", "u", "v", "w", "x", "y", "z",
	public static String getRondomStr(int n) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String temp = "";
            // 随机产生下标
            Random r = new Random();
            int a = r.nextInt(strs.length);
            if (a < 24) {
                int b = r.nextInt(100);
                if (b % 2 == 0) {
                    temp = strs[a].toUpperCase();
                    s.append(temp);
                } else {
                    s.append(strs[a]);
                }
            } else {
                s.append(strs[a]);
            }
        }
        return s.toString();
    }

	public static void main(String[] args){
		System.out.println(VerifyNumUtil.getRondomStr(6));
		
		
	}
	
	
	
}
