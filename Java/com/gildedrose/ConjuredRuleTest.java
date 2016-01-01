package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredRuleTest {

    private ConjuredItem conjuredItemRule = new ConjuredItem();
    private Item conjuredItem = new Item("Conjured Mana Cake", 10, 20);

    @Test
    public void conjuredQualityDegredesByTwoPerDay() {
        conjuredItemRule.update(conjuredItem);

        assertThat(conjuredItem.sellIn, is(9));
        assertThat(conjuredItem.quality, is(18));
    }

    @Test
    public void conjuredRuleApplicableToConjuredItems() {
       assertThat(conjuredItemRule.isEligibleFor(conjuredItem), is(true));
    }

    @Test
    public void conjuredRuleNotApplicableToStandardItems() {
        assertThat(conjuredItemRule.isEligibleFor(new Item("Standard", 10, 5)), is(false));
    }
}
