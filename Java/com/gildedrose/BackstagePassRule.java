package com.gildedrose;

class BackstagePassRule extends CommonAgeing {

    public boolean isEligibleFor(Item currentItem) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(getNameOf(currentItem));
    }

    public void update(Item currentItem) {
        if (qualityIsLessThanMaximum(currentItem)) {
            increaseQualityByOne(currentItem);
            decreaseSellInByOne(currentItem);
            addQualityBonusWhenSellInIsWithinGivenNumberOfDays(currentItem, 10);
            addQualityBonusWhenSellInIsWithinGivenNumberOfDays(currentItem, 5);
        }
        zeroQualityWhenSellInHasPast(currentItem);
    }

    private void zeroQualityWhenSellInHasPast(Item currentItem) {
        if (sellInHasPassedFor(currentItem)) {
            setItemQualityTo(currentItem, 0);
        }
    }

    private void addQualityBonusWhenSellInIsWithinGivenNumberOfDays(Item currentItem, int numberOfDays) {
        if (getSellInOf(currentItem) <= numberOfDays) {
            if (qualityIsLessThanMaximum(currentItem)) {
                increaseQualityByOne(currentItem);
            }
        }
    }
}
