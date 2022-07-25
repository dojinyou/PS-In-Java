package programmers.programmers.highscorekit.stackqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class StockPrice {
  public int[] solution(int[] prices) {
    StockManager stockManager = new StockManager();
    return stockManager.work(prices);
  }

  private class Stock {
    private final int price;
    private final int purchaseTime;
    private int fallTime;

    private final int maxTime;

    private Stock(int price, int purchaseTime, int maxTime) {
      this.price = price;
      this.purchaseTime = purchaseTime;
      this.fallTime = maxTime;
      this.maxTime = maxTime;
    }

    public void setFallTime(int fallTime) {
      this.fallTime = fallTime;
    }

    public int getGtOrEqTime() {
      return fallTime - purchaseTime;
    }

    public int getPrice() {
      return price;
    }

    public boolean isFall() {
      return fallTime != maxTime;
    }

    public int getPurchaseTime() {
      return purchaseTime;
    }
  }

  private class StockManager {
    private final Deque<Stock> stockList = new LinkedList<>();
    private final Deque<Stock> fallStockList = new LinkedList<>();

    public void buy(int currentPrice, int purchaseTime, int maxTime) {
      stockList.add(new Stock(currentPrice, purchaseTime, maxTime));
    }

    public void notifyPrice(int currentPrice, int currentTime) {
      int numOfCurrentStocks = stockList.size();
      for (int i = 0; i < numOfCurrentStocks; i++) {
        Stock stock = stockList.poll();
        if (currentPrice < stock.getPrice() && !stock.isFall()) {
          stock.setFallTime(currentTime);
          fallStockList.add(stock);
        } else {
          stockList.add(stock);
        }
      }
    }

    public int[] work(int[] prices) {
      int maxTime = prices.length - 1;
      for (int time = 0; time <= maxTime; time++) {
        int currentPrice = prices[time];
        buy(currentPrice, time, maxTime);
        notifyPrice(currentPrice, time);
      }

      int[] result = new int[prices.length];
      for (Stock stock: stockList) {
        result[stock.getPurchaseTime()] = stock.getGtOrEqTime();
      }
      for (Stock stock: fallStockList) {
        result[stock.getPurchaseTime()] = stock.getGtOrEqTime();
      }

      return result;
    }
  }
}
