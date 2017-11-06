package by.bsu.algorithms.algorithm.hashtable.openaddrhashtable;

import by.bsu.algorithms.algorithm.hashtable.Constant;
import by.bsu.algorithms.algorithm.hashtable.HashTable;

import java.util.Arrays;


public class OpenAddrHashTable implements HashTable {
    private int freeCells;

    private Long[] values;

    public OpenAddrHashTable(int size){
        values = new Long[size];
        freeCells = size;
    }

    public void push(Long value){
        int hash = getHash(value);
        while(true){
            if (values[hash]== null){
                values[hash] = value;
                freeCells--;
                return;
            } else if(values[hash].equals(value)){
                return;
            } else {
                if (freeCells <= values.length*30/100){

                    int sizeBefore = values.length;
                    int sizeAfter = values.length + values.length/2;

                    values = Arrays.copyOf(values, sizeAfter);

                    freeCells = freeCells + sizeAfter - sizeBefore;
                }
                if (hash+1 == values.length){
                    hash=0;
                } else {
                    hash++;
                }
            }
        }
    }

    public void delete(Long value){
        int hash = getHash(value);

        while(true){
            if (value.equals(values[hash])){
                values[hash] = null;
                System.out.println("DELETED");
                return;
            } else {
                if (hash+1 == values.length){
                    hash=0;
                } else {
                    hash++;
                    if (hash==getHash(value)){
                        System.out.println("NO SUCH NUMBER TO DELETE");
                        return;
                    }
                }
            }
        }
    }

    public Long get(Long value){
        int hash = getHash(value);

        while(true) {
            if (value.equals(values[hash])) {
                System.out.println(hash);
                return value;
            } else {
                if (hash + 1 == values.length) {
                    hash = 0;
                } else {
                    hash++;
                    if (hash == getHash(value)) {
                        return null;
                    }
                }
            }
        }
    }

    private int getHash(Long value){
        return (int)(value% Constant.CHAIN_HASH_CONSTANT);
    }

    @Override
    public String toString() {
        String toString = "Open Address Hash Table\n";
        for (int i=0; i<values.length; i++){
            toString = toString+" [" + i + "] : " + values[i] + "\n";
        }
        return toString;
    }
}
