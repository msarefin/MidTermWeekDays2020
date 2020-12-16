package string.problems;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {

        /*
         * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".
         * Write Java program to compute all Permutation of a String
         *
         */

//        System.out.println(permut("bob"));
        System.out.println(perm("","aa"));

    }

    public static Set permut(String word) {
        Set permWords = new HashSet();

        if (word.length() == 0 || word == null) {

        } else if (word.length() == 1) {
            permWords.add(word);
        } else {
            permWords=perm("",word);
        }
        return permWords;
    }

    static Set w = new HashSet();
    static Set perm(String p, String r) {

        if (r.length() == 0) {
            w.add(p);
        } else {
            for (int i = 0; i < r.length(); i++) {
                perm(p + r.charAt(i), r.substring(0, i) + r.substring(i + 1, r.length()));
            }

        }
        return w;
    }
}
