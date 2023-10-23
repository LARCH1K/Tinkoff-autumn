package edu.hw3.Task6;

import java.util.PriorityQueue;

class StockMarketImpl implements StockMarket {
    private final PriorityQueue<Stock> stockQueue;

    StockMarketImpl() {
        stockQueue = new PriorityQueue<>();
    }

    @Override
    public void add(Stock stock) {
        stockQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockQueue.peek();
    }
//    public static void main(String[] args) {
//        StockMarket stockMarket = new StockMarketImpl();
//
//        // Добавляем несколько акций
//        stockMarket.add(new Stock("AAPL", 150.0));
//        stockMarket.add(new Stock("GOOGL", 2000.0));
//        stockMarket.add(new Stock("MSFT", 300.0));
//
//        // Выводим самую дорогую акцию
//        Stock mostValuable = stockMarket.mostValuableStock();
//        System.out.println("Most valuable stock: " + mostValuable.name() + " - $" + mostValuable.price());
//
//        stockMarket.remove(new Stock("GOOGL", 2000.0));
//
//        mostValuable = stockMarket.mostValuableStock();
//        System.out.println("Most valuable stock: " + mostValuable.name() + " - $" + mostValuable.price());
//    }
}
