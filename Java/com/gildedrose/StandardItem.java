package com.gildedrose;

class StandardItem extends CommonAgeing {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public boolean isEligibleFor(Item currentItem) {
        return notSulfuras(currentItem);
    }

    public void update(Item currentItem) {
        if (qualityIsGreaterThanZero(currentItem)) {
            decreaseQualityByOne(currentItem);
            decreaseSellInByOne(currentItem);
            applyExtraQualityDegradeOnceSellInHasPast(currentItem);
        }
    }

    private boolean notSulfuras(Item currentItem) {
        return !getNameOf(currentItem).equals(SULFURAS);
    }

    private boolean qualityIsGreaterThanZero(Item currentItem) {
        return getQualityOf(currentItem) > 0;
    }

    private void applyExtraQualityDegradeOnceSellInHasPast(Item currentItem) {
        if (sellInHasPassedFor(currentItem)) {
            decreaseQualityByOne(currentItem);
        }
    }
}
