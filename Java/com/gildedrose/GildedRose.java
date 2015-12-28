package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int itemIndex = 0; itemIndex < items.length; itemIndex++) {
            Item currentItem = items[itemIndex];
            if (!currentItem.name.equals("Aged Brie")
                    && !currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")
                    ) {
                if (getQualityOf(currentItem) > 0) {
                    if (!currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                        setItemQualityTo(currentItem, decrementQualityOfItem(currentItem));
                    }
                }
            } else {
                if (getQualityOf(items[itemIndex]) < 50) {
                    setItemQualityTo(currentItem, incrementQualityOfItem(currentItem));

                    if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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

            if (!currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                currentItem.sellIn = decrementSellInOfItem(currentItem);
            }

            if (getSellInOf(currentItem) < 0) {
                if (!currentItem.name.equals("Aged Brie")) {
                    if (!currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (getQualityOf(currentItem) > 0) {
                            if (!currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
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
