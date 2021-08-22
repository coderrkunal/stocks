package lib.stocks;

import lib.stocks.fetcher.FinanceAPI;
import lib.stocks.fetcher.YahooFinanceImpl;
import objects.MyStock;
import yahoofinance.Stock;

public class BSEStockService implements StockService{
    FinanceAPI financeAPI;

    public BSEStockService() {
        //Default Yahoo Finance API
        financeAPI = new YahooFinanceImpl(BSE_SCRIPT_POST_SCRIPT);
    }

    public BSEStockService(FinanceAPI financeAPI) {
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
