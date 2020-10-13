package com.animal;

public class Animal {

    private final String[] animalProperties;

    public Animal(String... animalProperties) {
        this.animalProperties = animalProperties;
    }

    public String[] getAnimalProperties() {
        return animalProperties;
    }
}
