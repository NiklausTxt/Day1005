package com.day1005.oo.practice2;

public class Test1 {
	public static void main(String[] args) {
		MyObjectFactory o1 = new MyObjectFactory();
		String className = "com.day1005.oo.practice2.Dog";
		String className2 = "com.day1005.oo.practice2.Person";
		Dog dog = (Dog) o1.getObject(className);
		System.out.println(dog.getAge());
		System.out.println(dog.getName());
		System.out.println(dog.getOwner());
		
		System.out.println("==================================");
		Person person = (Person) o1.getObject(className2);
		System.out.println(person.getAge());
		System.out.println(person.getName());
	}
}
