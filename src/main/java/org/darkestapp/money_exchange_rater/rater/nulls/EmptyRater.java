package org.darkestapp.money_exchange_rater.rater.nulls;

import org.darkestapp.money_exchange_rater.interfaces.ApiObject;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.Rater;
import org.darkestapp.money_exchange_rater.interfaces.Step;
import org.darkestapp.money_exchange_rater.rater.nulls.NullApiObject;
import org.darkestapp.money_exchange_rater.rater.nulls.NullCurrencyPair;

import java.util.Collections;
import java.util.List;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/06/17.
 */
public class EmptyRater implements Rater {

    @Override
    public ApiObject getApiObject() {
        return new NullApiObject();
    }

    @Override
    public CurrencyPair getCurrencyPair() {
        return new NullCurrencyPair();
    }

    @Override
    public List<Step> getPath() {
        return Collections.emptyList();
    }
}
