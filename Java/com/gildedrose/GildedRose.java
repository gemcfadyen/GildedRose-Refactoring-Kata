package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;
    private List<AgeingRule> itemAgeingRules = createOrderedAgeingRules();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            for (AgeingRule agingRule : itemAgeingRules) {
                if (agingRule.isEligibleFor(currentItem)) {
                    agingRule.update(currentItem);
                    break;
                }
            }
        }
    }

    private List<AgeingRule> createOrderedAgeingRules() {
        List<AgeingRule> itemAgeingRules = new ArrayList<>();
        itemAgeingRules.add(new AgedBrieItem());
        itemAgeingRules.add(new BackstagePassItem());
        itemAgeingRules.add(new StandardItem());
        return itemAgeingRules;
    }

}
