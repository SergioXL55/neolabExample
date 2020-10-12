package com.service.impl;

import com.animal.Animal;
import com.exception.AnimalCriteriaError;
import com.exception.AnimalNotFoundException;
import com.service.TrackingService;
import com.util.FileUtil;

import java.util.List;

public class WantedAnimal implements TrackingService {

    private final String[] allAnimals = FileUtil.loadAnimalsFromFile();
    private final String[] rules = FileUtil.loadRulesFromFile();

    public List<Animal> calculateAnimals() throws AnimalCriteriaError, AnimalNotFoundException {

        return null;
    }
}
