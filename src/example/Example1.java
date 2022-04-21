package example;

import javax.xml.crypto.Data;
import java.io.*;

class Example1 {
    private int value;


    Example1(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }

    /**
     * Save member values ('status') to file
     * @param filename
     */
    void save2File(String filename) throws IOException {

        OutputStream os = new FileOutputStream(filename);
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(this.value);



    }

    /**
     * Restore status (member value) from file - overwrite existing value
     * @param filename
     */
    void restoreFromFile(String filename) throws IOException {

        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);
        this.value = dis.readInt();


    }
}
