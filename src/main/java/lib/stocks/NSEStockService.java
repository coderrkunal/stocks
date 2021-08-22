package lib.stocks;

import lib.stocks.fetcher.FinanceAPI;
import lib.stocks.fetcher.YahooFinanceImpl;
import objects.MyStock;
import yahoofinance.Stock;

public class NSEStockService implements StockService{
    FinanceAPI financeAPI;

    public NSEStockService() {
        //Default Yahoo Finance API
        financeAPI = new YahooFinanceImpl(NSE_SCRIPT_POST_SCRIPT);
    }

    public NSEStockService(FinanceAPI financeAPI) {
        this.financeAPI = financeAPI;
    }

    @Override
    public MyStock getStock(String shareScriptName) {
        return financeAPI.getStock(shareScriptName);
    }

    @Override
    public MyStock[] getAllStock(String shareScriptName) {
        return new MyStock[0];
    }
}
