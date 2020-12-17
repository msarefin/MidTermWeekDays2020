package string.problems;


public class Anagram {

    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".
        
    }

    public static boolean isAnagram(String s1, String s2){
        if(s1.length()==s2.length()){
            char [] c1 = initializeChar(s1);
            char [] c2 = initializeChar(s2);

            insertionSortChar(c1);
            insertionSortChar(c2);

            String st1 = new String(c1);
            String st2 = new String(c2);

            if(st1.equalsIgnoreCase(st2)){
                return true;
            }


        }
        return false;
    }

    private static void insertionSortChar(char [] c){
        for(int i = 1; i< c.length; i++){
            char t = c[i];
            int j = i-1;
            while(j>=0 && c[j]>t){
                c[j+1] = c[j];
                j--;
            }
            c[j+1] = t;
        }

    }

    private static char [] initializeChar(String word){

        char [] c = new char[word.length()];
        for(int i = 0; i< c.length; i++){
            c[i]= word.charAt(i);

        }
        return c;
    }
}
