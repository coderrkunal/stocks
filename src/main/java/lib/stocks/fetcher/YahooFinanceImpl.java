package lib.stocks.fetcher;

import objects.MyStock;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

public class YahooFinanceImpl extends FinanceAPI{
    private String postScript = null;

    public YahooFinanceImpl(String postScript) {
        this.postScript = postScript;
    }

    @Override
    public MyStock getStock(String scriptName) {
        MyStock bseStock = null;
        try {
            Stock stock = YahooFinance.get(scriptName + postScript);
            bseStock = new MyStock(stock);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bseStock;
    }

    @Override
    public MyStock[] getAllStocks() {
        return new MyStock[0];
    }
}
