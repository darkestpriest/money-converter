package org.darkestapp.money_exchange_rater.api.bittrex.util;

import org.darkestapp.money_exchange_rater.api.bittrex.enums.BittrexCurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;

import static org.darkestapp.money_exchange_rater.api.bittrex.util.BittrexConstants.MARKET_PRICES_SEPARATOR;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 22/04/17.
 */
public class BittrexCurrencyPair implements CurrencyPair<BittrexCurrencyCode> {

    private final BittrexCurrencyCode currencyFrom;
    private final BittrexCurrencyCode currencyTo;

    public BittrexCurrencyPair(
            BittrexCurrencyCode currencyFrom,
            BittrexCurrencyCode currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    @Override
    public BittrexCurrencyCode getCurrencyFrom() {
        return this.currencyFrom;
    }

    @Override
    public BittrexCurrencyCode getCurrencyTo() {
        return this.currencyTo;
    }

    @Override
    public String getCurrenciesCodes() {
        return currencyFrom.getLowerCaseCode()
                + MARKET_PRICES_SEPARATOR
                + currencyTo.getLowerCaseCode();
    }
}
