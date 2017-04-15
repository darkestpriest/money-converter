package org.darkestapp.money_exchange_rater.interfaces;

/**
 * This interface must be implemented for all the currency enum for each API.
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 14/04/17.
 */
public interface CurrencyData {

    /**
     * Returns a readable name for a given currency
     * @return
     */
    String getFriendlyName();

    String getCode();
}
