package com.gildedrose;

class GildedRose {
    private static final int MAXIMUM_QUALITY = 50;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public void updateQuality() {
        for (Item currentItem : items) {
            if (notAgedBrie(currentItem)
                    && notBackstagePasses(currentItem)) {
                if (qualityIsGreaterThanZero(currentItem)) {
                    if (notSulfuras(currentItem)) {
                        defaultQualityDecrease(currentItem);
                        defaultSellInDecrement(currentItem);

                        if (getSellInOf(currentItem) < 0 && notSulfuras(currentItem)) {
                            defaultQualityDecrease(currentItem);
                        }
                    }
                }
            } else { //aged brie and backstage passes
                if (qualityIsLessThanMaximum(currentItem)) {
                    defaultQualityIncrease(currentItem);
                    defaultSellInDecrement(currentItem);

                    if (isBackstagePasses(currentItem)) { //is backstage passes
                        additionalQualitySetForBackstagePasses(currentItem);
                        backstagePassesLooseAllValueAfterSellIn(currentItem);
                    }
                    brieIncreasesQualityWithAge(currentItem);
                }
            }

        }
    }

    private void backstagePassesLooseAllValueAfterSellIn(Item currentItem) {
        if (getSellInOf(currentItem) < 0) {
            setItemQualityTo(currentItem, 0);
        }
    }

    private void brieIncreasesQualityWithAge(Item currentItem) {
        if (!notAgedBrie(currentItem)) { //is Brie
            if (getSellInOf(currentItem) < 0) {
                defaultQualityIncrease(currentItem);
            }
        }
    }

    private void defaultQualityDecrease(Item currentItem) {
        setItemQualityTo(currentItem, decrementQualityOfItem(currentItem));
    }

    private void defaultSellInDecrement(Item currentItem) {
        setSellInOf(currentItem, decrementSellInOfItem(currentItem));
    }

    private void defaultQualityIncrease(Item currentItem) {
        setItemQualityTo(currentItem, incrementQualityOfItem(currentItem));
    }

    private void additionalQualitySetForBackstagePasses(Item currentItem) {
        if (isBackstagePasses(currentItem)) {
            if (sellInIsWithinTenDays(currentItem)) {
                if (qualityIsLessThanMaximum(currentItem)) {
                    defaultQualityIncrease(currentItem);
                }
            }

            if (getSellInOf(currentItem) < 6) {
                if (qualityIsLessThanMaximum(currentItem)) {
                    defaultQualityIncrease(currentItem);
                }
            }
        }
    }

    private boolean qualityIsLessThanMaximum(Item currentItem) {
        return getQualityOf(currentItem) < MAXIMUM_QUALITY;
    }

    private boolean sellInIsWithinTenDays(Item currentItem) {
        return getSellInOf(currentItem) < 11;
    }

    private boolean isBackstagePasses(Item currentItem) {
        return getNameOf(currentItem).equals(BACKSTAGE_PASSES);
    }

    private void setSellInOf(Item currentItem, int sellIn) {
        currentItem.sellIn = sellIn;
    }

    private boolean notBackstagePasses(Item currentItem) {
        return !isBackstagePasses(currentItem);
    }

    private boolean notAgedBrie(Item currentItem) {
        return !getNameOf(currentItem).equals(AGED_BRIE);
    }

    private boolean notSulfuras(Item currentItem) {
        return !getNameOf(currentItem).equals(SULFURAS);
    }

    private boolean qualityIsGreaterThanZero(Item currentItem) {
        return getQualityOf(currentItem) > 0;
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private String getNameOf(Item currentItem) {
        return currentItem.name;
    }

    private void setItemQualityTo(Item currentItem, int quality) {
        currentItem.quality = quality;
    }

    private int getQualityOf(Item item) {
        return item.quality;
    }

    private int decrementSellInOfItem(Item currentItem) {
        return getSellInOf(currentItem) - 1;
    }

    private int getSellInOf(Item item) {
        return item.sellIn;
    }

    private int incrementQualityOfItem(Item currentItem) {
        return getQualityOf(currentItem) + 1;
    }

    private int decrementQualityOfItem(Item currentItem) {
        return getQualityOf(currentItem) - 1;
    }
}
