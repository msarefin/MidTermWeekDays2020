package algorithm;

import org.testng.Assert;

import java.util.Arrays;

public class UnitTestSorting {

    /*
      This class is about Unit testing for Sorting Algorithm.
     */

    static int[] unSortedArray = null;
    static int[] sortedArray = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};

    public static void main(String[] args) {

        //Create Sort object
        Sort sort = new Sort();
        //apply unsorted array to selectionSort.
        unSortedArray = initialize();
        sort.selectionSort(unSortedArray);
        //verify if the unsorted array is sorted by the selection sort algorithm.
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted -> Insertion sort Failed");
        } catch (Exception ex) {
            ex.getMessage();
        }


        //Now implement Unit test for rest of the soring algorithm...................below
        unSortedArray = initialize();
        sort.bubbleSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted -> BubbleSort sort Failed ");
        } catch (Exception ex) {
            ex.getMessage();
        }

        unSortedArray = initialize();
        sort.insertionSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted -> BubbleSort sort Failed ");
        } catch (Exception ex) {
            ex.getMessage();
        }

        unSortedArray = initialize();
        sort.bucketSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted -> Bucket sort Failed");
        } catch (Exception ex) {
            ex.getMessage();
        }

        unSortedArray = initialize();
        sort.mergeSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted -> Merge sort Failed");
        } catch (Exception ex) {
            ex.getMessage();
        }

        unSortedArray = initialize();
        sort.heapSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array us not sorted -> Heap sort Failed");
        } catch (Exception ex) {
            ex.getMessage();
        }

        unSortedArray = initialize();
        sort.shellSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array us not sorted -> Shell sort Failed");
        } catch (Exception ex) {
            ex.getMessage();
        }

        unSortedArray = initialize();
        sort.quickSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array us not sorted -> Quick sort Failed");
        } catch (Exception ex) {
            ex.getMessage();
        }

    }

    private static int[] initialize() {

        int[] arr = new int[]{5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, 5, -7, -3, -6, -4, -5};
        return arr;

    }
}
