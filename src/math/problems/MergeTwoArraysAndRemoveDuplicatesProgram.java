package math.problems;

import algorithm.Sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoArraysAndRemoveDuplicatesProgram {

    // Merge Two Arrays Into Single Sorted Array Without Duplicates
    // given  arrayA={1,3,4}
    // given  arrayB={4,5,6,7,8}
    // output {1,3,4,5,6,7,8}


    public static void main(String[] args)
    {
        int[] arrayA={1,3,4};
        int [] arrayB={4,5,6,7,8,7,3};
        int [] mergedAndSorted = arrayMerger(arrayA, arrayB);
        System.out.println(Arrays.toString(mergedAndSorted));
    }

    public static int [] arrayMerger(int[] a1, int [] a2){
        int k = a1.length+a2.length;
        int [] output = new int[k];

        for(int n : a1){
            output[--k] = n;

        }
        for(int n : a2){
            output[--k] = n;

        }

        new Sort().bubbleSort(output);
        int len = output.length;

        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(output[i]==output[j]){
                    for(int m =j; m<len-1; m++ ){
                        output[m] = output[m+1];
                    }
                    --len;
                }
            }
        }
        int [] r = new int[len];
        for(int i = 0; i< r.length; i++){
            r[i] = output[i];
        }

        return r;
    }



}
