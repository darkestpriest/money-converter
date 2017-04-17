package org.darkestapp.money_exchange_rater.interfaces;

import java.math.BigDecimal;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 16/04/17.
 */
public interface ApiObject {

    CurrencyPair getCurrencyPair();

    BigDecimal getBuyPrice();

    BigDecimal getSellPrice();
}
