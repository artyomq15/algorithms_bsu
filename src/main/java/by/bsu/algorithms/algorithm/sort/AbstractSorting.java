package by.bsu.algorithms.algorithm.sort;


public abstract class AbstractSorting{
    protected int[] array;

    protected AbstractSorting(){}

    protected AbstractSorting(int[] array){
        //this.array = Arrays.copyOf(array,array.length);
        this.array = array;
    }

    public int[] getArray(){
        return array;
    }

    public void setArray(int[] array){
        //this.array = Arrays.copyOf(array,array.length);
        this.array = array;
    }

    public abstract void doSorting();
    public abstract void doSorting(int low, int high);
}
