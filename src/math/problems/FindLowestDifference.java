package math.problems;

import algorithm.Sort;

public class FindLowestDifference {
    public static void main(String[] args) {
        /*
         Implement in java.
         Read this below two array. Find the lowest difference between the two array cell.
         The lowest difference between cells is 1
        */
        int [] array1 = {30,12,5,9,2,20,33,1};
        int [] array2 = {18,25,41,47,17,36,14,19};


        lowerstDifference(array1, array2);


    }

    public static void lowerstDifference(int [] a1, int [] a2){
        int ld = Integer.MAX_VALUE;
        new Sort().insertionSort(a1);
        new Sort().insertionSort(a2);

        for(int i = 0; i< a1.length; i++){
            int m = a1[i];
            for(int j = 0; j< a2.length; j++) {
                int n = a2[j];
                if(m>n){
                    int x = m-n;
                    if(x<ld){
                        ld = x;
                    }
                }else{
                    int y = n-m;
                    if(y<ld){
                        ld = y;
                    }
                }
            }
        }
        System.out.println(ld);
    }

}
