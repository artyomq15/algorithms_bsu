package by.bsu.algorithms.algorithm.search.binary;


public class BinarySearch {
    private int[] array;
    private int counter = 0;

    public BinarySearch() {
    }

    public BinarySearch(int[] array) {
        this.array = array;
    }

    public void setArray(int[] array) {
        this.array = array;
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public int find(int value) {
        counter = 0;
        int i = -1;
        if (array != null) {
            int low = 0;
            int high = array.length;
            int mid;
            while (low < high) {
                counter++;
                mid = (low + high) / 2;
                if (value == array[mid]) {
                    i = mid;
                    break;
                } else if (value < array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return i;
    }
}
