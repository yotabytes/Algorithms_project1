package gna;

import edu.princeton.cs.introcs.Stopwatch;


public class DoubleRatio {

	static Integer[] data;
	static int[] permutations;
	
	/**
	 * runs a double ratio experiment for insertion sort and quick sort, then outputs the results in terms of time taken and array size.
	 * @param args[0] The algorithm to use.
	 */
	public static void main(String[] args) {
		String algorithm = "insertion"; //Type of algorithm to use for sorting.
		if (args.length == 1) { //argument given, use this as algorithm
			if (args[0].equals("insertion") || args[0].equals("quick")) {
				algorithm = args[0];
			}else {
				return;
			}
		}
		
		final int DOUBLETIMES = 10; //Times to double the array size and calculate the running time.
		final int STARTINGSIZE = 10000; //Size of the first array of the experiment.
		int currentsize = STARTINGSIZE;
		
		SortingAlgorithms Experiment = new SortingAlgorithms();
		Stopwatch timer;
		
		if (algorithm.equals("insertion")) {
			System.out.println("Insertion sort doubling ratio experiment:");
			for (int i = 0; i < DOUBLETIMES; i++) {
				timer = new Stopwatch();
				data = getNewData(currentsize);	
				Experiment.insertionSort(data);
				System.out.print(currentsize + " " + timer.elapsedTime() + "\n");
				currentsize *=2;
			}
		}
		
	}
	
	/**
	 * Returns a new random permutation of integers.
	 * @param j Size of the array.
	 */
	private static Integer[] getNewData(int j) { //Put a new random order into the data array
			 Integer[] generated = new Integer[j];
			permutations = (SortingAlgorithms.getArrayOfIntegers(j));
			int k = 0;
			for (int value : permutations) {
			    generated[k++] = Integer.valueOf(value);
			}
			return generated;
	
	}

}
