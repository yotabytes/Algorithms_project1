package gna;

import edu.princeton.cs.introcs.StdOut;


public class Sort {
	
	static Integer[] data;
	static int[] permutations;
	
	final static boolean ordered = true; //True if the input data needs to be sorted already, false if you want a random permutation

	/**
	 * Tests the amount of compares needed for the chosen algorithm.
	 * @param args[0] Type of algorithm to use (merge, selection, insertion, quick)
	 */
	public static void main(String[] args) {
		String algorithm = "quick"; //Type of algorithm to use for sorting.
		if (args.length == 1) { //argument given, use this as algorithm
			if (args[0].equals("merge") || args[0].equals("selection") || args[0].equals("insertion") || args[0].equals("quick")) {
				algorithm = args[0];
			}else {
				return;
			}
		}
		
		
		int REPEATS_PER_SIZE = 100; //Amount of repeats for each input size.
		
		if (ordered)
			REPEATS_PER_SIZE = 1; //No point iterating multiple times when the results are all identical (same array used)
		
		SortingAlgorithms sorter = new SortingAlgorithms();
		
		System.out.println(algorithm);
		System.out.println("size compares");
		
		for (int j = 2; j <= 100; j++) { //Loop over data sizes and generate shuffled array for each size
			data = new Integer[j];
			getNewData(j);
			if (algorithm.equals("insertion")) {
				for (int i = 0; i < REPEATS_PER_SIZE; i++) { //i = iteration id
					getNewData(j);
					System.out.print(j + " ");
					System.out.print(sorter.insertionSort(data) + "\n");
				}
			}else if (algorithm.equals("selection")) {
				for (int i = 0; i < REPEATS_PER_SIZE; i++) { //i = iteration id
					getNewData(j);
					System.out.print(j + " ");
					System.out.print(sorter.selectionSort(data) + "\n");
				}
			}else if (algorithm.equals("merge")) {
				for (int i = 0; i < REPEATS_PER_SIZE; i++) { //i = iteration id
					getNewData(j);
					System.out.print(j + " ");
					System.out.print(sorter.mergeSort(data) + "\n");
				}
			}else if (algorithm.equals("quick")) {
				for (int i = 0; i < REPEATS_PER_SIZE; i++) { //i = iteration id
					getNewData(j);
					System.out.print(j + " ");
					System.out.print(sorter.quickSort(data) + "\n");
				}
			}
			
		}

		
	}
	
	/**
	 * Puts new integers in the data array. They will be in sorted or random order, depending on how the 'ordered' flag is set.
	 * @param j The size of the data array.
	 */
	private static void getNewData(int j) { //Put a new random order into the data array
		if (ordered) {
			permutations = (SortingAlgorithms.getArrayOfIntegers(j));
			int k = 0;
			for (int value : permutations) {
			    data[k++] = Integer.valueOf(value);
			}
		}else {
			permutations = (SortingAlgorithms.getRandomPermutationOfIntegers(j));
			int k = 0;
			for (int value : permutations) {
			    data[k++] = Integer.valueOf(value);
			}
		}
	
	}

}
