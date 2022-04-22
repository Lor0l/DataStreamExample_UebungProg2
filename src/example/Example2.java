package example;

import java.io.*;

class Example2 {
    private int value;
    private String stringValue;

    Example2(int value, String stringValue) {
        this.value = value;
        this.stringValue = stringValue;
    }

    int getIntValue() {
        return this.value;
    }

    String getStringValue() {
        return this.stringValue;
    }

    /**
     * Save member values ('status') to file
     * @param filename
     */
    void save2File(String filename) throws IOException {

        OutputStream os = new FileOutputStream(filename);
        DataOutputStream dos = new DataOutputStream(os);
        //dos.writeInt(this.value);


        dos.writeInt(this.value);
        dos.writeUTF(this.stringValue);

    }


    /**
     * Restore status (member value) from file - overwrite existing value
     * @param filename
     */
    void restoreFromFile(String filename) throws IOException {

        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);
        this.value = dis.readInt();
        this.stringValue = dis.readUTF();

    }
}
