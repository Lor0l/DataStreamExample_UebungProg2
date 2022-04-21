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
        /*                                                                    //Integer zu Strings
                                                                            //Erzeuge String Array von gleicher Länge wie "values[]"
        String[] valuesAsStrings = new String[this.values.length];

                                                                            //Integer aus "values[]" in Strings umwandeln ...
                                                                            //... und anschließend in neuem String Array "valuesAsStrings[]" ablegen
        for (int i = 0; i < this.values.length; i++) {
            String intToStr = Integer.toString(this.values[i]);
            valuesAsStrings[i] = intToStr;
        }

                                                                            //PrintStream erzeugen
        OutputStream os = new FileOutputStream(filename);
        PrintStream ps = new PrintStream(os);

                                                                            //Erster Eintrag in Speicherdatei ist die Länge von abgespeichertem Array (als String)
        ps.println(Integer.toString(valuesAsStrings.length));

                                                                            //Folgende Einträge sind Array Werte
        for (int i = 0; i < valuesAsStrings.length; i++) {
            ps.println(valuesAsStrings[i]);
        }

        */
        //Zweiter Versuch
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
        /*
                                                                            //BufferedReader erzeugen
        InputStream is = new FileInputStream(filename);
        InputStreamReader irs = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(irs);

                                                                            //Länge von zu lesendem Array erfahren (in Integer umwandeln)
        int length = Integer.parseInt(br.readLine());

                                                                            //String Array für Strings aus Speicherdatei erzeugen
        String[] values = new String[length];

                                                                            //Strings Zeile für Zeile Auslesen und in Array Speichern
        for(int i = 0; i < values.length; i++){
            values[i] = br.readLine();
        }

                                                                            //neues Integer Array für Member "values" mit selber Länge des
                                                                            // ausgelesenen Arrays erzeugen
        this.values = new int[length];
                                                                            //Strings zurück in Integer umwandeln ...
                                                                            //... und in Member "values" speichern
        for(int i = 0; i < values.length; i++){
            this.values[i] = Integer.parseInt(values[i]);
        }
    */
        //Zweiter Versuch
        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);

        int length = dis.readInt();
        this.values = new int[length];

        for (int i = 0; i < length; i++) {
            this.values[i] = dis.readInt();
        }


    }
}
