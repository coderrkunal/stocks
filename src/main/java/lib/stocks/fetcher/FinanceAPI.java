package lib.stocks.fetcher;

import objects.MyStock;

abstract public class FinanceAPI {
    abstract public MyStock getStock(String scriptName);
    abstract public MyStock[] getAllStocks();
}
