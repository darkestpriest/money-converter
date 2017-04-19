package org.darkestapp.money_exchange_rater.api.c_cex;

import org.darkestapp.money_exchange_rater.api.c_cex.exceptions.CCexApiException;
import org.darkestapp.money_exchange_rater.api.c_cex.processors.CCexObject;
import org.darkestapp.money_exchange_rater.api.c_cex.util.CCexCurrencyPair;
import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.junit.Test;

import static org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode.ARS;
import static org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode.BTC;
import static org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode.USD;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 18/04/17.
 */
public class CCexApiTest {

    private static final CCexCurrencyPair VALID_CURRENCY_PAIR =
            new CCexCurrencyPair(BTC, USD);
    private static final CCexCurrencyPair INVALID_CURRENCY_PAIR =
            new CCexCurrencyPair(ARS, USD);
    private static final CCexCurrencyPair REVERSE_VALID_CURRENCY_PAIR =
            new CCexCurrencyPair(USD, BTC);
    private static final CCexCurrencyPair REVERSE_INVALID_CURRENCY_PAIR =
            new CCexCurrencyPair(USD, ARS);

    private CCexApi cCexApi = new CCexApi();

    @Test
    public void getApiObjectTest() throws Exception {

        CCexObject result = cCexApi.getApiObject(VALID_CURRENCY_PAIR);
        assertNotNull(result);
        assertEquals(VALID_CURRENCY_PAIR, result.getCurrencyPair());
        assertThat(result.getBuyPrice().longValue(), greaterThan(0L));
        assertThat(result.getSellPrice().longValue(), greaterThan(0L));
        assertThat(result.getRequestTime().getTime(), greaterThan(0L));
    }

    @Test(expected = CCexApiException.class)
    public void getApiObjectNullCurrencyPairTest() throws Exception {
        cCexApi.getApiObject(null);
    }

    @Test(expected = CCexApiException.class)
    public void getApiObjectNotValidCurrencyPairTest() throws Exception {
        cCexApi.getApiObject(INVALID_CURRENCY_PAIR);
    }

    @Test
    public void isCurrencyPairAllowedTest() throws Exception {

        boolean result = cCexApi.isCurrencyPairAllowed(VALID_CURRENCY_PAIR);
        assertTrue(result);
    }

    @Test
    public void isCurrencyPairAllowedNotValidCurrencyPairTest() throws Exception {

        boolean result = cCexApi.isCurrencyPairAllowed(INVALID_CURRENCY_PAIR);
        assertFalse(result);
    }

    @Test
    public void isReverseCurrencyPairAllowedTest() throws Exception {

        boolean result = cCexApi.isCurrencyPairAllowed(REVERSE_VALID_CURRENCY_PAIR);
        assertTrue(result);
    }

    @Test
    public void isCurrencyPairAllowedReverseNotValidCurrencyPairTest() throws Exception {

        boolean result = cCexApi.isCurrencyPairAllowed(REVERSE_INVALID_CURRENCY_PAIR);
        assertFalse(result);
    }

    @Test(expected = ParseException.class)
    public void isCurrencyPairAllowedNullCurrencyPairTest() throws Exception {

        cCexApi.isCurrencyPairAllowed(null);
    }

}