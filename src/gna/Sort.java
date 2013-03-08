package gna;

import edu.princeton.cs.introcs.StdOut;


public class Sort {

	/**
	 * Tests the amount of compares needed for the chosen algorithm.
	 * @param args[0] Type of algorithm to use (merge, selection, insertion, quick)
	 * @param args[1] Data to be sorted.
	 */
	public static void main(String[] args) {
		
		String algorithm = args[0]; //Type of algorithm to use for sorting.
		Integer[] data;
		final int REPEATS_PER_SIZE = 100; //Amount of repeats for each input size.
		
		SortingAlgorithms sorter = new SortingAlgorithms();
		
		for (int j = 2; j <= 100; j++) { //Loop over data sizes and generate shuffled array for each size
			data = new Integer[j](sorter.getRandomPermutationOfIntegers(j));
		
			for (int i = 0; i < REPEATS_PER_SIZE; i++) { //i = iteration id
				StdOut.print(j);
				StdOut.print(sorter.insertionSort(data));
				StdOut.print(i);
			}
		}

		
	}

}
