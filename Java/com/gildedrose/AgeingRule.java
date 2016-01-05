package com.gildedrose;

public interface AgeingRule {
    void update(Item currentItem);
    boolean isEligibleFor(Item currentItem);
}
