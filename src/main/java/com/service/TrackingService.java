package com.service;

import com.exception.InvalidRuleOrAnimalException;

public interface TrackingService {

    void calculateAnimalsCount() throws InvalidRuleOrAnimalException;

    String getAnimalCountResult();

}
