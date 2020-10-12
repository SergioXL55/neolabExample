package com.service;

import com.animal.Animal;
import com.exception.AnimalCriteriaError;
import com.exception.AnimalNotFoundException;

import java.util.List;

public interface TrackingService {

    List<Animal> calculateAnimals() throws AnimalCriteriaError, AnimalNotFoundException;

}
