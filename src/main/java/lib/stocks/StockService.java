package lib.stocks;

import objects.MyStock;
import yahoofinance.Stock;

public interface StockService {
    String BSE_SCRIPT_POST_SCRIPT = ".BO";
    String NSE_SCRIPT_POST_SCRIPT = ".NS";

    MyStock getStock(String shareScriptName);
    MyStock[] getAllStock(String shareScriptName);
}
