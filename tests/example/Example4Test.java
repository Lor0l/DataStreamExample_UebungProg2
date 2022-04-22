package example;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example4Test {

    @Test
    public void saveRestoreGutTest1() throws IOException {

        String filename = "saveRestoreGutTest1File.txt";

        int[] testInt = {0, 1, 2, 3, 4};
        String[] testString = {"hi", "du"};

        int[] dummyInt = {-1, -2};
        String[] dummyString = {"minusEins", "minusZwei"};

        Example4 exaSave = new Example4(testInt, testString);
        exaSave.save2File(filename);

        Example4 exaRead = new Example4(dummyInt, dummyString);
        exaRead.restoreFromFile(filename);

        /*
        for (int i = 0; i < exaRead.getIntValues().length; i++) {
            Assert.assertEquals(testInt[i], exaRead.getIntValues()[i]);
        }

        for (int i = 0; i < exaRead.getStringValues().length; i++) {
            Assert.assertEquals(testString[i], exaRead.getStringValues()[i]);
        }
        */
        Assert.assertArrayEquals(testInt, exaRead.getIntValues());
        Assert.assertArrayEquals(testString, exaRead.getStringValues());

    }

    @Test(expected = FileNotFoundException.class)
    public void saveRestoreSchlechtTest1() throws IOException {

        String filename = "saveRestoreSchlechtTest1File.txt";

        int[] dummyInt = {-1};
        String[] dummyString = {"dummy"};

        Example4 exaRead = new Example4(dummyInt, dummyString);
        exaRead.restoreFromFile(filename);

    }
}
