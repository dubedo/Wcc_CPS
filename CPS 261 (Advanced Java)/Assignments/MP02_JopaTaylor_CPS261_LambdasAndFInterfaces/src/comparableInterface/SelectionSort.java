package comparableInterface;

public class SelectionSort {

	public static <T extends Comparable<T>> void sort(T[] unsortedArray) {

		for (int i = 0; i < unsortedArray.length; i++) {

			int lowestIndex = i;
			T lowestObject = unsortedArray[i];

			for (int j = i + 1; j < unsortedArray.length; j++) {

				if (unsortedArray[j].compareTo(unsortedArray[lowestIndex]) < 0) {
					lowestObject = unsortedArray[j];
					lowestIndex = j;
				}

			}

			if (lowestIndex != 1) {
				unsortedArray[lowestIndex] = unsortedArray[i];
				unsortedArray[i] = lowestObject;
			}

		}

	}

}
