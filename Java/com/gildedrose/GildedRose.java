package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private Item[] items;

    public void updateQuality() {
        for (Item currentItem : items) {
            if (notAgedBrie(currentItem)
                    && notBackstagePasses(currentItem)
                    ) {
                if (qualityIsGreaterThanZero(currentItem)) {
                    if (notSulfuras(currentItem)) {
                        setItemQualityTo(currentItem, decrementQualityOfItem(currentItem));
                    }
                }
            } else {
                if (getQualityOf(currentItem) < 50) {
                    setItemQualityTo(currentItem, incrementQualityOfItem(currentItem));

                    if (getNameOf(currentItem).equals(BACKSTAGE_PASSES)) {
                        if (getSellInOf(currentItem) < 11) {
                            if (getQualityOf(currentItem) < 50) {
                                setItemQualityTo(currentItem, incrementQualityOfItem(currentItem));
                            }
                        }

                        if (getSellInOf(currentItem) < 6) {
                            if (getQualityOf(currentItem) < 50) {
                                setItemQualityTo(currentItem, incrementQualityOfItem(currentItem));
                            }
                        }
                    }
                }
            }

            if (notSulfuras(currentItem)) {
                setSellInOf(currentItem, decrementSellInOfItem(currentItem));
            }

            if (getSellInOf(currentItem) < 0) {
                if (notAgedBrie(currentItem)) {
                    if (notBackstagePasses(currentItem)) {
                        if (qualityIsGreaterThanZero(currentItem)) {
                            if (notSulfuras(currentItem)) {
                                setItemQualityTo(currentItem, decrementQualityOfItem(currentItem));
                            }
                        }
                    } else {
                        setItemQualityTo(currentItem, 0);
                    }
                } else {
                    if (getQualityOf(currentItem) < 50) {
                        setItemQualityTo(currentItem, incrementQualityOfItem(currentItem));
                    }
                }
            }
        }
    }

    private void setSellInOf(Item currentItem, int sellIn) {
        currentItem.sellIn = sellIn;
    }

    private boolean notBackstagePasses(Item currentItem) {
        return !getNameOf(currentItem).equals(BACKSTAGE_PASSES);
    }

    private boolean notAgedBrie(Item currentItem) {
        return !getNameOf(currentItem).equals(AGED_BRIE);
    }

    private boolean notSulfuras(Item currentItem) {
        return !getNameOf(currentItem).equals(SULFURAS);
    }

    private boolean qualityIsGreaterThanZero(Item currentItem) {
        return getQualityOf(currentItem) > 0;
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private String getNameOf(Item currentItem) {
        return currentItem.name;
    }

    public Item[] getItems() {
        return items;
    }

    private void setItemQualityTo(Item currentItem, int quality) {
        currentItem.quality = quality;
    }

    private int getQualityOf(Item item) {
        return item.quality;
    }

    private int decrementSellInOfItem(Item currentItem) {
        return getSellInOf(currentItem) - 1;
    }

    private int getSellInOf(Item item) {
        return item.sellIn;
    }

    private int incrementQualityOfItem(Item currentItem) {
        return getQualityOf(currentItem) + 1;
    }

    private int decrementQualityOfItem(Item currentItem) {
        return getQualityOf(currentItem) - 1;
    }
}
