package com.gildedrose;

class GildedRose {
    Item[] items;
    private Rules ageingRules = new Rules(new ConjuredRule(), new AgedBrieRule(), new BackstagePassRule());

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            for (AgeingRule ageingRule : ageingRules.getAll()) {
                if (ageingRule.isEligibleFor(currentItem)) {
                    ageingRule.update(currentItem);
                    break;
                }
            }
        }
    }
}
