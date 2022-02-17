import java.util.ArrayDeque;

// 프로그래머스 : 코딩테스트연습 > 스택/큐 > 주식가격
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/42584

class Stock {
    public int[] solution(int[] prices) {
        ArrayDeque<StockPrice> stockPrices = new ArrayDeque<>();
        int[] resultArray = new int[prices.length];
        for (int i = 0; i < prices.length; i++){
            StockPrice newStockPrice = new StockPrice(i, prices[i]);
            while (!stockPrices.isEmpty() && stockPrices.peek().getPrice() > newStockPrice.getPrice()) {
                StockPrice prevStockPrice = stockPrices.pop();
                resultArray[prevStockPrice.getTime()] = newStockPrice.getTime() - prevStockPrice.getTime();
            }
            stockPrices.push(newStockPrice);
        }
        int lastTime = prices.length-1;
        for (StockPrice stockPrice : stockPrices) {
            resultArray[stockPrice.getTime()] =  lastTime - stockPrice.getTime();
        }
        return resultArray;
    }
}

class StockPrice {
    private final int TIME;
    private final int PRICE;

    StockPrice(int time, int price) {
        this.TIME = time;
        this.PRICE = price;
    }

    public int getTime() {return this.TIME;}
    public int getPrice() {return this.PRICE;}
}