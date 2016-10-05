package com.day1005.oo.practice;

public class Japanese extends Person{
	
	public Japanese() {
		super();
	}
	
	public Japanese(String name, int age) {
		super(name, age);
	}
	
	public void eatSusi(){
		System.out.println("日本人吃寿司。");
	}
}
