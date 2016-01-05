package com.gildedrose;

class BackstagePassRule extends CommonAgeing {

    public boolean isEligibleFor(Item currentItem) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(getNameOf(currentItem));
    }

    public void update(Item currentItem) {
        if (qualityIsLessThanMaximum(currentItem)) {
            increaseQualityByOne(currentItem);
            decreaseSellInByOne(currentItem);
            addQualityBonusWhenSellInWithinTenDays(currentItem);
            addQualityBonusWhenSellInWithinFiveDays(currentItem);
        }
        zeroQualityWhenSellInHasPast(currentItem);
    }

    private void addQualityBonusWhenSellInWithinTenDays(Item currentItem) {
        addQualityBonusForItemWhenSellInWithinGivenDays(currentItem, 10);
    }

    private void addQualityBonusForItemWhenSellInWithinGivenDays(Item currentItem, int numberOfDays) {
        if (getSellInOf(currentItem) <= numberOfDays) {
            if (qualityIsLessThanMaximum(currentItem)) {
                increaseQualityByOne(currentItem);
            }
        }
    }

    private void addQualityBonusWhenSellInWithinFiveDays(Item currentItem) {
        addQualityBonusForItemWhenSellInWithinGivenDays(currentItem, 5);
    }

    private void zeroQualityWhenSellInHasPast(Item currentItem) {
        if (sellInHasPassedFor(currentItem)) {
            setItemQualityTo(currentItem, 0);
        }
    }
}
