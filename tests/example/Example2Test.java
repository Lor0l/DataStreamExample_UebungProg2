package example;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Example2Test {

    //Erfolgreich wenn abgespeicherte Values mit den ausgelesenen übereinstimmen
    @Test
    public void saveRestoreGutTest1() throws IOException {

        String filename = "example2GutTest1File.txt";

        int exampleInt = 42;
        int dummyInt = -1;

        String exampleString = "example";
        String dummyString = "dummy";

        Example2 exaSave = new Example2(exampleInt, exampleString);
        exaSave.save2File(filename);

        Example2 exaRead = new Example2(dummyInt, dummyString);
        exaRead.restoreFromFile(filename);

        Assert.assertEquals(exampleInt, exaRead.getIntValue());
        Assert.assertEquals(exampleString, exaRead.getStringValue());

    }

    //Erfolgreich wenn keine File zum auslesen Vorhanden und Exception geworfen wird
    @Test (expected = IOException.class)
    public void saveRestoreSchlechtTest1() throws IOException {

        String filename = "example2SchlechtTest1File";

        //int exampleInt = 42;
        int dummyInt = -1;

        //String exampleString = "example";
        String dummyString = "dummy";

        Example2 exaRead = new Example2(dummyInt, dummyString);
        exaRead.restoreFromFile(filename);

    }

}
