package string.problems;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.
        Assert.assertEquals(Anagram.anagram("cat", "act"), true);
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(10,"biological");
        Assert.assertEquals(DetermineLargestWord.findTheLargestWord("Human brain is a biological learning machine"),map);
    }
}
