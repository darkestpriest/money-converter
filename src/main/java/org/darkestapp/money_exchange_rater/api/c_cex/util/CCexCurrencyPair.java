package org.darkestapp.money_exchange_rater.api.c_cex.util;

import org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class CCexCurrencyPair implements CurrencyPair<CCexCurrencyCode> {

    private final CCexCurrencyCode currencyFrom;
    private final CCexCurrencyCode currencyTo;

    public CCexCurrencyPair(
            CCexCurrencyCode currencyFrom,
            CCexCurrencyCode currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    @Override
    public CCexCurrencyCode getCurrencyFrom() {
        return this.currencyFrom;
    }

    @Override
    public CCexCurrencyCode getCurrencyTo() {
        return this.currencyTo;
    }

    @Override
    public String toString() {
        return "CCexCurrencyCode{" +
                "currencyFrom=" + currencyFrom +
                ", currencyTo=" + currencyTo +
                '}';
    }

}
