package com.gildedrose;

public class ConjuredRule extends CommonAgeing {
    @Override
    public void update(Item currentItem) {
        deductOneWhenQualityIsAboveZero(currentItem);
        deductOneWhenQualityIsAboveZero(currentItem);
        decreaseSellInByOne(currentItem);

        applyExtraQualityDegradeOnceSellInHasPast(currentItem);
    }

    @Override
    public boolean isEligibleFor(Item currentItem) {
        return "Conjured Mana Cake".equals(getNameOf(currentItem));
    }

    private void deductOneWhenQualityIsAboveZero(Item currentItem) {
        if (qualityIsGreaterThanZero(currentItem)) {
            decreaseQualityByOne(currentItem);
        }
    }

    private void applyExtraQualityDegradeOnceSellInHasPast(Item item) {
        if (sellInHasPassedFor(item)) {
            deductOneWhenQualityIsAboveZero(item);
            deductOneWhenQualityIsAboveZero(item);
        }
    }
}
