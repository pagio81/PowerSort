package org.example.powersort.service;

import org.example.powersort.model.PowerSort;
import org.example.powersort.service.exceptions.NullDataSetException;
import org.example.powersort.service.impl.PowerSortService;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PowerSortServiceTest {

    IPowerSortService powerSortService = new PowerSortService();

    @Test
    public void test_processing_of_unordered_data_set() {
        //scenario to test that an unordered dataset is sorted correctly and the sum is correct
        int[] dataSet = new int[]{0, 8, 6, 5, 7};
        PowerSort ps = powerSortService.process(dataSet);

        Assert.notNull(ps, "Processed result must not be null");
        Assert.notNull(ps.getSortedDataSet(), "Sorted dataset must not be null");
        Assert.isTrue(ps.getSum() == 26, "The sum of the array must be 26");
        Assert.isTrue(ps.getSortedDataSet()[0] == 0, "The first element of the sorted array must be 0");
        Assert.isTrue(ps.getSortedDataSet()[1] == 5, "The second element of the sorted array must be 5");
        Assert.isTrue(ps.getSortedDataSet()[2] == 6, "The third element of the sorted array must be 6");
        Assert.isTrue(ps.getSortedDataSet()[3] == 7, "The fourth element of the sorted array must be 7");
        Assert.isTrue(ps.getSortedDataSet()[4] == 8, "The fifth element of the sorted array must be 8");
    }

    @Test
    public void sort_ordered_data_set() {
        //scenario to test that an unordered dataset is sorted correctly and the sum is correct
        int[] dataSet = new int[]{1, 2, 4, 5, 10};
        PowerSort ps = powerSortService.process(dataSet);

        Assert.notNull(ps, "Processed result must not be null");
        Assert.notNull(ps.getSortedDataSet(), "Sorted dataset must not be null");
        Assert.isTrue(ps.getSum() == 22, "The sum of the array must be 22");
        Assert.isTrue(ps.getSortedDataSet()[0] == 1, "The first element of the sorted array must be 1");
        Assert.isTrue(ps.getSortedDataSet()[1] == 2, "The second element of the sorted array must be 2");
        Assert.isTrue(ps.getSortedDataSet()[2] == 4, "The third element of the sorted array must be 4");
        Assert.isTrue(ps.getSortedDataSet()[3] == 5, "The fourth element of the sorted array must be 5");
        Assert.isTrue(ps.getSortedDataSet()[4] == 10, "The fifth element of the sorted array must be 10");
    }

    @Test
    public void sort_empty_data_set() {
        //scenario to test that an unordered dataset is sorted correctly and the sum is correct
        int[] dataSet = new int[]{};
        PowerSort ps = powerSortService.process(dataSet);

        Assert.notNull(ps, "Processed result must not be null");
        Assert.notNull(ps.getSortedDataSet(), "Sorted dataset must not be null");
        Assert.isTrue(ps.getSum() == 0, "The sum of the array must be 0");
        Assert.isTrue(ps.getSortedDataSet().length == 0, "The sum of the array must be 0");
    }

    @Test
    public void sort_null_data_set() {
        assertThrows(NullDataSetException.class, () -> powerSortService.process(null),
                "Expected NullDataSetException when passing a null dataset");
    }

    @Test
    public void sort_data_set_containing_duplicates() {
        //scenario to test that dataset containing duplicates is sorted correctly and the sum is correct
        int[] dataSet = new int[]{0, 5, 6, 3, 2, 5};
        PowerSort ps = powerSortService.process(dataSet);

        Assert.notNull(ps, "Processed result must not be null");
        Assert.notNull(ps.getSortedDataSet(), "Sorted dataset must not be null");
        Assert.isTrue(ps.getSum() == 21, "The sum of the array must be 21");
        Assert.isTrue(ps.getSortedDataSet()[0] == 0, "The first element of the sorted array must be 0");
        Assert.isTrue(ps.getSortedDataSet()[1] == 2, "The second element of the sorted array must be 2");
        Assert.isTrue(ps.getSortedDataSet()[2] == 3, "The third element of the sorted array must be 3");
        Assert.isTrue(ps.getSortedDataSet()[3] == 5, "The fourth element of the sorted array must be 5");
        Assert.isTrue(ps.getSortedDataSet()[4] == 5, "The fifth element of the sorted array must be 5");
        Assert.isTrue(ps.getSortedDataSet()[5] == 6, "The sixth element of the sorted array must be 6");

    }

}
