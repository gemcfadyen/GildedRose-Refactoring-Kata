package com.gildedrose;

public interface AgeingRule {
    boolean isEligibleFor(Item currentItem);
    void update(Item currentItem);
}
