package org.darkestapp.money_exchange_rater.api.money_converter;

import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.ExchangeRaterApi;

import java.math.BigDecimal;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class MoneyConverterExchangeRater implements ExchangeRaterApi {
    @Override
    public boolean isCurrencyPairAllowed(CurrencyPair currencyPair) {
        return false;
    }

    @Override
    public BigDecimal getExchangedCurrency(CurrencyPair currencyPair, BigDecimal quantityToExchange) {
        return null;
    }
}
