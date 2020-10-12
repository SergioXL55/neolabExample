package com.animal;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private List<String> animalProperties = new ArrayList<>();

    public Animal(List<String> animalProperties) {
        this.animalProperties = animalProperties;
    }

    public List<String> getAnimalProperties() {
        return animalProperties;
    }
}
