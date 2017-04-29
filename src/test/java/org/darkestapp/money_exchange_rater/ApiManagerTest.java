package org.darkestapp.money_exchange_rater;

import org.darkestapp.money_exchange_rater.api.c_cex.util.CCexCurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.ApiObject;
import org.darkestapp.money_exchange_rater.interfaces.ExchangeRaterApi;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 20/04/17.
 */
public class ApiManagerTest {

    private static final CCexCurrencyPair VALID_CURRENCY_PAIR =
            new CCexCurrencyPair(BTC, USD);
    private static final CCexCurrencyPair INVALID_CURRENCY_PAIR =
            new CCexCurrencyPair(ARS, USD);
    ApiManager apiManager;

    @Before
    public void setUp() throws Exception {

        this.apiManager = new ApiManager();
    }

    @Test
    public void getAvailableApiMapTest() throws Exception {

        Map<String, ExchangeRaterApi> apiMap = apiManager.getAvailableApiMap();
        assertNotNull(apiMap);
        assertThat(apiMap.size(), greaterThan(0));
    }

    @Test(expected = Exception.class)
    public void useAnAvailableApiTest() throws Exception {

        Map<String, ExchangeRaterApi> apiMap = apiManager.getAvailableApiMap();
        apiMap.forEach((apiCode, api) -> {
            try {
                ApiObject result= api.getApiObject(VALID_CURRENCY_PAIR);
                assertNotNull(result);
                assertEquals(VALID_CURRENCY_PAIR, result.getCurrencyPair());
                assertThat(result.getBuyPrice().longValue(), greaterThan(0L));
                assertThat(result.getSellPrice().longValue(), greaterThan(0L));

            } catch (MoneyExchangeRaterException e) {
                e.printStackTrace();
            }
        });
    }

    @Test(expected = Exception.class)
    public void checkInvalidCurrencyPairTest() throws Exception {

        Map<String, ExchangeRaterApi> apiMap = apiManager.getAvailableApiMap();
        apiMap.forEach((apiCode, api) -> {
            try {
                api.getApiObject(INVALID_CURRENCY_PAIR);
            } catch (MoneyExchangeRaterException e) {
                e.printStackTrace();
            }
        });
    }

}