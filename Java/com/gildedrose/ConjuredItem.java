package com.gildedrose;

public class ConjuredItem extends CommonAgeing {
    @Override
    public void update(Item currentItem) {
        decreaseQualityByOne(currentItem);
        decreaseQualityByOne(currentItem);
        decreaseSellInByOne(currentItem);
    }

    @Override
    public boolean isEligibleFor(Item currentItem) {
        return "Conjured Mana Cake".equals(getNameOf(currentItem));
    }
}
