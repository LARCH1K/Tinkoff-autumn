package edu.hw3.Task6;

import java.util.Objects;

record Stock(String name, double price) implements Comparable<Stock> {

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Stock stock = (Stock) o;
        return Double.compare(price, stock.price) == 0 && Objects.equals(name, stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(Stock other) {
        return Double.compare(other.price, this.price);
    }
}
