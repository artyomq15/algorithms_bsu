package by.bsu.algorithms.algorithm.search.interpolation;


public class InterpolationSearch {
    private int[] array;
    private int counter;

    public InterpolationSearch(){}

    public InterpolationSearch(int[] array) {
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
        if (array != null) {
            long low = 0;
            long high = array.length-1;
            long mid;
            while (array[(int)low] < value && value < array[(int)high]) {
                counter++;
                mid = low + ((high - low) * (value - array[(int)low])) / (array[(int)high] - array[(int)low]);
                if (array[(int)mid] < value) {
                    low = mid + 1;
                } else if (value < array[(int)mid]) {
                    high = mid - 1;
                } else{
                    return (int)mid;
                }
            }

            if (array[(int)low]==value){
                return (int)low;
            } else if (array[(int)high]==value){
                return (int)high;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
