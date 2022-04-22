package example;

import java.io.*;

class Example4 {
    private int values[];
    private String stringValues[];

    Example4(int values[], String[] stringValues) {
        this.values = values;
        this.stringValues = stringValues;
    }

    int[] getIntValues() {
        return this.values;
    }

    String[] getStringValues() {
        return this.stringValues;
    }

    /**
     * Save member values ('status') to file
     * @param filename
     */
    void save2File(String filename) throws IOException {

        int lengthInt = this.values.length;
        int lengthStr = this.stringValues.length;

        OutputStream os = new FileOutputStream(filename);
        DataOutputStream dos = new DataOutputStream(os);

        dos.writeInt(lengthInt);

        for(int i = 0; i < lengthInt; i++){
            dos.writeInt(this.values[i]);
        }

        dos.writeInt(lengthStr);

        for(int i = 0; i < lengthStr; i++){
            dos.writeUTF(this.stringValues[i]);
        }
    }

    /**
     * Restore status (member value) from file - overwrite existing value
     * @param filename
     */
    void restoreFromFile(String filename) throws IOException {

        int lengthInt;
        int lengthStr;


        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);

        lengthInt = dis.readInt();
        this.values = new int[lengthInt];

        for (int i = 0; i < lengthInt; i++) {
            this.values[i] = dis.readInt();
        }

        lengthStr = dis.readInt();
        this.stringValues = new String[lengthStr];

        for (int i = 0; i < lengthStr; i++) {
            this.stringValues[i] = dis.readUTF();
        }
    }
}
