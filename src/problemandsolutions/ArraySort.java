package problemandsolutions;

import algorithm.Sort;

import java.util.Arrays;
import java.util.Random;

public class ArraySort {
    // By using the bubble sort algorithm, write a Java program to sort an integer array of 10 elements in ascending.
    public static void main(String[] args) {
        int [] n = new int[10];
        Random r = new Random();
        for(int i = 0; i< n.length; i++){
            n[i] = r.nextInt(100);
        }

        System.out.println(Arrays.toString(n));
        sort(n);
        System.out.println(Arrays.toString(n));
    }

    public static void sort(int [] n){
        new Sort().bubbleSort(n);
    }
}
