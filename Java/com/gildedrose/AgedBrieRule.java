package com.gildedrose;

class AgedBrieRule extends CommonAgeing {

    public boolean isEligibleFor(Item currentItem) {
        return "Aged Brie".equals(getNameOf(currentItem));
    }

    public void update(Item currentItem) {
        if (qualityIsLessThanMaximum(currentItem)) {
            increaseQualityByOne(currentItem);
            decreaseSellInByOne(currentItem);
            applyQualityBonusWhenSellInDatePassed(currentItem);
        }
    }

    private void applyQualityBonusWhenSellInDatePassed(Item currentItem) {
        if (sellInHasPassedFor(currentItem)) {
            increaseQualityByOne(currentItem);
        }
    }
}
