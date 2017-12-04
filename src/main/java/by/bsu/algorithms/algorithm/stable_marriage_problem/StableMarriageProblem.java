package by.bsu.algorithms.algorithm.stable_marriage_problem;

import java.util.Arrays;

public class StableMarriageProblem {
    private int[][] men;
    private int[][] women;

    //man - index, position - woman
    private int[] stablePairs;

    private boolean[] freeMen;
    private boolean[] freeWomen;

    //woman - index, position - woman;
    private Integer[] menMaybe;

    public StableMarriageProblem(int[][] m, int[][] w) {
        men = m;
        women = w;

        int length = m.length;
        stablePairs = new int[length];
        initFreeMembersArray(length);
        menMaybe = new Integer[length];
    }

    private void initFreeMembersArray(int length) {
        freeMen = new boolean[length];
        freeWomen = new boolean[length];
        for (int i = 0; i < length; i++) {
            freeMen[i] = true;
            freeWomen[i] = true;
        }
    }

    public Integer[] findStablePairs() {
        int i = 0;
        manStep(i);


        return menMaybe;
    }

    private void manStep(int man) {
        if (freeMen[man]) {
            int woman = chooseBestWoman(men[man]);
            if (women[woman][0] == man) {
                freeMen[man] = false;
                freeWomen[woman] = false;

                menMaybe[woman] = man;
                stablePairs[man] = woman;
                manStep(man == freeMen.length - 1 ? 0 : man + 1);
            } else {
                manStep(chooseBetterMan(woman,man));
            }
        }
    }

    private Integer chooseBestWoman(int[] womenRange) {
        for (int womanInRange : womenRange) {
            for (int womanInStablePair : stablePairs) {
                if (womanInStablePair == womanInRange) {
                    continue;
                }
                if (womanInRange!=-1 && freeWomen[womanInRange]) {
                    return womanInRange;
                }
            }
        }
        return null;
    }

    private Integer chooseBetterMan(int woman, int newMan) {
        Integer beforeMan = menMaybe[woman];
        if (beforeMan == null) {
            menMaybe[woman] = newMan;
            return newMan==freeMen.length-1?0:newMan+1;
        } else {
            if (beforeMan == newMan){
                return newMan==freeMen.length-1?0:newMan+1;
            }
            if (women[woman][0] == newMan){
                freeMen[newMan] = false;
                freeWomen[woman] = false;

                menMaybe[woman] = newMan;
                stablePairs[newMan] = woman;
                removeWomenAfterSayNo(beforeMan,woman);
                return beforeMan;
            }
            for (int men : women[woman]) {
                if (men == newMan) {
                    menMaybe[woman]=newMan;
                    removeWomenAfterSayNo(beforeMan,woman);
                    return beforeMan;
                }
                if (men == beforeMan) {
                    removeWomenAfterSayNo(newMan,woman);
                    return newMan;
                }
            }
        }
        return null;
    }

    private void removeWomenAfterSayNo(int man, int woman){
        for (int i = 0; i<freeWomen.length;i++){
            if (men[man][i] == woman){
                men[man][i] = -1;
                return;
            }
        }
    }
}
