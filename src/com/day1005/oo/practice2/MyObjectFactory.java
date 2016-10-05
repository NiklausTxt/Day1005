package com.day1005.oo.practice2;

import java.lang.reflect.Field;

public class MyObjectFactory {
	//private String className;
	
	public MyObjectFactory() {}

	public Object getObject(String className){
		Object o = null;
		Class<?> myClass;
		try {
			myClass = Class.forName(className);
			o = myClass.newInstance();
			Field[] fields = myClass.getDeclaredFields();
			for(Field f:fields){
				f.setAccessible(true);
				Class<?> s = f.getType();
				if(s.getName().equals("java.lang.String")){
					f.set(o, "initial value");
				}else if(s.getName().equals("int")){
					f.set(o, 1);
				}
//			Field field = myClass.getDeclaredField("name");
//			field.setAccessible(true);
//			field.set(o, "initial value");
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return o;
		
		
	}
}
