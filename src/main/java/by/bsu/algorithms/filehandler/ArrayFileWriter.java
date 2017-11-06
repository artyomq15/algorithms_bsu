package by.bsu.algorithms.filehandler;

import java.io.IOException;
import java.util.Formatter;


public class ArrayFileWriter {

    public void writeArrays(String path, int[][] array) {
        try (Formatter file = new Formatter(path)) {
            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array[0].length; ++j) {
                    file.format("%s ", array[i][j]);
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
