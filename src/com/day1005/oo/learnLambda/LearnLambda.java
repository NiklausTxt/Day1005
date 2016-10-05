package com.day1005.oo.learnLambda;

public class LearnLambda {
	public static void main(String[] args) {
		for(int i = 0; i<100; i++){
			new Thread(()->System.out.println(Thread.currentThread().getName())).start();;
		}
	}
}
