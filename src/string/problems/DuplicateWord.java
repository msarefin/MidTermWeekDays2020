package string.problems;


import javax.lang.model.type.IntersectionType;
import java.util.HashMap;
import java.util.Map;

public class DuplicateWord {

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        Map<String, Integer> wordCount = duplicateWords(st);
        int averageWordLength = avarageLengthOfWords(st);

        for(Map.Entry<String, Integer> me : wordCount.entrySet()){
            System.out.println(me.getKey()+" : "+me.getValue());
        }

        System.out.println("Average word Length: "+avarageLengthOfWords(st));

    }

    public static Map<String, Integer> duplicateWords(String sentences){
        String cString = sentences.replaceAll("[//W]"," ").toLowerCase();
        String [] words = cString.split(" ");

        Map<String, Integer> duplicate = new HashMap<String, Integer>();
        for(int i = 0; i< words.length; i++){
            if(words[i].equals("")){

            }else{
                int counter = 1;
                duplicate.put(words[i], counter);
                for(int j = i+1; j<words.length; j++){
                    if(words[i].equalsIgnoreCase(words[j])){
                        counter++;
                        words[j] = "";
                    }
                }
                duplicate.put(words[i],counter);
                words[i]="";
            }
        }
        return duplicate;
    }

    public static int avarageLengthOfWords(String st){
        String s = st.replaceAll("[//W]]"," ");
        String [] words = s.split(" ");
        int n = 0;
        int avarage = 0;
        for(String str: words) {
            n = n+str.length();
        }
        avarage = n/words.length;
        return avarage;
    }

}
