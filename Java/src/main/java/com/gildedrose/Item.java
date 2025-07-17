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

    void updateItem() {
        if (isAgedBrie()) {
            if (quality < 50) {
                quality++;
            }

            sellIn--;

            if (sellIn < 0 && quality < 50) {
                quality++;
            }
        } else {
            if (isBackstagePasses()) {
                if (quality < 50) {
                    quality++;

                    if (sellIn < 11 && quality < 50) {
                        quality++;
                    }

                    if (sellIn < 6 && quality < 50) {
                        quality++;
                    }
                }

                sellIn--;

                if (sellIn < 0) {
                    quality = 0;
                }
            } else if (!isSulfuras()) {
                if (quality > 0) {
                    quality--;
                }

                sellIn--;

                if (sellIn < 0 && quality > 0) {
                    quality--;
                }
            }
        }
    }

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
