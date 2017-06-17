package org.darkestapp.money_exchange_rater.rater.nulls;

import org.darkestapp.money_exchange_rater.interfaces.ApiObject;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;

import java.math.BigDecimal;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/06/17.
 */
public class NullApiObject implements ApiObject {
    @Override
    public CurrencyPair getCurrencyPair() {
        return new NullCurrencyPair();
    }

    @Override
    public BigDecimal getBuyPrice() {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getSellPrice() {
        return BigDecimal.ZERO;
    }
}
