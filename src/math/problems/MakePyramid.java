package math.problems;

import com.mongodb.operation.FsyncUnlockOperation;

public class MakePyramid {
    public static void main(String[] args) {

        /*   Implement a large Pyramid of stars in the screen with java.

                              *
                             * *
                            * * *
                           * * * *
                          * * * * *
                         * * * * * *

        */

        pyramidW("* ",6);

        }

        public static void pyramid(String symbol, int level){
            for(int i = 0; i<level; i++) {
                for(int j = level-i; j>1; j--){
                    System.out.print(" ");
                }
                for(int j =0; j<=i; j++){
                    System.out.print(symbol);
                }
                System.out.println();
            }
        }

        public static void pyramidW(String s, int l){
            int n = 0;
            int g = l-n;
            while(n<=l){
                System.out.println(" ".repeat(g)+s.repeat(n));
                n++;
                g--;
            }
        }

  }
