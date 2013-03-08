package gna;

import java.util.Arrays;
 /**
  * 
  * @version 1.0
  * @author wouterbruyninckx
  *
  */
public class SortingAlgorithmsMain {
  public static void main(String[] args) {
    SortingAlgorithms algorithms = new SortingAlgorithms();
    Integer[] array = new Integer[] { 8, 5, 6, 3, 1, 9, 0, 7, 4, 2 };
    int nbCompares;
	
    System.out.println("********** SELECTION SORT **********");
    array = new Integer[] { 8, 5, 6, 3, 1, 9, 0, 7, 4, 2 };
    System.out.println( "input:  " + Arrays.toString(array));
    nbCompares = algorithms.selectionSort(array);
    System.out.println( "output: " + Arrays.toString(array) + " with " + nbCompares + " comparisons");
	
    System.out.println("********** INSERTION SORT **********");
    array = new Integer[] { 8, 5, 6, 3, 1, 9, 0, 7, 4, 2 };
    System.out.println( "input:  " + Arrays.toString(array));
    nbCompares = algorithms.insertionSort(array);
    System.out.println( "output: " + Arrays.toString(array) + " with " + nbCompares + " comparisons");
	  
    System.out.println("********** MERGE SORT **********");
    array = new Integer[] { 8, 5, 6, 3, 1, 9, 0, 7, 4, 2 };
    System.out.println( "input:  " + Arrays.toString(array));
    nbCompares = algorithms.mergeSort(array);
    System.out.println( "output: " + Arrays.toString(array) + " with " + nbCompares + " comparisons");
	  
    System.out.println("********** QUICK SORT **********");
    array = new Integer[] { 8, 5, 6, 3, 1, 9, 0, 7, 4, 2 };
    System.out.println( "input:  " + Arrays.toString(array));
    nbCompares = algorithms.quickSort(array);
    System.out.println( "output: " + Arrays.toString(array) + " with " + nbCompares + " comparisons");
    
    System.out.println("********** 3-WAY MERGE SORT **********");
    array = new Integer[] { 8, 5, 6, 3, 1, 9, 0, 7, 4, 2 };
    System.out.println( "input:  " + Arrays.toString(array));
    int[] comparesAndMoves = algorithms.kWayMergeSort(array, 3);
    System.out.println( "output: " + Arrays.toString(array) + " with " + comparesAndMoves[0] + " comparisons and " + comparesAndMoves[1] +  " moves");
  }
}

