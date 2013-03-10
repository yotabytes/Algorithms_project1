package gna;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;


public class DoubleRatio {

	static Integer[] data;
	static int[] permutations;
	static String algorithm;
	static int MAX = 2500000;
	
	/**
	 * runs a double ratio experiment for insertion sort and quick sort, then outputs the results in terms of time taken and array size.
	 * @param args[0] The algorithm to use.
	 */
	public static void main(String[] args) {
		
		algorithm = "quick"; //Type of algorithm to use for sorting.
		
		
		
		if (args.length == 1) { //argument given, use this as algorithm
			if (args[0].equals("insertion") || args[0].equals("quick")) {
				algorithm = args[0];
			}else {
				return;
			}
		}
		
		System.out.println("Doubling ratio experiment:");
		double prev = timeTrial(125);
		for (int N = 250; N <= MAX; N += N) {
			double time = timeTrial(N);
			StdOut.printf("%6d %7.1f ", N, time);
			StdOut.printf("%5.1f\n", time/prev);
			prev = time;
		}
		
	}
	
	/**
	 * Returns a new random permutation of integers.
	 * @param j Size of the array.
	 * @return Data array.
	 */
	private static Integer[] getNewData(int j) { //Put a new random order into the data array
			 Integer[] generated = new Integer[j];
			permutations = (SortingAlgorithms.getRandomPermutationOfIntegers(j));
			int k = 0;
			for (int value : permutations) {
			    generated[k++] = Integer.valueOf(value);
			}
			return generated;
	
	}
	
	/**
	 * 
	 * @param N Size of input array to trial.
	 * @return running time to sort the given array.
	 */
	public static double timeTrial(int N) {

		SortingAlgorithms Experiment = new SortingAlgorithms();
		Stopwatch timer;
		
		if (algorithm.equals("insertion")) {
				timer = new Stopwatch();
				data = getNewData(N);	
				Experiment.insertionSort(data);
				return timer.elapsedTime();

		} else {
				timer = new Stopwatch();
				data = getNewData(N);	
				Experiment.quickSort(data);
				return timer.elapsedTime();
		}
		
	}
}
