package com.util;

import com.animal.Animal;
import com.rules.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Loading data from file")
class FileUtilTest {

    @DisplayName("Load valid animal file with content")
    @Test
    void loadAnimalsFromValidFile() {
        List<Animal> animals = FileUtil.loadAnimalsFromFile(FileUtil.DEFAULT_ANIMALS_FILE_NAME);
        assertNotNull(animals);
        assertTrue(animals.size() != 0);
    }

    @DisplayName("Load valid rules file with content")
    @Test
    void loadRulesFromValidFile() {
        List<Rule> rules = FileUtil.loadRulesFromFile(FileUtil.DEFAULT_RULE_FILE_NAME);
        assertNotNull(rules);
        assertTrue(rules.size() != 0);
    }

    @DisplayName("Try to load data from empty files")
    @Test
    void loadFromEmptyFile() {
        try {
            String fileName = File.createTempFile("tempFile", "").getAbsolutePath();
            List<Animal> animals = FileUtil.loadAnimalsFromFile(fileName);
            assertNotNull(animals);
            assertEquals(0, animals.size());
            List<Rule> rules = FileUtil.loadRulesFromFile(fileName);
            assertNotNull(rules);
            assertEquals(0, rules.size());
        } catch (Exception e) {
            fail();
        }
    }

    @DisplayName("Try to load data from non-existing files")
    @ParameterizedTest
    @ValueSource(strings = {"File", "FileOne", "FileTwo"})
    void tryToLoadFromNonExistingFile(String fileName) {
        try {
            List<Animal> animals = FileUtil.loadAnimalsFromFile(fileName);
            assertNotNull(animals);
            assertEquals(0, animals.size());
            List<Rule> rules = FileUtil.loadRulesFromFile(fileName);
            assertNotNull(rules);
            assertEquals(0, rules.size());
        } catch (Exception e) {
            fail();
        }
    }

}