package org.darkestapp.money_exchange_rater.rater.nulls;

import org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/06/17.
 */
public class NullCurrencyPair implements CurrencyPair {

    @Override
    public PublicCurrencyCode getCurrencyFrom() {
        return PublicCurrencyCode.NO;
    }

    @Override
    public PublicCurrencyCode getCurrencyTo() {
        return PublicCurrencyCode.NO;
    }

    @Override
    public String getCurrenciesCodes() {
        return "No values";
    }
}
