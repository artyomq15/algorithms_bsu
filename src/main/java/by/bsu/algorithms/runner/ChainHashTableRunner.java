package by.bsu.algorithms.runner;

import by.bsu.algorithms.algorithm.hashtable.HashTable;
import by.bsu.algorithms.algorithm.hashtable.chainhashtable.ChainHashTable;
import by.bsu.algorithms.genetaror.ArrayOfLongGenerator;

import java.util.Scanner;

public class ChainHashTableRunner {
    public static void main(String[] args) {
        HashTable chainHashTable = new ChainHashTable();
        ArrayOfLongGenerator arrayOfLongGenerator = new ArrayOfLongGenerator(100, 1000000);
        chainHashTable.push(219L);
        chainHashTable.push(109L);
        chainHashTable.push(218L);


        Long[] arr = arrayOfLongGenerator.generateArray();
        for (long val:arr){
            chainHashTable.push(val);
        }
        System.out.println(chainHashTable);

        System.out.println(chainHashTable.get(219L));
        chainHashTable.delete(219L);
        System.out.println(chainHashTable.get(219L));

        Scanner scanner = new Scanner(System.in);
        while(true){
            chainHashTable.push(scanner.nextLong());
            System.out.println(chainHashTable);

        }
    }
}
