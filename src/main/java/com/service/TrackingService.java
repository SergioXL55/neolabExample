package com.service;

import com.exception.AnimalCriteriaError;
import com.exception.AnimalNotFoundException;

public interface TrackingService {

    void calculateAnimalsCount() throws AnimalCriteriaError, AnimalNotFoundException;

    String getAnimalCountResult();

}
