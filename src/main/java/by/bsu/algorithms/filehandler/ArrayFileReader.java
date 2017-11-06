package by.bsu.algorithms.filehandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayFileReader {
    private int size;
    private int numberArrays;

    public ArrayFileReader(int size, int numberArrays){
        this.size = size;
        this.numberArrays = numberArrays;
    }


    public int[][] readArrays(String path) {
        int[][] array = new int[numberArrays][size];
        int i = 0;
        int j = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(path))){

            while (scanner.hasNext()) {
                if (i < size && j < numberArrays) {
                    array[j][i++] = Integer.parseInt(scanner.next());
                } else if (j < numberArrays) {
                    j++;
                    i = 0;
                } else break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

}
