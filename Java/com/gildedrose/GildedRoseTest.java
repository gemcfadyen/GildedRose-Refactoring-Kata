package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {
    private GildedRose app;

    @Test
    public void qualityOfStandardItemDegradesByOne() {
        app = createGildedRoseAppWith(createStandardItem(1, 5));

        app.updateQuality();

        assertThat(getItemQuality(), is(4));
    }

    @Test
    public void qualityOfStandardItemDegradesTwiceAsFastOnceSellInReached() {
        app = createGildedRoseAppWith(createStandardItem(0, 5));

        app.updateQuality();

        assertThat(getItemQuality(), is(3));
    }

    @Test
    public void qualityOfStandardItemIsNeverNegative() {
        app = createGildedRoseAppWith(createStandardItem(3, 1));

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertThat(getItemQuality(), is(0));
    }

    @Test
    public void brieQualityIncresesByOneIfWithinSellIn() {
        app = createGildedRoseAppWith(item("Aged Brie", 3, 10));

        app.updateQuality();

        assertThat(getItemQuality(), is(11));
    }

    @Test
    public void brieQualityIncreasesAtDoubleRateAfterSellIn() {
        app = createGildedRoseAppWith(item("Aged Brie", 0, 10));

        app.updateQuality();

        assertThat(getItemQuality(), is(12));
    }

    @Test
    public void qualityOfBrieNeverGoesAboveFifty() {
        app = createGildedRoseAppWith(item("Aged Brie", 2, 50));

        app.updateQuality();
        app.updateQuality();

        assertThat(getItemQuality(), is(50));
    }

    @Test
    public void sulfurasDoesNotDecreaseInQuality() {
        app = createGildedRoseAppWith(item("Sulfuras, Hand of Ragnaros", 1, 20));

        app.updateQuality();

        assertThat(getItemQuality(), is(20));
    }

    @Test
    public void backstagePassesHaveNoQualityAfterSellIn() {
        app = createGildedRoseAppWith(item("Backstage passes to a TAFKAL80ETC concert", 0, 20));

        app.updateQuality();

        assertThat(getItemQuality(), is(0));
    }

    private Item item(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    private GildedRose createGildedRoseAppWith(Item item) {
        return new GildedRose(new Item[]{item});
    }

    private Item createStandardItem(int sellIn, int quality) {
        return item("standardItem", sellIn, quality);
    }

    private int getItemQuality() {
        return app.items[0].quality;
    }
}

