package com.day1005.oo.practice;

public class Chinese extends Person implements Fightable{
	
	public Chinese() {
		super();
	}
	
	public Chinese(String name, int age){
		super(name, age);
	}
	
	public void pingpang(){
		System.out.println("�й��˻��ƹ����");
	}

	@Override
	public void fight() {
		System.out.println("�й��˻��ܡ�");
	}
}
