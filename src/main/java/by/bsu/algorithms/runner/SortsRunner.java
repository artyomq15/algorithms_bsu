package by.bsu.algorithms.runner;


import by.bsu.algorithms.algorithm.sort.AbstractSorting;
import by.bsu.algorithms.algorithm.sort.mergeinsertionsort.MergeInsertionSort;
import by.bsu.algorithms.algorithm.sort.mergesort.MergeSort;
import by.bsu.algorithms.filehandler.ArrayFileReader;
import by.bsu.algorithms.filehandler.ArrayFileWriter;
import by.bsu.algorithms.genetaror.ArrayGenerator;

import java.io.File;

public class SortsRunner {
    public static void main(String[] args) {
        int size = 1000000;
        int maxValue = 10000000;
        int numberArrays = 20;
        int[][] arrays;
        String filepath = "arrays.txt";

        long start = System.currentTimeMillis();
        File file =  new File(filepath);
        if (!(file.exists() && file.isFile())) {
            ArrayGenerator generator = new ArrayGenerator(size, maxValue, numberArrays);
            ArrayFileWriter arrayFileWriter = new ArrayFileWriter();
            arrayFileWriter.writeArrays(filepath, generator.generateArrays());
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " : time checking or writing");

        start = System.currentTimeMillis();
        ArrayFileReader arrayFileReader = new ArrayFileReader(size,numberArrays);
        arrays = arrayFileReader.readArrays(filepath);
        int[][] arrays2 = arrayFileReader.readArrays(filepath);
        finish = System.currentTimeMillis();
        System.out.println(finish - start + " : time reading");

        start = System.currentTimeMillis();
        for(int[] array: arrays){
            AbstractSorting mergeSort = new MergeSort(array);
            mergeSort.doSorting();

        }
        finish = System.currentTimeMillis();
        System.out.println(finish - start + " : time sorting");

        start = System.currentTimeMillis();
        for(int[] array: arrays2){
            AbstractSorting mergeInsertionSort = new MergeInsertionSort(array);
            mergeInsertionSort.doSorting();

        }
        finish = System.currentTimeMillis();

        System.out.println(finish - start + " : time sorting");
    }
}
