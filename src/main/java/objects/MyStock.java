package objects;

import lombok.NoArgsConstructor;
import yahoofinance.Stock;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes2.HistoricalDividend;
import yahoofinance.histquotes2.HistoricalSplit;
import yahoofinance.quotes.stock.StockDividend;
import yahoofinance.quotes.stock.StockQuote;
import yahoofinance.quotes.stock.StockStats;

import java.io.IOException;
import java.util.List;

@NoArgsConstructor
public class MyStock{
    Stock stock;

    public Stock getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public StockQuote getQuote() {
        return quote;
    }

    public StockStats getStats() {
        return stats;
    }

    public StockDividend getDividend() {
        return dividend;
    }

    public List<HistoricalQuote> getHistory() {
        return history;
    }

    public List<HistoricalDividend> getDividendHistory() {
        return dividendHistory;
    }

    public List<HistoricalSplit> getSplitHistory() {
        return splitHistory;
    }

    private String name;
    private String currency;
    private String stockExchange;
    private StockQuote quote;
    private StockStats stats;
    private StockDividend dividend;
    private List<HistoricalQuote> history;
    private List<HistoricalDividend> dividendHistory;
    private List<HistoricalSplit> splitHistory;

    public MyStock(Stock stock) {
        this.stock = stock;
        this.name = stock.getName();
        this.currency = stock.getCurrency();
        this.stockExchange = stock.getStockExchange();
        this.quote = stock.getQuote();
        this.stats = stock.getStats();
        this.dividend = stock.getDividend();
        try {
            this.history = stock.getHistory();
            this.dividendHistory = stock.getDividendHistory();
            this.splitHistory = stock.getSplitHistory();
        }catch (IOException ioException){

        }
    }
}
