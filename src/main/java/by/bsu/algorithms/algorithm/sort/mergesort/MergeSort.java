package by.bsu.algorithms.algorithm.sort.mergesort;


import by.bsu.algorithms.algorithm.sort.AbstractSorting;

public class MergeSort extends AbstractSorting{
    private int[] helper;

    public MergeSort(){}

    public MergeSort(int[] array){
        super(array);
        helper = new int[array.length];
    }

    @Override
    public void setArray(int[] array){
        super.setArray(array);
        helper = new int[array.length];
    }

    @Override
    public void doSorting() {
        sort(0, array.length - 1);
    }

    @Override
    public void doSorting(int low, int high) {
        sort(low, high);
    }

    protected void sort(int low, int high){
        if (low < high) {
            int middle = (low + high) / 2;
            sort(low, middle);
            sort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    protected void merge(int low, int middle, int high) {
        for (int i = low; i <= high; ++i) {
            helper[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k++] = helper[i++];
            } else {
                array[k++] = helper[j++];
            }
        }

        while (i <= middle) {
            array[k++] = helper[i++];
        }
    }
}
