package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;
    private List<AgeingRules> itemAgeingRules = createOrderedAgeingRules();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            for (AgeingRules agingRule : itemAgeingRules) {
                if (agingRule.isEligibleFor(currentItem)) {
                    agingRule.update(currentItem);
                    break;
                }
            }
        }
    }

    private List<AgeingRules> createOrderedAgeingRules() {
        List<AgeingRules> itemAgeingRules = new ArrayList<>();
        itemAgeingRules.add(new AgedBrieItem());
        itemAgeingRules.add(new BackstagePassItem());
        itemAgeingRules.add(new StandardItem());
        return itemAgeingRules;
    }

}
