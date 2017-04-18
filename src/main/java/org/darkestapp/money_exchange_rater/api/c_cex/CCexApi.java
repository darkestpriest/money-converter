package org.darkestapp.money_exchange_rater.api.c_cex;

import org.darkestapp.money_exchange_rater.interfaces.Api;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.ExchangeRaterApi;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;

import java.math.BigDecimal;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/04/17.
 */
@Api(enabled = true)
public class CCexApi implements ExchangeRaterApi{
    @Override
    public boolean isCurrencyPairAllowed(CurrencyPair currencyPair) throws MoneyExchangeRaterException {
        //Not implemented yet
        return false;
    }

    @Override
    public BigDecimal getExchangedCurrency(CurrencyPair currencyPair, BigDecimal quantityToExchange) {
        //Not implemented yet
        return null;
    }
}
