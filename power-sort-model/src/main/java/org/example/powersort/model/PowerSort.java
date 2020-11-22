package org.example.powersort.model;

public class PowerSort {

    private final int[] dataSetSorted;
    private final long dataSetSum;

    public PowerSort(int[] sortedDataSet, long sum) {
        this.dataSetSorted = sortedDataSet;
        this.dataSetSum = sum;
    }

    public int[] getDataSetSorted() {
        return dataSetSorted;
    }

    public long getDataSetSum() {
        return dataSetSum;
    }
}
