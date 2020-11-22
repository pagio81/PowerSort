package org.example.powersort.web;

import org.example.powersort.model.PowerSort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PowerSortControllerTest {

    @Autowired
    private PowerSortController controller;

    @Test
    public void should_process_a_dataset() {
        PowerSort ps = controller.process(new int[]{1, 3, 2});
        Assert.notNull(ps, "Processed result must not be null");
        Assert.notNull(ps.getSortedDataSet(), "Sorted dataset must not be null");
        Assert.isTrue(ps.getSum() == 6, "The sum of the array must be 6");
        Assert.isTrue(ps.getSortedDataSet()[0] == 1, "The first element of the sorted array must be 1");
        Assert.isTrue(ps.getSortedDataSet()[1] == 2, "The second element of the sorted array must be 2");
        Assert.isTrue(ps.getSortedDataSet()[2] == 3, "The third element of the sorted array must be 3");

    }

    @Test
    public void should_not_process_a_null_dataset() {
        assertThrows(ResponseStatusException.class, () -> controller.process(null),
                "Expected ResponseStatusException when passing a null dataset");
    }

}
