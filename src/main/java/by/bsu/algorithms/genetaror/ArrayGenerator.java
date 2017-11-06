package by.bsu.algorithms.genetaror;

import java.util.Random;

public class ArrayGenerator {
            private int size;
            private int maxValue;
    private int numberArrays;

    public ArrayGenerator(int size, int maxValue, int numberArrays){
        this.size = size;
        this.maxValue = maxValue;
        this.numberArrays = numberArrays;
    }

    public  int[][] generateArrays(){
        int [][] arrays = new int[numberArrays][size];
        for(int i = 0; i < numberArrays; ++i){
            arrays[i] = generateOneArray();
        }
        return arrays;
    }

    public int[] generateOneArray(){
        Random random = new Random();
        int[] array = new int[size];
        for(int i = 0; i < size; ++i) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }


}
