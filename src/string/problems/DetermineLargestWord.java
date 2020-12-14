package string.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);
        //implement

    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        //implement
        st = wordGiven.replaceAll("[\\W]"," ");
        String [] words = st.split(" ");
        int max = 0;
        String longestWord = "";

        for(String s: words) {
            if (max < s.length()) {
                max = s.length();
                longestWord = s;
            }
        }
        map.put(max, longestWord);


        return map;
    }
}
