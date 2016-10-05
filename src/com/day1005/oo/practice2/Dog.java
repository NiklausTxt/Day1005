package com.day1005.oo.practice2;

public class Dog {
	private String name;
	private int age;
	private String owner;
	
	public Dog(){}
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void bark(Dog dog){
		System.out.println(dog.name+"ÍôÍô£¡£¡");
	}
	
	public void celebrateBirthday(){
		System.out.println(name + "ÉúÈÕ¿ìÀÖ");
		addAge();
	}
	
	private void addAge(){
		age = age + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
