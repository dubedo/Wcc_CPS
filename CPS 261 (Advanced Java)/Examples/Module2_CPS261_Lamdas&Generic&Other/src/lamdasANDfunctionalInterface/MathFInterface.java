package lamdasANDfunctionalInterface;

interface FunctionalInterface2 {
	public int aMethod(int int1, int int2);
}

public class MathFInterface {

	public static int mathMethod(FunctionalInterface2 theInterface, int int1, int int2) {
		return theInterface.aMethod(int1, int2);
	}

	public static void main(String[] args) {

		int int1 = 1;
		int int2 = 2;

		System.out.println(mathMethod((i1, i2) -> i1 - i2, int1, int2));
		System.out.println(mathMethod((i1, i2) -> i1 + i2, int1, int2));
		System.out.println(mathMethod((i1, i2) -> i1 / i2, int1, int2));
		System.out.println(mathMethod((i1, i2) -> i1 * i2, int1, int2));

	}

}
