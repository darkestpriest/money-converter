package org.darkestapp.money_exchange_rater.interfaces;

import org.darkestapp.money_exchange_rater.api.c_cex.exceptions.CCexApiException;

import java.math.BigDecimal;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public interface ExchangeRaterApi <C extends CurrencyPair, O extends ApiObject> {

    /**
     * Returns true if the currency pair is allowed by the API
     *
     * @param currencyPair currency pair to exchange.
     * @return
     */
    boolean isCurrencyPairAllowed(final C currencyPair) throws MoneyExchangeRaterException;

    /**
     * Returns the ApiObject, according the currency pair.
     *
     * @See {@link ApiObject}
     *
     * @param currencyPair
     * @return
     */
    O getApiObject(final C currencyPair) throws MoneyExchangeRaterException;
}
