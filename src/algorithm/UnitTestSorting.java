package algorithm;

import org.testng.Assert;

public class UnitTestSorting {

    /*
      This class is about Unit testing for Sorting Algorithm.
     */
    public static void main(String[] args) {
        int[] unSortedArray = {5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, 5, -7, -3, -6, -4, -5};
        int[] sortedArray = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        //Create Sort object
        Sort sort = new Sort();
        //apply unsorted array to selectionSort.
        sort.selectionSort(unSortedArray);
        //verify if the unsorted array is sorted by the selection sort algorithm.
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
//            System.out.println("Sorting Successful");
        } catch (Exception ex) {
            ex.getMessage();
        }

        //Now implement Unit test for rest of the soring algorithm...................below


    }
}
