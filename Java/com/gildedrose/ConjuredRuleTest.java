package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredRuleTest {

    private ConjuredRule conjuredRuleRule = new ConjuredRule();

    @Test
    public void conjuredQualityDegredesByTwoPerDay() {
        Item conjuredItem = new Item("Conjured Mana Cake", 10, 20);

        conjuredRuleRule.update(conjuredItem);

        assertThat(conjuredItem.sellIn, is(9));
        assertThat(conjuredItem.quality, is(18));
    }

    @Test
    public void conjuredQualityDoesNotDegradeOnceItIsZero() {
        Item conjuredItem = new Item("Conjured Mana Cake", 12, 0);

        conjuredRuleRule.update(conjuredItem);

        assertThat(conjuredItem.quality, is(0));
    }

    @Test
    public void conjuredQualityWithAQualityOfOneDegradesToZero() {
        Item conjuredItem = new Item("Conjured Mana Cake", 1, 1);

        conjuredRuleRule.update(conjuredItem);

        assertThat(conjuredItem.quality, is(0));
    }

    @Test
    public void conjuredItemsWithSellInOneDegradeByTwo() {
        Item conjuredItem = new Item("Conjured Mana Cake", 1, 5);

        conjuredRuleRule.update(conjuredItem);

        assertThat(conjuredItem.quality, is(3));
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFastWhenSellInHasPassed() {
        Item conjuredItem = new Item("Conjured Mana Cake", 0, 20);

        conjuredRuleRule.update(conjuredItem);

        assertThat(conjuredItem.quality, is(16));
    }

    @Test
    public void conjuredItemsStopAtQualityZeroEvenWhenSellInHasPassed() {
        Item conjuredItem = new Item("Conjured Mana Cake", 0, 3);

        conjuredRuleRule.update(conjuredItem);

        assertThat(conjuredItem.quality, is(0));
    }

    @Test
    public void conjuredRuleApplicableToConjuredItems() {
        assertThat(conjuredRuleRule.isEligibleFor(new Item("Conjured Mana Cake", 10, 20)), is(true));
    }

    @Test
    public void conjuredRuleNotApplicableToStandardItems() {
        assertThat(conjuredRuleRule.isEligibleFor(new Item("Standard", 10, 5)), is(false));
    }
}
