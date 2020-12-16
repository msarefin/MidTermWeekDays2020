package string.problems;

import java.util.Locale;

public class Palindrome {
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        isPalendrome("Malayalam");
    }

    public static boolean isPalendrome(String w){
        if(w.length()>0){
            String [] st = w.toLowerCase().split("");
            String Reverse = "";
            for(int i = st.length-1; i>=0; i--) {
                Reverse = new String(Reverse + st[i]);
            }
            if(w.equalsIgnoreCase(Reverse)){
                return true;
            }
        }
        return false;
    }
}
