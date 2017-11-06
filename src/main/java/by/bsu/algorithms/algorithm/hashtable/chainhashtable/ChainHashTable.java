package by.bsu.algorithms.algorithm.hashtable.chainhashtable;


import by.bsu.algorithms.algorithm.hashtable.Constant;
import by.bsu.algorithms.algorithm.hashtable.HashTable;

public class ChainHashTable implements HashTable {
    Chain[] chains = new Chain[Constant.CHAIN_HASH_CONSTANT];

    public ChainHashTable(){}

    public void push(Long value){
        int hash = getHash(value);
        System.out.println(hash);
        if (chains[hash]==null){
            chains[hash] = new Chain();
        }
        chains[hash].addValue(value);
    }

    public void delete(Long value){
        chains[getHash(value)].deleteValue(value);
    }

    public Long get(Long value){
        return chains[getHash(value)].getValue(value);
    }

    private int getHash(Long value){
        return (int)(value%Constant.CHAIN_HASH_CONSTANT);
    }

    @Override
    public String toString() {
        String toString = "Chain Hash Table\n";
        for (int i=0; i<Constant.CHAIN_HASH_CONSTANT; i++){
            toString = toString+" [" + i + "] : " + chains[i] + "\n";
        }
        return toString;
    }
}
