package com.gildedrose;

public interface AgeingRules {
    int MAXIMUM_QUALITY = 50;

    void update(Item currentItem);

    boolean isEligibleFor(Item currentItem);
}
