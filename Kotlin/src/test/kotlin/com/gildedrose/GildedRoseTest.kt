package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun thirty_days() {
        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20),  //
            Item("Aged Brie", 2, 0),  //
            Item("Elixir of the Mongoose", 5, 7),  //
            Item("Sulfuras, Hand of Ragnaros", 0, 80),  //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            Item("Conjured Mana Cake", 3, 6) // this conjured item does not work properly yet
        )
        val app = GildedRose(items)
        val days = 30

        assertEquals("+5 Dexterity Vest", app.items[0].name)

        for (i in 0..days) {
            println("-------- day " + i + " --------")
            println("name, sellIn, quality")
            for (item in items) {
                println(item)
            }
            println()

            checkDay(i, items)
            app.updateQuality()
        }
    }

    private fun checkDay(dayNumber: Int, items: List<Item>) {
        if (dayNumber == 0) {
            assertEquals("+5 Dexterity Vest, 10, 20", items[0].toString())
            assertEquals("Aged Brie, 2, 0", items[1].toString())
            assertEquals("Elixir of the Mongoose, 5, 7", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 15, 20", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 10, 49", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 5, 49", items[7].toString())
            assertEquals("Conjured Mana Cake, 3, 6", items[8].toString())
        }
        if (dayNumber == 1) {
            assertEquals("+5 Dexterity Vest, 9, 19", items[0].toString())
            assertEquals("Aged Brie, 1, 1", items[1].toString())
            assertEquals("Elixir of the Mongoose, 4, 6", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 21", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 4, 50", items[7].toString())
            assertEquals("Conjured Mana Cake, 2, 5", items[8].toString())
        }
        if (dayNumber == 2) {
            assertEquals("+5 Dexterity Vest, 8, 18", items[0].toString())
            assertEquals("Aged Brie, 0, 2", items[1].toString())
            assertEquals("Elixir of the Mongoose, 3, 5", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 13, 22", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 8, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 50", items[7].toString())
            assertEquals("Conjured Mana Cake, 1, 4", items[8].toString())
        }
        if (dayNumber == 3) {
            assertEquals("+5 Dexterity Vest, 7, 17", items[0].toString())
            assertEquals("Aged Brie, -1, 4", items[1].toString())
            assertEquals("Elixir of the Mongoose, 2, 4", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 12, 23", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 7, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 2, 50", items[7].toString())
            assertEquals("Conjured Mana Cake, 0, 3", items[8].toString())
        }
        if (dayNumber == 4) {
            assertEquals("+5 Dexterity Vest, 6, 16", items[0].toString())
            assertEquals("Aged Brie, -2, 6", items[1].toString())
            assertEquals("Elixir of the Mongoose, 1, 3", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 11, 24", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 6, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 1, 50", items[7].toString())
            assertEquals("Conjured Mana Cake, -1, 1", items[8].toString())
        }
        if (dayNumber == 5) {
            assertEquals("+5 Dexterity Vest, 5, 15", items[0].toString())
            assertEquals("Aged Brie, -3, 8", items[1].toString())
            assertEquals("Elixir of the Mongoose, 0, 2", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 10, 25", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 5, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 0, 50", items[7].toString())
            assertEquals("Conjured Mana Cake, -2, 0", items[8].toString())
        }
        if (dayNumber == 6) {
            assertEquals("+5 Dexterity Vest, 4, 14", items[0].toString())
            assertEquals("Aged Brie, -4, 10", items[1].toString())
            assertEquals("Elixir of the Mongoose, -1, 0", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 27", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 4, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", items[7].toString())
            assertEquals("Conjured Mana Cake, -3, 0", items[8].toString())
        }
        if (dayNumber == 7) {
            assertEquals("+5 Dexterity Vest, 3, 13", items[0].toString())
            assertEquals("Aged Brie, -5, 12", items[1].toString())
            assertEquals("Elixir of the Mongoose, -2, 0", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 8, 29", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -2, 0", items[7].toString())
            assertEquals("Conjured Mana Cake, -4, 0", items[8].toString())
        }
        if (dayNumber == 8) {
            assertEquals("+5 Dexterity Vest, 2, 12", items[0].toString())
            assertEquals("Aged Brie, -6, 14", items[1].toString())
            assertEquals("Elixir of the Mongoose, -3, 0", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 7, 31", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 2, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -3, 0", items[7].toString())
            assertEquals("Conjured Mana Cake, -5, 0", items[8].toString())
        }
        if (dayNumber == 9) {
            assertEquals("+5 Dexterity Vest, 1, 11", items[0].toString())
            assertEquals("Aged Brie, -7, 16", items[1].toString())
            assertEquals("Elixir of the Mongoose, -4, 0", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 6, 33", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 1, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -4, 0", items[7].toString())
            assertEquals("Conjured Mana Cake, -6, 0", items[8].toString())
        }
        if (dayNumber == 10) {
            assertEquals("+5 Dexterity Vest, 0, 10", items[0].toString())
            assertEquals("Aged Brie, -8, 18", items[1].toString())
            assertEquals("Elixir of the Mongoose, -5, 0", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 5, 35", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 0, 50", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -5, 0", items[7].toString())
            assertEquals("Conjured Mana Cake, -7, 0", items[8].toString())
        }
        if (dayNumber == 11) {
            assertEquals("+5 Dexterity Vest, -1, 8", items[0].toString())
            assertEquals("Aged Brie, -9, 20", items[1].toString())
            assertEquals("Elixir of the Mongoose, -6, 0", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, 4, 38", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -6, 0", items[7].toString())
            assertEquals("Conjured Mana Cake, -8, 0", items[8].toString())
        }

        //TODO add assertions for missing days
        if (dayNumber == 30) {
            assertEquals("+5 Dexterity Vest, -20, 0", items[0].toString())
            assertEquals("Aged Brie, -28, 50", items[1].toString())
            assertEquals("Elixir of the Mongoose, -25, 0", items[2].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", items[3].toString())
            assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", items[4].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -15, 0", items[5].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -20, 0", items[6].toString())
            assertEquals("Backstage passes to a TAFKAL80ETC concert, -25, 0", items[7].toString())
            assertEquals("Conjured Mana Cake, -27, 0", items[8].toString())
        }
    }

}


