package com.day1005.oo.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.day1005.oo.reflection.Dog;

public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person();
		Person p2 = new Person("张三", 11);
		
		
//		//方法1：
//		Class class1 = p.getClass();
//		System.out.println("方法1："+class1.getName());
//		
//		//方法2：
//		String className = "com.day1005.oo.practice.Person";
//		try {
//			Class class2 = Class.forName(className);
//			System.out.println("方法2："+class2.getName());
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		//方法3：
		Class class3 = Person.class;
		System.out.println("方法3："+class3.getName());
		
		try {
			Field field = class3.getDeclaredField("name");
			field.setAccessible(true);
			field.set(p2, "Bob");
			System.out.println(field.get(p2));
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		Chinese c1 = new Chinese("霸王", 34);
		Class chineseClazz = c1.getClass();
		System.out.println("当前类："+chineseClazz.getName());
		Method[] m1 = chineseClazz.getMethods();
		System.out.println("chinese中所有的公开方法");
		for(Method m:m1){
			System.out.println(m.getName());
		}
		
		Method[] m2 = chineseClazz.getDeclaredMethods();
		System.out.println("chinese中所有的自定义方法");
		for(Method m:m2){
			System.out.println(m.getName());
		}
		
		Class superClazz = chineseClazz.getSuperclass();
		System.out.println("chinese的父类是："+superClazz.getName());
		
		Class[] interfaceClazz = chineseClazz.getInterfaces();
		System.out.print("chinese的接口有：");
		for(Class c:interfaceClazz){
			System.out.println(c.getName());
		}
		System.out.println("========================================");
		reflectPerson("com.day1005.oo.practice.Japanese","日本人",22);
		System.out.println("========================================");
		reflectPerson("com.day1005.oo.practice.Person","人",22);
		System.out.println("========================================");
		reflectPerson("com.day1005.oo.practice.Chinese","中国人",22);
		
	}
	
	
	public static void reflectPerson(String className, String name, int age){
		Class c;
		try {
			c = Class.forName(className);
			Constructor constructor = null;
			try {
				constructor = c.getConstructor(new Class[]{String.class, int.class});
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object o =  constructor.newInstance(name, age);
			
			Method m2;
			try {
				m2 = c.getMethod("eatSusi", new Class[]{});
				m2.invoke(o, new Object[]{});
			} catch (NoSuchMethodException e) {
				System.out.println("没有吃寿司这个方法");
			}
			
			
			Method m;
			try {
				m = c.getMethod("pingpang", new Class[]{});
				m.invoke(o, new Object[]{});
			} catch (NoSuchMethodException e) {
				System.out.println("没有打乒乓这个方法");
			}
			
			
			Class[] interfaceClazz = c.getInterfaces();
			int i=0;
			for(Class class1:interfaceClazz){
				
				if(class1.getName().equals("com.day1005.oo.practice.Fightable"));
				{
					System.out.println("实现了Fightable接口");
					i++;
				}
			}
			if(i==0){
				System.out.println("没有实现了Fightable接口");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
