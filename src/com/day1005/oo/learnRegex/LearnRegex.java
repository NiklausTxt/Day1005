package com.day1005.oo.learnRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegex {
	public boolean test(String str){
		Pattern pattern = Pattern.compile("0\\d{3,4}-\\d{7,8}");
		Matcher matcher = pattern.matcher(str);
		System.out.println(str+":"+matcher.matches());
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		LearnRegex l = new LearnRegex();
		String[]  nums = {"3434342","03339-34343343"};
		for(String s:nums){
			l.test(s);
		}
	}
}
