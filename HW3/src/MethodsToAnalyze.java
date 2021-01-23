/**
 * A collection of methods that work with arrays of ints.
 * 
 * @author mvail
 */
public class MethodsToAnalyze {
	private static long numStatements = 0;

	/**
	 * Return index where value is found in array or -1 if not found.
	 * @param array ints where value may be found
	 * @param value int that may be in array
	 * @return index where value is found or -1 if not found
	 * 
	 */
	
	 /* Write main that calls all three algorithms. Have two commented out at a time for testing.
	 * example:
	 * main() {
	 *  int[] array = ArrayOfInts.randomizedArray(size);
     *	int[] array = // create it using the ArrayOfInts methods, this is your "under what conditions" setup
     *	MethodsToAnalyze.find(array,1)
     *	// MethodsToAnalyze.replaceAll(array,1,2)
     *	// MethodsToAnalyze.sortIt(array)
	 *	}
	 */
	
	public static int find(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			numStatements += 2;
			if (array[i] == value) {
				numStatements += 1;
				return i;
			}
			numStatements += 1;
		}
		return -1;
	}

	/**
	 * Replace all occurrences of oldValue with newValue in array.
	 * @param array ints where oldValue may be found
	 * @param oldValue value to replace
	 * @param newValue new value
	 */
	public static void replaceAll(int[] array, int oldValue, int newValue) {
		int index = find(array, oldValue); //Due to "find"'s for loop - expect much bigger numbers
		while (index > -1) {
			array[index] = newValue;
			index = find(array, oldValue);
		}
	}
	
	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * @param array ints that need to be ordered 
	 */
	public static void sortIt(int[] array) {
		for (int next = 1; next < array.length; next++) { //1 + (n(1 + 1))
			int value = array[next]; //1
			int index = next; //1
			while (index > 0 && value < array[index - 1]) { // 2
				array[index] = array[index - 1]; 
				index--;
			}
			array[index] = value; //1
		}
	}
	public static long getStatements() {
		return numStatements;
	}
}
