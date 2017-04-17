package org.darkestapp.money_exchange_rater.api.c_cex.util;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class CCexConstants {

    private CCexConstants() {
        //Just to avoid public instantiation
    }

    public static final String MARKET_PRICES_BUY_PRICES_KEY = "buy";
    public static final String MARKET_PRICES_SELL_PRICES_KEY = "sell";
    public static final String MARKET_PRICES_SEPARATOR = "-";
    public static final String MARKET_PRICES_TIMESTAMP_KEY = "updated";
    public static final Long MARKET_PRICES_TIMESTAMP_MULTIPLIER = 1000L;
    public static final String MARKET_PRICES_URL = "https://c-cex.com/t/prices.json";


}
