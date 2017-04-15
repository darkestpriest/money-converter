package org.darkestapp.money_exchange_rater.interfaces;

import java.math.BigDecimal;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public interface ExchangeRaterApi {

    /**
     * Returns true if the currency pair is allowed by the API
     * @param currencyPair currency pair to exchange.
     * @return
     */
    boolean isCurrencyPairAllowed(CurrencyPair currencyPair);

    /**
     * Returns the quantity calculated, according the currency pair.
     * @param currencyPair
     * @param quantityToExchange
     * @return
     */
    BigDecimal getExchangedCurrency(CurrencyPair currencyPair, BigDecimal quantityToExchange);
}
