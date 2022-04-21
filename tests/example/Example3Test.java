package example;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Example3Test {

    //Erfolgreich wenn gespeichertes Array "values" mit ausgelesenem übereinstimmt
    @Test
    public void saveRestoreGutTest1() throws IOException, NullPointerException {
        String filename = "example3GutTest1File.txt";
        int[] testArray = {1, 2, 3};
        int[] dummyArray = {7};

        Example3 exaSave = new Example3(testArray);
        exaSave.save2File(filename);

        Example3 exaRead = new Example3(dummyArray);
        exaRead.restoreFromFile(filename);

        //Testet ob testArray mit ausgelesenem Array übereinstimmt
        for (int i = 0; i < exaRead.getIntValues().length; i++) {
            Assert.assertEquals(testArray[i], exaRead.getIntValues()[i]);

        }
    }

    //Erfolgreich wenn keine File zum lesen gefunden und Exception geworfen wird
    @Test(expected = FileNotFoundException.class)
    public void saveRestoreSchlechtTest1() throws IOException, NullPointerException {

        String filename = "example3SchlechtTest1File.txt";
        //int[] testArray = {0, 1, 2, 3, 4, 5};
        int[] dummyArray = {7};

        Example3 exaRead = new Example3(dummyArray);
        exaRead.restoreFromFile(filename);

    }

    @Test(expected = NullPointerException.class)
    public void saveRestoreSchlechtTest2() throws IOException, NullPointerException {

        int[] testArray = null;
        String filename = "example3SchlechtTest2File.txt";

        Example3 exaSave = new Example3(testArray);
        exaSave.save2File(filename);
    }
}
