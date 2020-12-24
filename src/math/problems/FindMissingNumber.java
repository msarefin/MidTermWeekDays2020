package math.problems;

import algorithm.Sort;

public class FindMissingNumber {

    public static void main(String[] args) {
        /*
         * If n = 10, then array will have 9 elements in the range from 1 to 10.
         * For example {10, 2, 1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).
         * Write java code to find the missing number from the array. Write static helper method to find it.
         */
         int [] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};
         int n = 9;
         int x = missingNumber(array);
         System.out.println(x);
    }

    public static int missingNumber(int [] arr){
        new Sort().insertionSort(arr);
        int missing  = 0;
        int size = arr.length;
        if(size >0){
            int total = (size+1)*(size+2)/2;
            for(int i = 0; i< arr.length; i++){
                total -=arr[i];
            }
            missing = total;
        }

        return missing;
    }
}
