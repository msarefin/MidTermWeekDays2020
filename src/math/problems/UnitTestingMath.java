package math.problems;

import org.testng.Assert;

public class UnitTestingMath {
    public static void main(String[] args) {
        //Apply Unit testing into each classes and methods in this package.

        Assert.assertEquals(Factorial.RecursiveFactorial(5), 120);
        int [] fib = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986};
        Assert.assertEquals(Fibonacci.niFibonacci(40),fib);
        int [] array1 = {30,12,5,9,2,20,33,1};
        int [] array2 = {18,25,41,47,17,36,14,19};
        Assert.assertEquals(FindLowestDifference.lowerstDifference(array1, array2),1);
        int [] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};
        Assert.assertEquals(FindMissingNumber.missingNumber(array), 9);
        int  lowest[] = new int[]{211,110,99,34,67,89,67,456,321,456,78,90,45,32,56,78,90,54,32,123,67,5,679,54,32,65};
        Assert.assertEquals(LowestNumber.getLowestNumber(lowest),5);
        int[] arrayA1={1,3,4};
        int [] arrayB1={4,5,6,7,8,7,3};
        int [] merged={1, 3, 4, 5, 6, 7, 8};
        Assert.assertEquals(MergeTwoArraysAndRemoveDuplicatesProgram.arrayMerger(arrayA1, arrayB1),merged);
        int [] pattern = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 88, 86, 84, 82, 80, 78, 76, 74, 72, 70, 67, 64, 61, 58, 55, 52, 49, 46, 43, 40, 36, 32, 28, 24, 20, 16, 12, 8, 4, 0};
        Assert.assertEquals(Pattern.pattern(), pattern);

    }
}
