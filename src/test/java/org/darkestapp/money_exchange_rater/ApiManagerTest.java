package org.darkestapp.money_exchange_rater;

import org.darkestapp.money_exchange_rater.interfaces.*;
import org.darkestapp.money_exchange_rater.util.CurrencyPairBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode.ARS;
import static org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode.BTC;
import static org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode.USD;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 20/04/17.
 */
public class ApiManagerTest {

    private static final CurrencyPair VALID_CURRENCY_PAIR =
            CurrencyPairBuilder.build(BTC,  USD);
    private static final CurrencyPair INVALID_CURRENCY_PAIR =
            CurrencyPairBuilder.build(ARS, USD);
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