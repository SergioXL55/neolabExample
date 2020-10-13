package com.service.impl;

import com.animal.Animal;
import com.exception.AnimalCriteriaError;
import com.exception.AnimalNotFoundException;
import com.rules.Rule;
import com.service.TrackingService;
import com.util.FileUtil;

import java.util.List;

public class WantedAnimal implements TrackingService {

    private final List<Animal> animals = FileUtil.loadAnimalsFromFile(FileUtil.DEFAULT_ANIMALS_FILE_NAME);
    private final List<Rule> rules = FileUtil.loadRulesFromFile(FileUtil.DEFAULT_RULE_FILE_NAME);
    private final String result="";

    @Override
    public void calculateAnimalsCount() throws AnimalCriteriaError, AnimalNotFoundException {

    }

    @Override
    public String getAnimalCountResult() {
        return result;
    }
}
