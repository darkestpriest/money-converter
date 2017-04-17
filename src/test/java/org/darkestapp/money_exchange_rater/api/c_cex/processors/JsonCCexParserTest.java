package org.darkestapp.money_exchange_rater.api.c_cex.processors;

import org.darkestapp.money_exchange_rater.api.c_cex.util.CCexCurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.junit.Test;

import static org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode.ARS;
import static org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode.BTC;
import static org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode.USD;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 16/04/17.
 */
public class JsonCCexParserTest {

    private JsonCCexParser parser = new JsonCCexParser(JsonCCexParser.class);
    private CCexCurrencyPair validCurrencyPair = new CCexCurrencyPair(BTC, USD);

    @Test
    public void getDefaultApiObjectTest() throws Exception {

        CCexObject cCexObject = parser.getApiObject(validCurrencyPair);
        assertNotNull(cCexObject);
        assertEquals(validCurrencyPair, cCexObject.getCurrencyPair());
        assertThat(cCexObject.getBuyPrice().longValue(), greaterThan(0L));
        assertThat(cCexObject.getSellPrice().longValue(), greaterThan(0L));
        assertThat(cCexObject.getRequestTime().getTime(), greaterThan(0L));
    }

    @Test(expected = MoneyExchangeRaterException.class)
    public void getDefaultApiURLObjectInvalidCurrentPairTest() throws Exception {

        CCexCurrencyPair invalidCurrencyPair = new CCexCurrencyPair(ARS, USD);
        parser.getApiObject(invalidCurrencyPair);
    }

    @Test(expected = MoneyExchangeRaterException.class)
    public void getOtherValidApiURLObjectTest() throws Exception {

        parser.getApiObject(
                "https://c-cex.com/t/api_pub.html?a=getmarketsummaries",
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