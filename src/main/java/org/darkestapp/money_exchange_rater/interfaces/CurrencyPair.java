package org.darkestapp.money_exchange_rater.interfaces;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public interface CurrencyPair<C extends CurrencyCode> {

    C getCurrencyFrom();

    C getCurrencyTo();
}
