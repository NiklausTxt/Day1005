package com.day1005.oo;

public class MakeMoney {

	public static void main(String[] args) {
		double rate = 30;
		double money = 0.0;
		Person zhangsan = new Person("zhangsan",40);
		money = task1(rate);
		money = money + task2(zhangsan);
		System.out.println("¹²×¬ÁË£º"+money);
	}

	public static double task1(double rate){
		int hour = 5;
		return hour*rate;
	}
	
	public static double task2(Person person) {
		int hour = 6;
		return hour*person.rate;
	}
}

class Person {
	protected String name;
	protected double rate;
	public Person(String name, double rate) {
		this.name = name;
		this.rate = rate;
	}
}