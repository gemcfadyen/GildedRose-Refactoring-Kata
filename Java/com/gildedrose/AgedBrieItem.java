package com.gildedrose;

class AgedBrieItem extends CommonAgeing {
    private static final String AGED_BRIE = "Aged Brie";


    public boolean isEligibleFor(Item currentItem) {
        return getNameOf(currentItem).equals(AGED_BRIE);
    }

    public void update(Item currentItem) {
        if (qualityIsLessThanMaximum(currentItem)) {
            setItemQualityTo(currentItem, addOneToQualityOf(currentItem));
            setSellInOf(currentItem, minusOneFromSellInOf(currentItem));
            applyQualityBonusWhenSellInDatePassed(currentItem);
        }
    }

    private void applyQualityBonusWhenSellInDatePassed(Item currentItem) {
        if (sellInHasPassedFor(currentItem)) {
            setItemQualityTo(currentItem, addOneToQualityOf(currentItem));
        }
    }
}
