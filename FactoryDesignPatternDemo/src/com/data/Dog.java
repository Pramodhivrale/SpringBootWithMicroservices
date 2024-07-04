package com.data;

class Cat implements Animal {

	@Override
	public void speak() {
		System.out.println("Woof");
	}

}

public class Dog implements Animal {

	@Override
	public void speak() {
		System.out.println("Meow");

	}

}
