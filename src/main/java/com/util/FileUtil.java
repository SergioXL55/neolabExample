package com.util;

import com.animal.Animal;
import com.rules.Rule;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FileUtil {

    private final static String BASE_DIR = System.getProperty("user.dir");
    public final static String DEFAULT_ANIMALS_FILE_NAME = BASE_DIR + "/src/main/resources/incoming/animals/animals";
    public final static String DEFAULT_RULE_FILE_NAME = BASE_DIR + "/src/main/resources/incoming/rules/rules";
    private final static String SPLIT = ";";
    private final static String SPLIT_VARIABLES = ",";

    public static List<Animal> loadAnimalsFromFile(String fileName) {
        List<Animal> animals = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                Animal animal = extractAnimalFromText(bufferedReader.readLine());
                animals.add(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public static List<Rule> loadRulesFromFile(String fileName) {
        List<Rule> rules = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                Rule rule = extractRuleFromText(bufferedReader.readLine());
                rules.add(rule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rules;
    }

    private static Animal extractAnimalFromText(String incomingText) {
        return new Animal(StringUtils.defaultString(incomingText).split(SPLIT));
    }

    private static Rule extractRuleFromText(String incomingText) {
        List<String[]> rules = new ArrayList<>();
        String[] ruleVariables = StringUtils.defaultString(incomingText).split(SPLIT);
        for (String ruleVariable : ruleVariables) {
            rules.add(ruleVariable.split(SPLIT_VARIABLES));
        }
        return new Rule(rules);
    }

}
