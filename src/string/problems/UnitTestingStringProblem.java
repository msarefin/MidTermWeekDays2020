package string.problems;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.
        Assert.assertEquals(Anagram.isAnagram("cat", "act"), true);
        String sentence = "Human brain is a biological learning machine";
        Map<Integer, String> LongestWord = new HashMap<Integer, String>();
        LongestWord.put(10,"biological");
        Assert.assertEquals(DetermineLargestWord.findTheLargestWord(sentence),LongestWord);
        sentence ="Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        Map<String, Integer> duplicatewords = DuplicateWord.duplicateWords(sentence);
        Assert.assertEquals(DuplicateWord.duplicateWords(sentence), duplicatewords);
        Assert.assertEquals(DuplicateWord.avarageLengthOfWords(sentence),4);
        Assert.assertEquals(Palindrome.isPalendrome("Malayalam"),true);
        Assert.assertEquals(Permutation.permut("Java"), Permutation.perm("","java"));
    }
}
