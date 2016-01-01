package com.gildedrose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rules {
    private List<AgeingRule> rules = new ArrayList<>();

    public Rules(AgeingRule... ageingRules) {
        Collections.addAll(rules, ageingRules);
        rules.add(new StandardRule());
    }

    public List<AgeingRule> getAll() {
        return rules;
    }
}
