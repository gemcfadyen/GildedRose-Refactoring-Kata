package com.gildedrose;

class StandardItem implements AgeingRules {

    public void process(Item currentItem) {
        if (qualityIsGreaterThanZero(currentItem)) {
            defaultQualityDecrease(currentItem);
            defaultSellInDecrement(currentItem);

            if (getSellInOf(currentItem) < 0) {
                defaultQualityDecrease(currentItem);
            }
        }
    }

    private boolean qualityIsGreaterThanZero(Item currentItem) {
        return getQualityOf(currentItem) > 0;
    }

    private int getQualityOf(Item item) {
        return item.quality;
    }

    private void defaultQualityDecrease(Item currentItem) {
        setItemQualityTo(currentItem, decrementQualityOfItem(currentItem));
    }

    private void setItemQualityTo(Item currentItem, int quality) {
        currentItem.quality = quality;
    }

    private int decrementQualityOfItem(Item currentItem) {
        return getQualityOf(currentItem) - 1;
    }

    private void defaultSellInDecrement(Item currentItem) {
        setSellInOf(currentItem, decrementSellInOfItem(currentItem));
    }

    private void setSellInOf(Item currentItem, int sellIn) {
        currentItem.sellIn = sellIn;
    }

    private int decrementSellInOfItem(Item currentItem) {
        return getSellInOf(currentItem) - 1;
    }

    private int getSellInOf(Item item) {
        return item.sellIn;
    }
}
