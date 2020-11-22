package org.example.powersort.web;

import org.example.powersort.model.PowerSort;
import org.example.powersort.service.IPowerSortService;
import org.example.powersort.service.exceptions.NullDataSetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PowerSortController {

    @Autowired
    IPowerSortService powerSortService;

    /**
     * Process the given dataset, return the dataset sorted (ascending)
     * and the sum of the elements of the dataset
     *
     * @param dataSet A list of integers
     * @return A json object containing the given list sorted and the sum of the elements
     */
    @PostMapping("/process")
    public PowerSort process(@RequestBody(required = false) int[] dataSet) {
        try {
            return powerSortService.process(dataSet);
        } catch (NullDataSetException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data Set cannot be null");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error has occurred");
        }
    }

}
