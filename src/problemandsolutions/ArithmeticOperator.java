package problemandsolutions;

import java.util.Scanner;

public class ArithmeticOperator {
    //Write Java program to allow the user to input two integer values and then the program prints the results of adding,
    // subtracting, multiplying, and dividing among the two values.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter First number: ");
        int x = sc.nextInt();
        System.out.println("Please enter the second number: ");
        int y = sc.nextInt();

        System.out.println("Sum: "+adding(x,y));
        System.out.println("Difference: "+subtract(x,y));
        System.out.println("Product: "+multiply(x,y));
        System.out.println("Divide: "+divide(x,y));
    }

    public static double adding(int x , int y){
        return x+y;
    }

    public static double  subtract(int x, int y){
        return x-y;
    }

    public static double  multiply(int x, int y){
        return x*y;
    }

    public static double divide(int x, int y){
        return x/y;
    }
}
