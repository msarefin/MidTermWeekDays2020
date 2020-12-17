package problemandsolutions;

import java.util.Random;

public class RandomNumberGenerate {
    //Write Java program to generate a random number between 1 to 8.
    public static void main(String[] args) {
        NumGen(1,8);
    }

    public static void NumGen(int seed, int range){
        Random r = new Random(seed);
        System.out.println(r.nextInt(range));

    }

}
