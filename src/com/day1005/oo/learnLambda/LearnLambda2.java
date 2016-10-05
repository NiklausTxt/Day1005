package com.day1005.oo.learnLambda;

import java.util.ArrayList;
import java.util.List;

public class LearnLambda2 {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("����", "��ѧ", 80));
		persons.add(new Person("����", "����", 74));
		persons.add(new Person("����", "Ӣ��", 77));
		persons.add(new Person("����", "����", 87));
		persons.add(new Person("Ǯ��", "��ѧ", 89));
		persons.add(new Person("���", "��ѧ", 80));
		
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
