package com.service.impl;

import com.exception.InvalidRuleOrAnimalException;
import com.models.animal.Animal;
import com.models.rules.Rule;
import com.service.TrackingService;
import com.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AnimalTracking implements TrackingService {

    final static Logger logger = Logger.getLogger(AnimalTracking.class);

    private final List<Animal> animals = FileUtil.loadAnimalsFromFile(FileUtil.DEFAULT_ANIMALS_FILE_NAME);
    private final List<Rule> rules = FileUtil.loadRulesFromFile(FileUtil.DEFAULT_RULE_FILE_NAME);
    private final List<Integer> result = new ArrayList<>();

    @Override
    public void calculateAnimalsCount() {
        for (Rule rule : rules) {
            int animalCount = 0;
            for (Animal animal : animals) {
                if (isValidAnimal(rule, animal)) {
                    animalCount++;
                }
            }
            result.add(animalCount);
        }
    }

    @Override
    public String getAnimalCountResult() {
        StringBuilder stringBuilder = new StringBuilder();
        int ruleNum = 0;
        for (Integer animalCount : result) {
            String message = String.format("Rule %d : found %S animal(s). \n", ++ruleNum, animalCount);
            stringBuilder.append(message);
        }
        return stringBuilder.toString();
    }

    private boolean isValidAnimal(Rule rule, Animal animal) {
        int ruleNum = 0;
        try {
            isValidRuleForThisAnimal(rule, animal);
        } catch (InvalidRuleOrAnimalException e) {
            logger.error("Error while calculate animals: " + e.getMessage());
            return false;
        }
        for (String[] rulesList : rule.getRules()) {
            boolean isValid = false;
            for (String currentRule : rulesList) {
                String[] animalProperties = animal.getAnimalProperties();
                if (StringUtils.isBlank(currentRule) || StringUtils.equalsIgnoreCase(currentRule, animalProperties[ruleNum])) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                return false;
            }
            ruleNum++;
        }
        return true;
    }

    void isValidRuleForThisAnimal(Rule rule, Animal animal) throws InvalidRuleOrAnimalException {
        if (rule.getRules().size() != animal.getAnimalProperties().length) {
            throw new InvalidRuleOrAnimalException();
        }
    }
}
