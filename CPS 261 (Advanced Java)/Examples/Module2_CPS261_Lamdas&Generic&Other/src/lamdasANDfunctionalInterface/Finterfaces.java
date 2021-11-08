package lamdasANDfunctionalInterface;

interface FunctionalInterface<T> {
	public void aMethod(T string1, T string2);
}

class ConcatString implements FunctionalInterface<String> {

	public void aMethod(String string1, String string2) {
		System.out.println(string1 + string2);
	}

}

class AddStringLenth implements FunctionalInterface<String> {

	public void aMethod(String string1, String string2) {
		System.out.println(string1.length() + string2.length());
	}
}

public class Finterfaces {

	public static void main(String[] args) {

		String string1 = "Hi";
		String string2 = "Hello";

		// The Old Ways.
		ConcatString oldWay = new ConcatString();
		AddStringLenth oldWay2 = new AddStringLenth();

		oldWay.aMethod(string1, string2);
		oldWay2.aMethod(string1, string2);

		// An Update to Reduce Code. But Still Not Best.
		FunctionalInterface<String> anonClass = new FunctionalInterface<>() {
			public void aMethod(String string1, String string2) {
				System.out.println(string1 + string2);
			}
		};

		anonClass.aMethod(string1, string2);

		// The New Way.
		FunctionalInterface<String> lambdaTime = (s1, s2) -> {
			System.out.println(s1 + s2);
		};

		lambdaTime.aMethod(string1, string2);

		// Added The Generic Type so Its No Longer Limited To Strings
		int aNumber = 1;
		int aNumber2 = 2;

		FunctionalInterface<Integer> lambdaNumbers = (i1, i2) -> {
			System.out.println(i1 * i2);
		};

		lambdaNumbers.aMethod(aNumber, aNumber2);

	}

}
