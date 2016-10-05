package com.day1005.oo.learnLambda;

import java.util.ArrayList;
import java.util.List;

public class LearnLambda2 {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("张三", "化学", 80));
		persons.add(new Person("李四", "物理", 74));
		persons.add(new Person("王五", "英语", 77));
		persons.add(new Person("赵六", "语文", 87));
		persons.add(new Person("钱七", "数学", 89));
		persons.add(new Person("孙八", "化学", 80));
		
		persons.forEach((Person p)->System.out.println(p.name));
		persons.forEach((Person p)->System.out.println(p.name+":"+p.department));
	}
}

class Person{
	public String name;
	public String department;
	public int score;
	public Person(String name, String department, int score) {
		this.department=department;
		this.name=name;
		this.score=score;
	}
}
