package math.problems;


public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */

        int Rresult = RecursiveFactorial(5);
        int Iresult = IterativeFactorial(5);

        System.out.println(Rresult);
        System.out.println(Iresult);
    }
    public static int RecursiveFactorial(int n){
      if(n==0){
          return 1;
      }else{
          return n* RecursiveFactorial(n-1);
      }
    }

    public static int IterativeFactorial(int n){
        int r = n;
        while(n>1){
            n--;
            r = r*(n);
        }
        return r;
    }
}
