package lamdasANDfunctionalInterface;

import java.util.ArrayList;

interface Flyable {

	public void fly();

}

class Bird implements Flyable {

	public void fly() {
		System.out.println("Bird Flying Here");
	}

}

class Bat implements Flyable {

	public void fly() {
		System.out.println("Bat Flying Here");
	}

}

class Plane implements Flyable {

	public void fly() {
		System.out.println("Plane Flying Here");
	}

}

public class FlyableCode {

	public static void main(String[] args) {

		ArrayList<Flyable> flyableArray = new ArrayList<>();

		flyableArray.add(new Bird());
		flyableArray.add(new Bat());
		flyableArray.add(new Plane());

		for (Flyable flyable : flyableArray) {
			flyable.fly();
		}

	}

}
