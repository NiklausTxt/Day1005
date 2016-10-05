package com.day1005.oo.learnLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LearnLambda3 {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("����", "��ѧ", 80));
		persons.add(new Person("����", "����", 74));
		persons.add(new Person("����", "Ӣ��", 77));
		persons.add(new Person("����", "����", 87));
		persons.add(new Person("Ǯ��", "��ѧ", 89));
		persons.add(new Person("���", "��ѧ", 80));

		LearnLambda3 lam = new LearnLambda3();
//		lam.filterPrint(persons, (Person p) -> "��ѧ".equals(p.department));
//		lam.filterPrint(persons, (Person p) -> p.name.startsWith("��"));
		lam.filterPrint(persons, (Person p) -> p.score<80);
	}

	public void filterPrint(List<Person> persons, Predicate<Person> predicate) {
		for (Person p : persons) {
			if (predicate.test(p)) {
				System.out.println(p.name);
			}
		}
	}
}
