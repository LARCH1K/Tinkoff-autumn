package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import edu.hw3.Task6.StockMarketImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task6Test {

    @Test
    void mostValuableStockTest() {
        StockMarket stockMarket = new StockMarketImpl();
        stockMarket.add(new Stock("Apple", 150.0));
        stockMarket.add(new Stock("Google", 2000.0));
        stockMarket.add(new Stock("Microsoft", 300.0));

        Stock mostValuable = stockMarket.mostValuableStock();
        assertEquals(new Stock("Google", 2000.0), mostValuable);
    }

    @Test
    void addTest() {
        StockMarket stockMarket = new StockMarketImpl();
        stockMarket.add(new Stock("Apple", 150.0));

        Stock mostValuable = stockMarket.mostValuableStock();
        assertEquals(new Stock("Apple", 150.0), mostValuable);
    }

    @Test
    void removeTest() {
        StockMarket stockMarket = new StockMarketImpl();
        stockMarket.add(new Stock("Google", 2000.0));

        stockMarket.remove(new Stock("Google", 2000.0));

        Stock mostValuable = stockMarket.mostValuableStock();
        assertNull(mostValuable);
    }

}
