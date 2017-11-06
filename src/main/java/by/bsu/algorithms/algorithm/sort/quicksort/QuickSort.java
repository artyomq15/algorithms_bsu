package by.bsu.algorithms.algorithm.sort.quicksort;

import by.bsu.algorithms.algorithm.sort.AbstractSorting;


public class QuickSort extends AbstractSorting{

    public QuickSort(){}

    public QuickSort(int[]array){
        super(array);
    }

    @Override
    public void doSorting(){
        sort(0, array.length-1);
    }

    @Override
    public void doSorting(int low, int high){
        sort(low, high);
    }

    private void sort(int start, int end){
        if (start>=end){
            return;
        }
        int i=start;
        int j=end;
        int cur=i-(i-j)/2;
        while(i<j){
            while(i<cur&&array[i]<=array[cur]){
                i++;
            }
            while(j>cur&&array[j]>=array[cur]){
                j--;
            }
            if (i<j){
                swap(i,j);
                if (i==cur){
                    cur=j;
                }
                else if (j==cur){
                    cur=i;
                }
            }
        }
        sort(start,cur);
        sort(cur+1, end);
    }

    private void swap(int i, int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }


}
