package com.jnshu.util;
import java.util.regex.Pattern;

public class RegexUtil {

	public static boolean checkCellphone(String cellphone) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$"; 
		return Pattern.matches(regex,cellphone);
		}
	
	   public static boolean checkEmail(String email) { 
	        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?"; 
	        return Pattern.matches(regex, email); 
	    }
	
	public static void main(String[] args){
		
		//System.out.println(RegexUtil.checkCellphone("15721241663"));
		//System.out.println(RegexUtil.checkEmail("xudogjie211@163.comsaa"));
	}
}
