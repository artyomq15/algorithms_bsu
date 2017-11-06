package by.bsu.algorithms.runner;

import by.bsu.algorithms.algorithm.hashtable.HashTable;
import by.bsu.algorithms.algorithm.hashtable.openaddrhashtable.OpenAddrHashTable;
import by.bsu.algorithms.genetaror.ArrayOfLongGenerator;

import java.util.Scanner;

public class OpenAddrHashTableRunner {
    public static void main(String[] args) {
        int size = 1000;
        long maxValue = 100000;
        /*HashTable openAddrHashTable = new OpenAddrHashTable(size);*/
        HashTable openAddrHashTable = new OpenAddrHashTable(109);
        /*ArrayOfLongGenerator arrayOfLongGenerator = new ArrayOfLongGenerator(size, maxValue);*/
        ArrayOfLongGenerator arrayOfLongGenerator = new ArrayOfLongGenerator(76, maxValue);
        Long[] arr = arrayOfLongGenerator.generateArray();
        for (long val:arr){
            openAddrHashTable.push(val);
        }
        System.out.println(openAddrHashTable);

        Scanner scanner = new Scanner(System.in);
        while(true){
                openAddrHashTable.push(scanner.nextLong());
                System.out.println(openAddrHashTable);

        }

    }
}
