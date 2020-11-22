package org.example.powersort.service.impl;

import org.example.powersort.model.PowerSort;
import org.example.powersort.service.IPowerSortService;
import org.example.powersort.service.exceptions.NullDataSetException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PowerSortService implements IPowerSortService {

    /**
     * It sorts the given integers, and returns the sorted list of integers
     * as well as the sum of the data set.
     * The implementation uses Java 8 streams in some way.
     * The sorting is implemented manually not using a sorting library
     *
     * @param dataSet
     * @return
     */
    public PowerSort process(int[] dataSet) {
        if (dataSet == null) {
            throw new NullDataSetException();
        }
        //sort the dataset
        sort(dataSet);
        //using Streams to calculate the sum
        return new PowerSort(dataSet, Arrays.stream(dataSet).sum());
    }

    /**
     * Sorts the dataSet.
     * The easiest and simple way to implement a sorting algorithm
     * is to travers the dataset and swap adjacent elements if they are in the wrong order.
     * The dataset needs to be traversed n times till no swap occur
     * The (average) complexity function of this algorithm is O(n^2) as it nests 2 loops
     *
     * Assumption: cannot use Arrays.stream(dataSet).sorted().toArray() is it would use
     * a 3rd party API to sort the array
     *
     * @param dataSet
     * @return
     */
    private void sort(int[] dataSet) {
        int temp; // temp variable used for the swap
        int size = dataSet.length; //size of the array
        boolean isSwapped; // set to true if a swap occurred, if false the dataset is fully sorted
        for (int i = 0; i < size - 1; i++) {
            //re-init to get ready for next loop
            isSwapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (dataSet[j + 1] < dataSet[j]) {
                    //if element at index j + 1 is smaller than element at j
                    //they need to be swapped
                    temp = dataSet[j];
                    dataSet[j] = dataSet[j + 1];
                    dataSet[j + 1] = temp;
                    isSwapped = true; // certify a swapped occurred
                }
            }
            //if no swap occurred, the dataset is already sorted and the loop can be broken
            if (isSwapped == false) {
                break;
            }
        }
    }
}
