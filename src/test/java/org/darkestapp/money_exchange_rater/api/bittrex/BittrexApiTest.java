package org.darkestapp.money_exchange_rater.api.bittrex;

import org.darkestapp.money_exchange_rater.api.bittrex.processors.BittrexObject;
import org.darkestapp.money_exchange_rater.api.bittrex.util.BittrexCurrencyPair;
import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.junit.Test;

import static org.darkestapp.money_exchange_rater.api.bittrex.enums.BittrexCurrencyCode.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 28/04/17.
 */
public class BittrexApiTest {

    private static final BittrexCurrencyPair VALID_CURRENCY_PAIR =
            new BittrexCurrencyPair(USDT, BTC);
    private static final BittrexCurrencyPair INVALID_CURRENCY_PAIR =
            new BittrexCurrencyPair(ARS, USDT);
    private static final BittrexCurrencyPair REVERSE_VALID_CURRENCY_PAIR =
            new BittrexCurrencyPair(BTC, USDT);
    private static final BittrexCurrencyPair REVERSE_INVALID_CURRENCY_PAIR =
            new BittrexCurrencyPair(USDT, ARS);

    private BittrexApi bittrexApi = new BittrexApi();

    @Test
    public void getApiObjectTest() throws Exception {

        BittrexObject result = bittrexApi.getApiObject(VALID_CURRENCY_PAIR);
        assertNotNull(result);
        assertEquals(VALID_CURRENCY_PAIR, result.getCurrencyPair());
        assertThat(result.getBuyPrice().longValue(), greaterThan(0L));
        assertThat(result.getSellPrice().longValue(), greaterThan(0L));
        assertThat(result.getRequestTime().getTime(), greaterThan(0L));
    }

    @Test(expected = MoneyExchangeRaterException.class)
    public void getApiObjectNullCurrencyPairTest() throws Exception {
        bittrexApi.getApiObject(null);
    }

    @Test(expected = MoneyExchangeRaterException.class)
    public void getApiObjectNotValidCurrencyPairTest() throws Exception {
        bittrexApi.getApiObject(INVALID_CURRENCY_PAIR);
    }

    @Test
    public void isCurrencyPairAllowedTest() throws Exception {

        boolean result = bittrexApi.isCurrencyPairAllowed(VALID_CURRENCY_PAIR);
        assertTrue(result);
    }

    @Test
    public void isCurrencyPairAllowedNotValidCurrencyPairTest() throws Exception {

        boolean result = bittrexApi.isCurrencyPairAllowed(INVALID_CURRENCY_PAIR);
        assertFalse(result);
    }

    @Test
    public void isReverseCurrencyPairAllowedTest() throws Exception {

        boolean result = bittrexApi.isCurrencyPairAllowed(REVERSE_VALID_CURRENCY_PAIR);
        assertTrue(result);
    }

    @Test
    public void isCurrencyPairAllowedReverseNotValidCurrencyPairTest() throws Exception {

        boolean result = bittrexApi.isCurrencyPairAllowed(REVERSE_INVALID_CURRENCY_PAIR);
        assertFalse(result);
    }

    @Test(expected = ParseException.class)
    public void isCurrencyPairAllowedNullCurrencyPairTest() throws Exception {

        bittrexApi.isCurrencyPairAllowed(null);
    }

}