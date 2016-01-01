package com.gildedrose;

class StandardRule extends CommonAgeing {

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
        return !"Sulfuras, Hand of Ragnaros".equals(getNameOf(currentItem));
    }

    private void applyExtraQualityDegradeOnceSellInHasPast(Item currentItem) {
        if (sellInHasPassedFor(currentItem)) {
            decreaseQualityByOne(currentItem);
        }
    }
}
