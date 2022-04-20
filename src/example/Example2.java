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

        // Integer "value" in String umwandlen
        // --> zusammen mit "stringValue" in gleicher File Speichern
        // --> jeder Wert eigene Zeile um sie zu unterscheiden
        String intToStr = Integer.toString(this.value);

        //PrintStream aufbauen
        OutputStream os = new FileOutputStream(filename);
        PrintStream ps = new PrintStream(os);

        //Wert aus "value" als String in Zeile 1
        ps.println(intToStr);
        //Wert aus "stringValue" in Zeile 2
        ps.println(this.stringValue);
    }

    /**
     * Restore status (member value) from file - overwrite existing value
     * @param filename
     */
    void restoreFromFile(String filename) throws IOException {

        //BufferedReader aufbauen
        InputStream is = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        //Wert "value" als String aus Zeile 1 lesen
        String readLine1 = br.readLine();
        //Wert "stringValue" aus Zeile 2 lesen
        String readLine2 = br.readLine();

        //Wert "value" zurück in Integer umwandeln
        int strToInt = Integer.parseInt(readLine1);

        //Member überschreiben ("final" geändert ?!)
        this.value = strToInt;
        this.stringValue = readLine2;

    }
}
