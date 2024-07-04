package com.data;

public class AnimalFactory 
{
	 public Animal createAnimal(String type) {
	        if (type == null) {
	            return null;
	        }
	        if (type.equalsIgnoreCase("DOG")) {
	            return new Dog();
	        } else if (type.equalsIgnoreCase("CAT")) {
	            return new Cat();
	        }
	        return null;
	    }

}
