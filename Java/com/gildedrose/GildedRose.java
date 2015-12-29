package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        AgeingRules ageingBrieRules = new AgedBrieItem();
        AgeingRules backstagePassRules = new BackstagePassItem();
        AgeingRules standardItemRules = new StandardItem();
        List<AgeingRules> itemAgeingRules = new ArrayList();
        itemAgeingRules.add(ageingBrieRules);
        itemAgeingRules.add(backstagePassRules);
        itemAgeingRules.add(standardItemRules);

        for (Item currentItem : items) {
            if (ageingBrieRules.eligableFor(currentItem)) {
                ageingBrieRules.process(currentItem);
            } else if (backstagePassRules.eligableFor(currentItem)) {
                backstagePassRules.process(currentItem);
            } else if (standardItemRules.eligableFor(currentItem)) {
                standardItemRules.process(currentItem);
            }
        }
    }

}
