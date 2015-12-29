package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            if (isAgedBrie(currentItem)) {
                AgedBrieItem agedBrieItem = new AgedBrieItem();
                agedBrieItem.process(currentItem);
            } else if (isBackstagePasses(currentItem)) {
                BackstagePassItem backstagePassItem = new BackstagePassItem();
                backstagePassItem.process(currentItem);
            } else if (notSulfuras(currentItem)) {
                StandardItem standardItem = new StandardItem();
                standardItem.process(currentItem);
            }
        }
    }

    private boolean isAgedBrie(Item currentItem) {
        return getNameOf(currentItem).equals(AGED_BRIE);
    }

    private boolean isBackstagePasses(Item currentItem) {
        return getNameOf(currentItem).equals(BACKSTAGE_PASSES);
    }

    private boolean notSulfuras(Item currentItem) {
        return !getNameOf(currentItem).equals(SULFURAS);
    }

    private String getNameOf(Item currentItem) {
        return currentItem.name;
    }
}
