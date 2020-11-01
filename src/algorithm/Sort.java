package algorithm;

import java.util.Arrays;
import java.util.Random;

public class Sort extends helper {

    long executionTime = 0;
	/*
	 * Please implement all the sorting algorithm. Feel free to add helper methods.
	 * Store all the sorted data into one of the databases.
	 */


    public int[] selectionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;

        for(int j=0; j<array.length-1; j++){
            int min = j;
            for(int i=j+1; i<array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] insertionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        for(int i= 1; i< array.length; i++) {
            int t = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > t) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = t;
        }


        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bubbleSort(int [] array){
        int [] list = array;
        //implement here
        for(int i= 0; i< array.length; i++) {
            for (int j = 0; j > array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                }
            }
        }
        
        return list;
    }
    

    public int [] mergeSort(int [] array){
        int [] list = array;
        //implement here
        
        

        return list;
    }
    

    public int [] quickSort(int [] array){
        int [] list = array;
        //implement here
        
        

        return list;
    }
    
    public int [] heapSort(int [] array){
        int [] list = array;
        //implement here
        
        

        return list;
    }


    public int [] bucketSort(int [] array){
        int [] list = array;
        //implement here
        
        

        return list;
    }
    
    public int [] shellSort(int [] array){
        int [] list = array;
        //implement here
        
        

        return list;
    }

    public static void printSortedArray(int [] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}

class helper {

    int[] initialize(int[] a) {
        int[] arr = null;
        if (a == null || a.length == 0) {
            arr = new int[10];
            Random r = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(100);
            }
        } else {
            arr = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                arr[i] = a[i];
            }
        }

        return arr;
    }

     final void swap(int[] arr, int m, int n) {
        int t = arr[m];
        arr[m] = arr[n];
        arr[n] = t;
    }

     final void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

     final double sqrt(double n) {
        double t;
        double sq = n / 2;
        do {
            t = sq;
            sq = (t + (n / t)) / 2;
        } while ((t - sq) != 0);
        return sq;
    }
}