package org.example.powersort.model;

public class PowerSort {

    private final int[] sortedDataSet;
    private final long sum;

    public PowerSort(int[] sortedDataSet, long sum) {
        this.sortedDataSet = sortedDataSet;
        this.sum = sum;
    }

    public int[] getSortedDataSet() {
        return sortedDataSet;
    }

    public long getSum() {
        return sum;
    }
}
