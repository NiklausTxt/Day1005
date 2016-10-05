package com.day1005.oo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LearnReflection {
	public static void main(String[] args) {
//		Dog dog = new Dog();
//		getClassFullName(dog);
//		getClassInstance();
//		getClassInfo();
//		getObjectInstance();
//		changeVariables();
		
		invokeMethods();
	}
	
	public static void getClassFullName(Dog dog) {
		System.out.println("1.获得包名和类名=======================");
		Class class1 = dog.getClass();
		System.out.println("类名："+class1.getName());
		System.out.println("包名："+class1.getPackage().getName());
	}
	
	public static void getClassInstance(){
		System.out.println("获得类实例的三种方法");
		String className = "com.day1005.oo.reflection.Dog";
		
		try {
			Class c = Class.forName(className);
			System.out.println("method 2:"+c.getName());
			
			Class d =Dog.class;
			System.out.println("method 3:"+ d.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getClassInfo(){
		System.out.println("3.获得类的各种信息");
		Class<Dog> dogClazz = Dog.class;
		Method[] methods = dogClazz.getMethods();
		System.out.println("getMethods方法如下");
		for(java.lang.reflect.Method m:methods){
			System.out.println(m.getName());
		}
		
		Method[] methods2 = dogClazz.getDeclaredMethods();
		System.out.println("getDeclaredMethods方法如下");
		for(java.lang.reflect.Method m:methods2){
			System.out.println(m.getName());
		}
	}
	
	public static void getObjectInstance(){
		System.out.println("4.创建对象实例");
		Class<Dog> dogClazz = Dog.class;
		try {
			//方法1
//			Object o = dogClazz.newInstance();
//			System.out.println("创建的对象是："+o);
			
			//方法2
			Constructor c = dogClazz.getConstructor(new Class[]{String.class, int.class});
			Dog o2 = (Dog) c.newInstance("xiaohei",3);
			System.out.println(o2.name);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
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
	
	public static void changeVariables(){
		Class<Dog> dogClazz = Dog.class;
		try {
			Object o = dogClazz.newInstance();
			Field[] fields = dogClazz.getFields();
			for(Field f: fields){
				System.out.println(f.getName());
			}
			Field field = dogClazz.getField("name");
			field.set(o, "zhangsan");
			
			
			Field field2 = dogClazz.getDeclaredField("age");
			field2.setAccessible(true);
			field2.set(o, 3);
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void invokeMethods(){
		Class<Dog> dogClazz = Dog.class;
		try {
			Object o = dogClazz.newInstance();
			Method m = dogClazz.getMethod("bark", new Class[]{Dog.class});
			m.invoke(o, new Object[]{o});
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
