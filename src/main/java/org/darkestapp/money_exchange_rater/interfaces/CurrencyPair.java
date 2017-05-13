package org.darkestapp.money_exchange_rater.interfaces;

import org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public interface CurrencyPair {

    PublicCurrencyCode getCurrencyFrom();

    PublicCurrencyCode getCurrencyTo();

    String getCurrenciesCodes();
}
