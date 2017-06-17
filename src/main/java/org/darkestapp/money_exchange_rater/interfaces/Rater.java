package org.darkestapp.money_exchange_rater.interfaces;

import java.util.List;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/06/17.
 */
public interface Rater {

    ApiObject getApiObject();

    CurrencyPair getCurrencyPair();

    List<Step> getPath();
}
