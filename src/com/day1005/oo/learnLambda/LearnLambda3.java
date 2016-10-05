package com.day1005.oo.learnLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LearnLambda3 {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("张三", "化学", 80));
		persons.add(new Person("李四", "物理", 74));
		persons.add(new Person("王五", "英语", 77));
		persons.add(new Person("赵六", "语文", 87));
		persons.add(new Person("钱七", "数学", 89));
		persons.add(new Person("孙八", "化学", 80));

		LearnLambda3 lam = new LearnLambda3();
//		lam.filterPrint(persons, (Person p) -> "化学".equals(p.department));
//		lam.filterPrint(persons, (Person p) -> p.name.startsWith("王"));
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
