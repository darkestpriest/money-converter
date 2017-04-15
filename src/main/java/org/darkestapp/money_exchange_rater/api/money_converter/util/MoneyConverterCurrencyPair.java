package org.darkestapp.money_exchange_rater.api.money_converter.util;

import org.darkestapp.money_exchange_rater.api.money_converter.enums.MoneyExchangeCurrencyData;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.enums.PublicCurrencyCode;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class MoneyConverterCurrencyPair implements CurrencyPair<MoneyExchangeCurrencyData> {

    private final MoneyExchangeCurrencyData currencyFrom;
    private final MoneyExchangeCurrencyData currencyTo;

    public MoneyConverterCurrencyPair(
            MoneyExchangeCurrencyData currencyFrom,
            MoneyExchangeCurrencyData currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    @Override
    public MoneyExchangeCurrencyData getCurrencyFrom() {
        return this.currencyFrom;
    }

    @Override
    public MoneyExchangeCurrencyData getCurrencyTo() {
        return this.currencyTo;
    }

    @Override
    public String toString() {
        return "MoneyConverterCurrencyPair{" +
                "currencyFrom=" + currencyFrom +
                ", currencyTo=" + currencyTo +
                '}';
    }
}
