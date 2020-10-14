package com.util;

import com.models.animal.Animal;
import com.models.rules.Rule;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FileUtil {

    final static Logger logger = Logger.getLogger(FileUtil.class);

    public final static String DEFAULT_ANIMALS_FILE_NAME = StringUtils.defaultString(PropertiesLoader.getProperties().getProperty("app.files.animals"));
    public final static String DEFAULT_RULE_FILE_NAME = StringUtils.defaultString(PropertiesLoader.getProperties().getProperty("app.files.rules"));
    private final static String SPLIT = ";";
    private final static String SPLIT_VARIABLES = ",";

    public static List<Animal> loadAnimalsFromFile(String fileName) {
        List<Animal> animals = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                String inputText = bufferedReader.readLine();
                if (StringUtils.isNotBlank(inputText)) {
                    Animal animal = extractAnimalFromText(inputText);
                    animals.add(animal);
                }
            }
        } catch (IOException e) {
            logger.error("Failed to load file with animals:" + e.getMessage());
        }
        return animals;
    }

    public static List<Rule> loadRulesFromFile(String fileName) {
        List<Rule> rules = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                String inputText = bufferedReader.readLine();
                if (StringUtils.isNotBlank(inputText)) {
                    Rule rule = extractRuleFromText(inputText);
                    rules.add(rule);
                }
            }
        } catch (IOException e) {
            logger.error("Failed to load rules file:" + e.getMessage());
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
