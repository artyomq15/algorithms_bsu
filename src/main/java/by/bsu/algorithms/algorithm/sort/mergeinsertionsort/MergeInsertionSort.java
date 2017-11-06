package by.bsu.algorithms.algorithm.sort.mergeinsertionsort;

import by.bsu.algorithms.algorithm.sort.insertionsort.InsertionSort;
import by.bsu.algorithms.algorithm.sort.mergesort.MergeSort;


public class MergeInsertionSort extends MergeSort {
    private InsertionSort insertionSort = new InsertionSort();

    public MergeInsertionSort(){}

    public MergeInsertionSort(int[] array){
        super(array);
    }

    @Override
    public void sort(int low, int high){
        if (low < high) {
            int middle = (low + high) / 2;
            if (high - low >= Constants.NUMBER_TO_SORT_INSERTIONS) {
                sort(low, middle);
                sort(middle + 1, high);
            } else {
                insertionSort.setArray(array);
                insertionSort.doSorting(low, high);
                array = insertionSort.getArray();
            }
            merge(low, middle, high);
        }

    }
}
