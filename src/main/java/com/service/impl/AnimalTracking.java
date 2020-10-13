package com.service.impl;

import com.animal.Animal;
import com.exception.AnimalCriteriaError;
import com.exception.AnimalNotFoundException;
import com.rules.Rule;
import com.service.TrackingService;
import com.util.FileUtil;
import org.apache.log4j.Logger;
import java.util.List;

public class AnimalTracking implements TrackingService {

    final static Logger logger = Logger.getLogger(AnimalTracking.class);

    private final List<Animal> animals = FileUtil.loadAnimalsFromFile(FileUtil.DEFAULT_ANIMALS_FILE_NAME);
    private final List<Rule> rules = FileUtil.loadRulesFromFile(FileUtil.DEFAULT_RULE_FILE_NAME);
    private final String result = "";

    @Override
    public void calculateAnimalsCount() throws AnimalCriteriaError, AnimalNotFoundException {

    }

    @Override
    public String getAnimalCountResult() {
        return result;
    }
}
