package by.bsu.algorithms.algorithm.hashtable.chainhashtable;


import java.util.LinkedList;
import java.util.List;

public class Chain {
    List<Long> values;

    public Chain() {
        values = new LinkedList<>();
    }

    public void addValue(Long value) {
        if (!values.contains(value)){
            values.add(value);
        }
    }

    public Long getValue(Long value) {
        for (Long presentValue : values) {
            if (presentValue.equals(value)) {
                return value;
            }
        }
        return null;
    }

    public void deleteValue(Long value) {
        /*if (!values.contains(value)) {
            values.remove(value);
        }*/
        values.remove(value);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
