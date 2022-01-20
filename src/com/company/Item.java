package com.company;

import java.util.Objects;

public class Item {
    private final String item;
    private final int index;

    public Item(String item, int index) {
        this.item = item;
        this.index = index;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                ", index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item1 = (Item) o;
        return index == item1.index && Objects.equals(item, item1.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, index);
    }
}
