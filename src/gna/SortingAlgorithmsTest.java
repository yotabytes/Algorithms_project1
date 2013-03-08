package gna;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A number of JUnit tests for SortingAlgorithms.
 *
 * Feel free to modify these test to check additional properties.
 */
public class SortingAlgorithmsTest {
  
  @Test
  public void testSelectionSort() {
    SortingAlgorithms sorter = new SortingAlgorithms();
    Integer[] array = new Integer[] { 4, 0, 2, 3, 1 };
    sorter.selectionSort(array);    
  }
  
  @Test
  public void testInsertionSort() {
    SortingAlgorithms sorter = new SortingAlgorithms();
    Integer[] array = new Integer[] { 4, 0, 2, 3, 1 };
    sorter.insertionSort(array);
  }

  @Test
  public void testMergeSort() {
    SortingAlgorithms sorter = new SortingAlgorithms();
    Integer[] array = new Integer[] { 4, 0, 2, 3, 1 };
    sorter.mergeSort(array);
  }
  
  @Test
  public void testQuickSort() {
    SortingAlgorithms sorter = new SortingAlgorithms();
    Integer[] array = new Integer[] { 4, 0, 2, 3, 1 };
    sorter.quickSort(array);
  }
  
  @Test
  public void testkWayMergeSort() {
    SortingAlgorithms sorter = new SortingAlgorithms();
    Integer[] array = new Integer[] { 4, 0, 2, 3, 1 };
    sorter.kWayMergeSort(array, 3);
  }
}
