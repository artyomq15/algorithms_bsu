package by.bsu.algorithms.runner;


import by.bsu.algorithms.algorithm.search.binary.BinarySearch;
import by.bsu.algorithms.algorithm.search.interpolation.InterpolationSearch;
import by.bsu.algorithms.algorithm.sort.mergesort.MergeSort;
import by.bsu.algorithms.filehandler.ArrayFileReader;
import by.bsu.algorithms.filehandler.ArrayFileWriter;
import by.bsu.algorithms.genetaror.ArrayGenerator;

import java.io.File;

public class SearchRunner {
    public static final int VALUE = 9*5*9*9*8;
    public static void main(String[] args) {
        System.out.println(VALUE);
        int size = 1000000;
        int maxValue = 100000000;
        int numberArrays = 50;
        int[][] arrays;
        String filepath = "arraysForSearch.txt";

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

        finish = System.currentTimeMillis();
        System.out.println(finish - start + " : time reading");

        start = System.currentTimeMillis();

        MergeSort mergeInsertionSort = new MergeSort();
        BinarySearch binarySearch = new BinarySearch();
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        for(int[] array: arrays){
            mergeInsertionSort.setArray(array);
            mergeInsertionSort.doSorting();
            int[] sortedArray = mergeInsertionSort.getArray();
            binarySearch.setArray(sortedArray);
            int numberBS = binarySearch.find(VALUE);

            interpolationSearch.setArray(sortedArray);
            int numberIS = interpolationSearch.find(VALUE);

            int counterBS = binarySearch.getCounter();
            int counterIS = interpolationSearch.getCounter();
            System.out.println(numberBS +" - " + numberIS + " | " + counterBS + " / " + counterIS);

        }

        finish = System.currentTimeMillis();
        System.out.println(finish - start + " : time sorting & finding");


    }
}
