package math.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */

       int [] fib =  niFibonacci(40);

        System.out.println(Arrays.toString(fib));

    }

    public static int [] niFibonacci(int n){
        int n1 =0;
        int n2 =1;
        int c = 1;
        List fib = new ArrayList();
        while(c<=n){
//            System.out.println(c+" : "+n1);
            fib.add(n1);
            int r = n1+n2;
            c++;
            n1=n2;
            n2=r;

        }

        int [] fibo = new int[fib.size()];

        for(int i = 0; i< fib.size(); i++){
            fibo[i] = (int)fib.get(i);
        }

        return fibo;
    }

}
