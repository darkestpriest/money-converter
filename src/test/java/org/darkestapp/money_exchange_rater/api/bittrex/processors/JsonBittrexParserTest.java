package org.darkestapp.money_exchange_rater.api.bittrex.processors;

import org.darkestapp.money_exchange_rater.api.bittrex.util.BittrexCurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.junit.Test;

import static org.darkestapp.money_exchange_rater.api.bittrex.enums.BittrexCurrencyCode.BTC;
import static org.darkestapp.money_exchange_rater.api.bittrex.enums.BittrexCurrencyCode.USDT;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 22/04/17.
 */
public class JsonBittrexParserTest {

    private JsonBittrexParser parser = new JsonBittrexParser(JsonBittrexParser.class);
    private BittrexCurrencyPair validCurrencyPair = new BittrexCurrencyPair(USDT, BTC);

    @Test
    public void getDefaultApiObject() throws Exception {

        BittrexObject bittrexObject = parser.getApiObject(validCurrencyPair);
        System.out.println(bittrexObject);
        assertNotNull(bittrexObject);
        assertEquals(validCurrencyPair, bittrexObject.getCurrencyPair());
        assertThat(bittrexObject.getBuyPrice().longValue(), greaterThan(0L));
        assertThat(bittrexObject.getSellPrice().longValue(), greaterThan(0L));
        assertThat(bittrexObject.getRequestTime().getTime(), greaterThan(0L));
    }

    @Test(expected = MoneyExchangeRaterException.class)
    public void getApiObject() throws Exception {

        BittrexCurrencyPair invalidCurrencyPair = new BittrexCurrencyPair(BTC, USDT);
        parser.getApiObject(invalidCurrencyPair);
    }

    @Test(expected = MoneyExchangeRaterException.class)
    public void getOtherValidApiURLObjectTest() throws Exception {

        parser.getApiObject(
                "https://bittrex.com/t/api_pub.html?a=getmarketsummaries",
                validCurrencyPair);
    }

    @Test(expected = MoneyExchangeRaterException.class)
    public void getApiObjectMalformedURLTest() throws Exception {

        parser.getApiObject("Malformed URL", validCurrencyPair);
    }

    @Test(expected = MoneyExchangeRaterException.class)
    public void getApiObjectNullURLTest() throws Exception {

        parser.getApiObject(null, validCurrencyPair);
    }

}