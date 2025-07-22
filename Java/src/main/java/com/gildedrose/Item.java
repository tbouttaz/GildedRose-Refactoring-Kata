package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void process() {
        if (isAgedBrie()) {
            processAgedBrie();
        } else if (isBackstagePass()) {
            processBackstagePass();
        } else if (isSulfuras()) {
            // Nothing to do - SellIn and Quality stay the same
            return;
        } else {
            processOtherItems();
        }
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    private void processOtherItems() {
        if (quality > 0) {
            quality--;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality > 0) {
                quality--;
            }
        }
    }

    private void processBackstagePass() {
        if (quality < 50) {
            quality++;

            if (sellIn < 11) {
                if (quality < 50) {
                    quality++;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality++;
                }
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }

    private void processAgedBrie() {
        if (quality < 50) {
            quality++;

        }

        sellIn--;

        if (sellIn < 0) {
            if (quality < 50) {
                quality++;
            }
        }
    }

}

