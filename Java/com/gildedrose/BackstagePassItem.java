package com.gildedrose;

class BackstagePassItem implements AgeingRules {
    private static final int MAXIMUM_QUALITY = 50;
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public void process(Item currentItem) {
        if (qualityIsLessThanMaximum(currentItem)) {
            qualityIncreasesAsSellInDecreases(currentItem);
            additionalQualitySetForBackstagePasses(currentItem);
            backstagePassesLooseAllValueAfterSellIn(currentItem);
        }
    }

    public boolean eligableFor(Item currentItem) {
        return getNameOf(currentItem).equals(BACKSTAGE_PASSES);
    }

    private String getNameOf(Item currentItem) {
        return currentItem.name;
    }

    private boolean qualityIsLessThanMaximum(Item currentItem) {
        return getQualityOf(currentItem) < MAXIMUM_QUALITY;
    }

    private int getQualityOf(Item item) {
        return item.quality;
    }

    private int getSellInOf(Item item) {
        return item.sellIn;
    }

    private void qualityIncreasesAsSellInDecreases(Item currentItem) {
        defaultQualityIncrease(currentItem);
        defaultSellInDecrement(currentItem);
    }

    private void defaultQualityIncrease(Item currentItem) {
        setItemQualityTo(currentItem, incrementQualityOfItem(currentItem));
    }

    private void setItemQualityTo(Item currentItem, int quality) {
        currentItem.quality = quality;
    }

    private void defaultSellInDecrement(Item currentItem) {
        setSellInOf(currentItem, decrementSellInOfItem(currentItem));
    }

    private void setSellInOf(Item currentItem, int sellIn) {
        currentItem.sellIn = sellIn;
    }

    private int incrementQualityOfItem(Item currentItem) {
        return getQualityOf(currentItem) + 1;
    }

    private int decrementSellInOfItem(Item currentItem) {
        return getSellInOf(currentItem) - 1;
    }

    private void additionalQualitySetForBackstagePasses(Item currentItem) {
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

    private boolean sellInIsWithinTenDays(Item currentItem) {
        return getSellInOf(currentItem) < 11;
    }

    private void backstagePassesLooseAllValueAfterSellIn(Item currentItem) {
        if (getSellInOf(currentItem) < 0) {
            setItemQualityTo(currentItem, 0);
        }
    }
}
