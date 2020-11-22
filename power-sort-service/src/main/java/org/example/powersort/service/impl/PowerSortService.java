package org.example.powersort.service.impl;

import org.example.powersort.model.PowerSort;
import org.example.powersort.service.IPowerSortService;
import org.example.powersort.service.exceptions.NullDataSetException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PowerSortService implements IPowerSortService {

    /**
     * It sorts the given integers, and returns the sorted list of integers as well as the sum of the data set.
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
        int[] sorted = Arrays.stream(dataSet).sorted().toArray();
        return new PowerSort(sorted, Arrays.stream(sorted).sum());
    }
}
