package gna;

import edu.princeton.cs.introcs.StdRandom;

/**
 * This class provides a number of sorting algorithms. All sorting algorithms use an array of any comparable data type as input.
 * It involves a number to keep track of the amount of compares used in the current algorithm, and methods for sorting by selection,
 * insertion, 2-way merge, and quicksort.
 * @version 1.1
 * @author Wouter Bruyninckx
 * 
 */
public class SortingAlgorithms {
	private static int currentCompares = 0; // Keeps track of the amount of compares used in the current algorithm.
  /**
   * Sorts the given array using selection sort.
   * @param array The array to be sorted.
   * 
   * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
   */
  public <T extends Comparable<T>> int selectionSort(T[] array) {
	  currentCompares = 0;
    int N = array.length;
    for (int i = 0; i < N; i++) {
    	int min = i;
    	for (int j = i+1; j < N; j++) {
    		if (less(array[j], array[min])) min = j;
    	}
    	exch(array, i, min);
    }
    return currentCompares;
  }
  /**
   * Sorts the given array using insertion sort.
   * @param array The array to be sorted.
   * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
   */
  public <T extends Comparable<T>> int insertionSort(T[] array) {
	  currentCompares = 0;
    int N = array.length;
    for (int i = 1; i < N; i++) {
    	for (int j = i; j > 0 && less(array[j], array[j-1]); j--) {
    		exch(array, j, j-1);
    	}
    }
    return currentCompares;
  }
  private static Comparable[] aux; // Auxiliary array to aid in 2-way merge sorting.
  /**
   * Sorts the given array using (2-way) merge sort.
   *
   * HINT: Java does not supporting creating generic arrays (because the compiler uses type erasure for generic types).
   * For example, the statement "T[] aux = new T[100];" is rejected by the compiler. 
   * Use the statement "T[] aux = (T[]) new Comparable[100];" instead. 
   * Add an "@SuppressWarnings("unchecked")" annotation to prevent the compiler from reporting a warning. 
   * Consult the following url for more information on generics in Java: 
   * http://download.oracle.com/javase/tutorial/java/generics/index.html
   * @param array The array to be sorted.
   * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
   */
  public <T extends Comparable<T>> int mergeSort(T[] array) {
    currentCompares = 0;
    aux = (T[])new Comparable[array.length];
    mSort(array, 0, array.length-1);
    return currentCompares;
  }
  
  /**
   * Recursive part of the 2-way merge sort algorithm. Calls itself until the array to be sorted is too small, then calls merge
   * to merge all sorted subarrays.
   * @param a The array to be sorted.
   * @param lo The lower boundary of the part of the array to be sorted.
   * @param hi The high boundary of the part of the array to be sorted.
   */
  private static <T extends Comparable<T>> void mSort(T[] a, int lo, int hi) {
	  if (hi <= lo) return;
	  int mid = lo + (hi - lo)/2;
	  mSort(a, lo, mid);
	  mSort(a, mid+1, hi);
	  merge(a, lo, mid, hi);
  }
  
  /**
   * 
   * @param a The array to be sorted.
   * @param lo The lower boundary of the part of the array to be sorted.
   * @param mid The middle element that defines the boundary between the left branch and the right branch.
   * @param hi The higher boundary of the part of the array to be sorted.
   */
  public static <T extends Comparable<T>> void merge(T[] a, int lo, int mid, int hi) {
	  int i = lo, j = mid+1;
	  for (int k = lo; k <= hi; k++) //Copy elements of array to be merged to auxiliary array.
		  aux[k] = a[k];
	  for (int k = lo; k <= hi; k++) {
		  if (i > mid) 						a[k] = (T) aux[j++];
		  else if (j > hi) 					a[k] = (T) aux[i++];
		  else if (less(aux[j], aux[i])) 	a[k] = (T) aux[j++];
		  else 								a[k] = (T) aux[i++];
	  }
  }
  
  /**
   * Sorts the given array using quick sort. Do NOT perform a random shuffle.
   * @param array The array to be sorted.
   * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
   */
  public <T extends Comparable<T>> int quickSort(T[] array) {
	currentCompares = 0;
    qSort(array, 0, array.length - 1);
    return currentCompares;
  }
  
  /**
   * Recursive part of the quicksort algorithm. Splits the array to be sorted in two parts, then calls itself on those two parts.
   * @param a The array to be sorted.
   * @param lo The lower boundary of the part of the array to be sorted.
   * @param hi The higher boundary of the part of the array to be sorted.
   */
  private static <T extends Comparable<T>> void qSort(T[] a, int lo, int hi) {
	  if (hi <= lo) return;
	  int j = partition(a, lo, hi);
	  qSort(a, lo, j-1);
	  qSort(a, j+1, hi);
  }
  
  /**
   * 
   * @param a The array to be partitioned.
   * @param lo The lower boundary of the part of the array to be partitioned.
   * @param hi The higher boundary of the part of the array to be partitioned.
   * @return The center element that defines the boundary between the left branch and the right branch.
   */
  private static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
	  int i = lo, j = hi+1; //Left and right scan indices
	  T v = a[lo];
	  while (true) {
		  while (less(a[++i], v)) 
			  if (i == hi) break;
		  while (less(v, a[--j]))
			  if (j == lo) break;
		  if (i >= j) break;
		  exch(a, i, j);
	  }
	  exch(a, lo, j);
	  return j;
  }
  
 /* private static Queue<Comparable>[] kwayaux; //Queue to aid in merging the k-way subarrays
  private static int j = 0; //Identifier for array of queues to merge in k-way merge sort */
  /**
   * Sorts the given array using k-way merge sort. The implementation can assume that k is at least 2. 
   * k is the number of the number of subarrays (at each level) that must be separately sorted via a recursive call and merged via a k-way merge. 
   * For example, if k equals 3, then the array must be subdivided into three subarrays that are each sorted by 3-way merge sort. After the 3 sub-
   * arrays, these sub-arrays are combined via a 3-way merge.
   *
   * Note that if k is larger than the length of the array (or larger than the length of a sub-array in a recursive call), 
   * then the implementation is allowed sort that sub-array using quick sort.
   *
   * @return An non-null array of length 2. The first element of this array is the number of comparisons (i.e. calls to compareTo) performed by
   *         the algorithm, while the second element is the number of data moves.
   */
  
  public <T extends Comparable<T>> int[] kWayMergeSort(T[] array, int k) {
	  //TODO Implement k-way merge sort algorithm.
	  /*currentCompares = 0;
	  kwayaux = (Queue<Comparable>[]) new Object[k+1]; //We only need k+1 queues and reuse the same ones */
	  int[] results = new int[2]; //Wrapper to return two integers
	   /*int lo, hi;
	  lo = 0;						//Initial boundaries are the edges of the array to be sorted.
	  hi = array.length-1;
	  kwayMergeSortRecursive(array, k, lo, hi);
		  */
	  results[0] = currentCompares;
	  return results;
  }
  
  private static <T extends Comparable<T>> void kwayMergeSortRecursive(T[] a,int k, int lo, int hi) {
	  /*if (hi - lo < k) {		//If array to be sorted cannot be split into k parts anymore, use quicksort
		  qSort(a, lo, hi);
		  for (int i = lo; i < hi + 1; i++) {
			  kwayaux[j].enqueue(a[i]); //Add element at position i to Queue j, for all elements in the current subarray
		  }
		  j++; //Increase the Queue index after the current queue is finished to start filling the next queue.
		  return;
	  }
	 if (lo < hi) {
		 for (int i = 0; i < k; i++) {
			 kwayMergeSortRecursive(a, lo + i * (hi-lo+1)/k, lo + (i+1)*(hi-lo+1)/k - 1, k);
		 }
		 kwayMerge(a, lo, hi, k);
	 }*/
  }
  
  private static <T extends Comparable<T>> void kwayMerge(T[] a, int lo, int hi, int k) { //Merge the queues into the original array
	/* IndexMinPQ<T> pq = new IndexMinPQ<T>(k);
	 
	 for (int i = 0; i < k; i++) //Insert all sorted subarrays into binary heap
		 pq.insert(i, a[lo+i*(hi-lo+1)/k]);
	 */
  }
 
  /**
   * Tells the caller whether the first argument is less than the second argument.
   * @param v First element to compare.
   * @param w Second element to compare.
   * @return True if the first argument is smaller, false if the second argument is smaller.
   */
 private static <T extends Comparable<T>> boolean less(T v, T w) {
	 currentCompares++;
	 return v.compareTo(w) < 0;

 }
 
 /**
  * Switches the position of two elements using temporary variable and two data moves.
  * @param a Array that contains elements to be switched.
  * @param i First element position in the array.
  * @param j Second element position in the array.
  */
 private static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
	 T t = a[i]; 
	 a[i] = a[j]; 
	 a[j] = t;
 }
 
 /**
  * Tells the caller whether an array is completely sorted.
  * @param a Array to check.
  * @return True if the array is sorted, false if there are still unsorted elements.
  */
 public static <T extends Comparable<T>> boolean isSorted(T[] a) {
	 for (int i = 1; i < a.length; i++)
		 if (less(a[i], a [i-1])) return false;
	 return true;
 }
 
 /**
  * Creates an array of integers between 0 and size-1, with each integer occuring only once in the array.
  * Then shuffles the array and returns an array of integers between 0 and size-1 in random order.
  * @param size The number of elements in the returned array.
  * @return An array of integers.
  */
 public static int[] getRandomPermutationOfIntegers(int size) {
	 int[] data = new int[size];
	 for (int i = 0; i < size; i++)
		 data[i] = i;
	 StdRandom.shuffle(data);
	 return data;
 }
 
 public static int[] getArrayOfIntegers(int size) {
	 int[] data = new int[size];
	 for (int i = 0; i < size; i++)
		 data[i] = i;
	 return data;
 }

}
