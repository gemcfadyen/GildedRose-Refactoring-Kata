package com.gildedrose;

class GildedRose {
    private static final int MAXIMUM_QUALITY = 50;
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

    private boolean qualityIsGreaterThanZero(Item currentItem) {
        return getQualityOf(currentItem) > 0;
    }

    private String getNameOf(Item currentItem) {
        return currentItem.name;
    }

    private int getQualityOf(Item item) {
        return item.quality;
    }

    private class StandardItem {

        private void defaultQualityDecrease(Item currentItem) {
            setItemQualityTo(currentItem, decrementQualityOfItem(currentItem));
        }

        private int decrementQualityOfItem(Item currentItem) {
            return getQualityOf(currentItem) - 1;
        }

        private int decrementSellInOfItem(Item currentItem) {
            return getSellInOf(currentItem) - 1;
        }

        private void defaultSellInDecrement(Item currentItem) {
            setSellInOf(currentItem, decrementSellInOfItem(currentItem));
        }

        private int getSellInOf(Item item) {
            return item.sellIn;
        }

        private void setSellInOf(Item currentItem, int sellIn) {
            currentItem.sellIn = sellIn;
        }

        private void setItemQualityTo(Item currentItem, int quality) {
            currentItem.quality = quality;
        }

        private void process(Item currentItem) {
            if (qualityIsGreaterThanZero(currentItem)) {
                defaultQualityDecrease(currentItem);
                defaultSellInDecrement(currentItem);

                if (getSellInOf(currentItem) < 0) {
                    defaultQualityDecrease(currentItem);
                }
            }
        }
    }
}
