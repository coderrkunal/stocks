import com.fasterxml.jackson.databind.ObjectMapper;
import lib.stocks.BSEStockService;
import lib.stocks.NSEStockService;
import objects.BSEStockScript;
import objects.MyStock;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import lib.rest.RestApacheImpl;

import java.math.BigDecimal;

public class GetStockTests {

    @Test
    public void testGetBSEOneStock(){
        try {
            BSEStockService bseStockService = new BSEStockService();
            MyStock stock = bseStockService.getStock("BHARTIARTL");

            Assert.assertNotNull(stock);

            BigDecimal price = stock.getQuote().getPrice();
            BigDecimal change = stock.getQuote().getChangeInPercent();
            BigDecimal peg = stock.getStats().getPeg();
            BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

            System.out.println("price: " + price);
        }catch (Exception ex){
            ex.printStackTrace();
            Assert.fail("Exception during execution" + ex.getMessage());
        }
    }

    @Test
    public void testGetNSEOneStock(){
        try {
            NSEStockService nseStockService = new NSEStockService();
            MyStock stock = nseStockService.getStock("BHARTIARTL");

            Assert.assertNotNull(stock);

            BigDecimal price = stock.getQuote().getPrice();
            BigDecimal change = stock.getQuote().getChangeInPercent();
            BigDecimal peg = stock.getStats().getPeg();
            BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

            System.out.println("price: " + price);
        }catch (Exception ex){
            ex.printStackTrace();
            Assert.fail("Exception during execution" + ex.getMessage());
        }
    }

    @Test
    @Ignore
    public void testGetAllStocks(){
        try {
            RestApacheImpl restGetCall = new RestApacheImpl();
            restGetCall.setHost("https://api.bseindia.com/");
            restGetCall.setPath("BseIndiaAPI/api/ListofScripData/w?segment%3DEquity%26status%3DActive");

            String resp = restGetCall.doGet();
            Assert.assertNotNull(resp);
            Assert.assertNotEquals(0, resp.length());

            ObjectMapper mapper = new ObjectMapper();
            BSEStockScript[] stocks = mapper.readValue(resp, BSEStockScript[].class);

            Assert.assertNotNull(stocks);
            Assert.assertNotEquals(0, stocks.length);


        }catch (Exception ex){
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }
}
