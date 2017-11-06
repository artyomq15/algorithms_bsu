package by.bsu.algorithms.genetaror;


import java.util.Random;

public class ArrayOfLongGenerator {
    private int size;
    private long maxValue;

    public ArrayOfLongGenerator(int size, long maxValue){
        this.size = size;
        this.maxValue = maxValue;
    }

    public Long[] generateArray(){
        Random random = new Random();
        Long[] array = new Long[size];
        for(int i = 0; i < size; ++i) {
            array[i] = (long)random.nextInt((int)maxValue);
        }
        return array;
    }

}
