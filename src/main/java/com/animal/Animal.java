package com.animal;

import java.util.List;

public class Animal {

    private final List<String> animalProperties;

    public Animal(List<String> animalProperties) {
        this.animalProperties = animalProperties;
    }

    public List<String> getAnimalProperties() {
        return animalProperties;
    }
}
