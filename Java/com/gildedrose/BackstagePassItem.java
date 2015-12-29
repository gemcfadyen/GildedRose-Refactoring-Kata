package com.gildedrose;

class BackstagePassItem extends CommonAgeing {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public boolean isEligibleFor(Item currentItem) {
        return getNameOf(currentItem).equals(BACKSTAGE_PASSES);
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
