package by.bsu.algorithms.algorithm.sort.insertionsort;


import by.bsu.algorithms.algorithm.sort.AbstractSorting;

public class InsertionSort extends AbstractSorting{

    public InsertionSort(){}

    public InsertionSort(int[] array) {
        super(array);
    }

    @Override
    public void doSorting(){
        sort(0,array.length-1);
    }

    @Override
    public void doSorting(int low, int high) {
        sort(low, high);
    }

    private void sort(int low, int high){
        int x;
        int j;
        for (int i = low + 1; i <= high; ++i) {
            x = array[i];
            j = i;
            while (j > low && array[j - 1] > x) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = x;
        }
    }
}
