package org.darkestapp.money_exchange_rater.api.bittrex.util;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 22/04/17.
 */
public class BittrexConstants {

    private BittrexConstants() {
        //Just to avoid public instantiations
    }

    public static final String MARKET_PRICES_BUY_PRICES_KEY = "High";
    public static final String MARKET_PRICES_SELL_PRICES_KEY = "Low";
    public static final String MARKET_PRICES_RESULT_KEY = "result";
    public static final String MARKET_PRICES_SEPARATOR = "-";
    public static final String MARKET_PRICES_SUCCES_KEY = "success";
    public static final String MARKET_PRICES_TIMESTAMP_KEY = "TimeStamp";
    public static final String MARKET_PRICES_URL = "https://bittrex.com/api/v1.1/public/getmarketsummary?market=";
    public static final String TIMESTAMP_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
}
