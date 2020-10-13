package com.rules;

import java.util.List;

public class Rule {

    private List<String[]> rules;

    public Rule(List<String[]> rules) {
        this.rules = rules;
    }

    public List<String[]> getRules() {
        return rules;
    }

    public void setRules(List<String[]> rules) {
        this.rules = rules;
    }
}
