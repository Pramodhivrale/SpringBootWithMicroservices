package com.data;

public class FactoryPatternExmaple {
	public static void main(String[] args) {

		AnimalFactory animalFactory = new AnimalFactory();

		// Create a Dog object and call its speak method
		Animal animal1 = animalFactory.createAnimal("DOG");
		if (animal1 != null) {
			animal1.speak(); // Output: Woof
		}

		// Create a Cat object and call its speak method
		Animal animal2 = animalFactory.createAnimal("CAT");
		if (animal2 != null) {
			animal2.speak(); // Output: Meow
		}
	}

}
