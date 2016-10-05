package com.day1005.oo.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.day1005.oo.reflection.Dog;

public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person();
		Person p2 = new Person("����", 11);
		
		
//		//����1��
//		Class class1 = p.getClass();
//		System.out.println("����1��"+class1.getName());
//		
//		//����2��
//		String className = "com.day1005.oo.practice.Person";
//		try {
//			Class class2 = Class.forName(className);
//			System.out.println("����2��"+class2.getName());
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		//����3��
		Class class3 = Person.class;
		System.out.println("����3��"+class3.getName());
		
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
		
		
		Chinese c1 = new Chinese("����", 34);
		Class chineseClazz = c1.getClass();
		System.out.println("��ǰ�ࣺ"+chineseClazz.getName());
		Method[] m1 = chineseClazz.getMethods();
		System.out.println("chinese�����еĹ�������");
		for(Method m:m1){
			System.out.println(m.getName());
		}
		
		Method[] m2 = chineseClazz.getDeclaredMethods();
		System.out.println("chinese�����е��Զ��巽��");
		for(Method m:m2){
			System.out.println(m.getName());
		}
		
		Class superClazz = chineseClazz.getSuperclass();
		System.out.println("chinese�ĸ����ǣ�"+superClazz.getName());
		
		Class[] interfaceClazz = chineseClazz.getInterfaces();
		System.out.print("chinese�Ľӿ��У�");
		for(Class c:interfaceClazz){
			System.out.println(c.getName());
		}
		System.out.println("========================================");
		reflectPerson("com.day1005.oo.practice.Japanese","�ձ���",22);
		System.out.println("========================================");
		reflectPerson("com.day1005.oo.practice.Person","��",22);
		System.out.println("========================================");
		reflectPerson("com.day1005.oo.practice.Chinese","�й���",22);
		
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
				System.out.println("û�г���˾�������");
			}
			
			
			Method m;
			try {
				m = c.getMethod("pingpang", new Class[]{});
				m.invoke(o, new Object[]{});
			} catch (NoSuchMethodException e) {
				System.out.println("û�д�ƹ���������");
			}
			
			
			Class[] interfaceClazz = c.getInterfaces();
			int i=0;
			for(Class class1:interfaceClazz){
				
				if(class1.getName().equals("com.day1005.oo.practice.Fightable"));
				{
					System.out.println("ʵ����Fightable�ӿ�");
					i++;
				}
			}
			if(i==0){
				System.out.println("û��ʵ����Fightable�ӿ�");
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
