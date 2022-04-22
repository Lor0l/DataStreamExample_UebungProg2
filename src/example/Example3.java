package example;

import javax.xml.crypto.Data;
import java.io.*;

class Example3 {
    private int values[];

    Example3(int values[]) {
        this.values = values;
    }

    int[] getIntValues() {
        return this.values;
    }

    /**
     * Save member values ('status') to file
     * @param filename
     */
    void save2File(String filename) throws IOException, NullPointerException {

        if (this.values == null) {
            throw new NullPointerException();
        }

        OutputStream os = new FileOutputStream(filename);
        DataOutputStream dos = new DataOutputStream(os);

        int length = this.values.length;
        dos.writeInt(length);

        for (int i = 0; i < length; i++) {
            dos.writeInt(this.values[i]);
        }



    }

    /**
     * Restore status (member value) from file - overwrite existing value
     * @param filename
     */
    void restoreFromFile(String filename) throws IOException {

        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);

        int length = dis.readInt();
        this.values = new int[length];

        for (int i = 0; i < length; i++) {
            this.values[i] = dis.readInt();
        }


    }
}
