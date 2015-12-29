package com.gildedrose;

public interface AgeingRules {
    void process(Item currentItem);

    boolean eligableFor(Item currentItem);
}
