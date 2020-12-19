package math.problems;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */

        niFibonacci(40);

    }

    public static void niFibonacci(int n){
        int n1 =0;
        int n2 =1;
        int c = 1;
        while(c<=n){
            System.out.println(c+" : "+n1);
            int r = n1+n2;
            c++;
            n1=n2;
            n2=r;

        }
    }

}
