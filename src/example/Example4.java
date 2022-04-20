package example;

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
    void save2File(String filename) {
        // TODO
    }

    /**
     * Restore status (member value) from file - overwrite existing value
     * @param filename
     */
    void restoreFromFile(String filename) {
        // TODO
    }
}
