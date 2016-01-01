package com.gildedrose;

class AgedBrieItem extends CommonAgeing {


    public boolean isEligibleFor(Item currentItem) {
        return getNameOf(currentItem).equals("Aged Brie");
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
