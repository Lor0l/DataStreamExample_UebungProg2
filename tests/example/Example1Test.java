package example;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.spec.ECField;

public class Example1Test {

    // OS schreibt den Int 42 in "gutTestFile1" und IS liest  ihn korrekt aus
    @Test
    public void saveGutTest1() throws IOException{

        int exampleInt = 42;
        int dummyInt = -1;
        String filename = "example1GutTest1File";

        Assert.assertNotEquals(exampleInt, dummyInt);

        Example1 exaSave = new Example1(exampleInt);
        exaSave.save2File(filename);

        Example1 exaRead = new Example1(dummyInt);
        exaRead.restoreFromFile(filename);

        Assert.assertEquals(exampleInt, exaRead.getValue());


    }

    // Datei zum auslesen nicht vorhanden
    @Test (expected = FileNotFoundException.class)
    public void saveSchlechtTest1() throws IOException {

        //int exampleInt = 42;
        int dummyInt = -1;
        String filename = "example1SchlechtTestFile1";

        Example1 exaRestore = new Example1(dummyInt);
        exaRestore.restoreFromFile(filename);


    }






}
