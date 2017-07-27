package com.musala.atmosphere.commons.sa;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Helps to print a data in table format
 * 
 * @author dimcho.nedev
 *
 */
public final class Table {
    private static final String VERTICAL = "|";

    private static final String HORIZONTAL = "=";

    private static final int MAX_LEN = Integer.MIN_VALUE;

    private String[] columnNames;

    private String[][] data;

    private int[] columnWidths;

    private ConsoleControl console;

    public Table(String[] columnNames, String[][] data) {
        this.columnNames = columnNames;
        this.data = data;
        this.columnWidths = new int[columnNames.length];
    }

    /**
     * Prints the table of data on the console.
     * 
     * @param console
     *        - represents the user's console
     */
    public void printTable(ConsoleControl console) {
        this.console = console;
        calculateWidth();
        console.writeLine();
        final int tableWidth = IntStream.of(columnWidths).sum() + 3 * columnNames.length + 1;

        printRow(columnNames);
        console.writeLine(String.join("", Collections.nCopies(tableWidth, HORIZONTAL)));

        Arrays.stream(data).forEach(this::printRow);
    }

    private void calculateWidth() {
        for (int i = 0; i < columnWidths.length; i++) {
            int maxLen = MAX_LEN;

            for (int j = 0; j < data.length; j++) {
                final int currDataLen = data[j][i].length();
                if (currDataLen > maxLen) {
                    maxLen = currDataLen;
                }
            }
            maxLen = Math.max(columnNames[i].length(), maxLen);
            columnWidths[i] = maxLen;
        }
    }

    private void printRow(String[] rowData) {
        console.write(VERTICAL);

        for (int i = 0; i < rowData.length; i++) {
            int padding = columnWidths[i] + 2;
            String data = String.format(" %s ", rowData[i]);
            // padRight the data
            String result = String.format("%1$-" + padding + "s", data);
            console.write(result + VERTICAL);
        }

        console.writeLine();
    }
}
