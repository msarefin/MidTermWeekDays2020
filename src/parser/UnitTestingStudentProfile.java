package parser;

import org.testng.Assert;

public class UnitTestingStudentProfile {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.

        Assert.assertEquals(new XmlReader().convertIntToChar("90"),"A");
    }
}
