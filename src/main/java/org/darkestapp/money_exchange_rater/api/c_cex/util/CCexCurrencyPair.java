package org.darkestapp.money_exchange_rater.api.c_cex.util;

import org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode;
import org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;

import java.util.Objects;

import static org.darkestapp.money_exchange_rater.api.c_cex.util.CCexConstants.MARKET_PRICES_SEPARATOR;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class CCexCurrencyPair implements CurrencyPair {

    private final PublicCurrencyCode currencyFrom;
    private final PublicCurrencyCode currencyTo;

    public CCexCurrencyPair(
            PublicCurrencyCode currencyFrom,
            PublicCurrencyCode currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    public CCexCurrencyPair(
            CurrencyPair currencyPair) {
        this.currencyFrom = currencyPair.getCurrencyFrom();
        this.currencyTo = currencyPair.getCurrencyTo();
    }


    @Override
    public PublicCurrencyCode getCurrencyFrom() {
        return this.currencyFrom;
    }

    @Override
    public PublicCurrencyCode getCurrencyTo() {
        return this.currencyTo;
    }

    public String getCurrenciesCodes() {

        return currencyFrom.getLowerCaseCode() +
                MARKET_PRICES_SEPARATOR +
                currencyTo.getLowerCaseCode();
    }

    @Override
    public String toString() {
        return "CCexCurrencyCode{" +
                "currencyFrom=" + currencyFrom +
                ", currencyTo=" + currencyTo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CCexCurrencyPair that = (CCexCurrencyPair) o;
        return currencyFrom == that.currencyFrom &&
                currencyTo == that.currencyTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyFrom, currencyTo);
    }
}
