package com.gildedrose;

public abstract class CommonAgeing implements AgeingRule {
    protected static final int MAXIMUM_QUALITY = 50;

    protected String getNameOf(Item currentItem) {
        return currentItem.name;
    }

    protected int getQualityOf(Item item) {
        return item.quality;
    }

    protected void setItemQualityTo(Item currentItem, int quality) {
        currentItem.quality = quality;
    }

    protected int getSellInOf(Item item) {
        return item.sellIn;
    }

    protected void setSellInOf(Item currentItem, int sellIn) {
        currentItem.sellIn = sellIn;
    }

    protected void increaseQualityByOne(Item currentItem) {
        setItemQualityTo(currentItem, getQualityOf(currentItem) + 1);
    }

    protected void decreaseQualityByOne(Item currentItem) {
        setItemQualityTo(currentItem, minusOneToQualityOf(currentItem));
    }

    private int minusOneToQualityOf(Item currentItem) {
        return getQualityOf(currentItem) - 1;
    }

    protected void decreaseSellInByOne(Item currentItem) {
        setSellInOf(currentItem, getSellInOf(currentItem) - 1);
    }

    protected boolean sellInHasPassedFor(Item currentItem) {
        return getSellInOf(currentItem) < 0;
    }

    protected boolean qualityIsLessThanMaximum(Item currentItem) {
        return getQualityOf(currentItem) < MAXIMUM_QUALITY;
    }

    protected boolean qualityIsGreaterThanZero(Item currentItem) {
        return getQualityOf(currentItem) > 0;
    }
}
