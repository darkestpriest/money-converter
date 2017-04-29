package org.darkestapp.money_exchange_rater.interfaces;

import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.darkestapp.money_exchange_rater.util.CurrencyCodeScanner;

import java.util.List;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 28/04/17.
 */
public abstract class AbstractExchangeRaterApi
        <C extends CurrencyPair,
                O extends ApiObject>
        implements ExchangeRaterApi<C, O> {

    private final String context;
    private final Class currencyCode;

    public AbstractExchangeRaterApi(final Class context, final Class currencyCode) {
        this.context = context.getSimpleName();
        this.currencyCode = currencyCode;
    }

    @Override
    public boolean isCurrencyPairAllowed(final C currencyPair)
            throws MoneyExchangeRaterException {

        if(currencyPair == null) {
            throw new ParseException(context, "Currency pair cannot be null");
        }

        List<String> supportedCodeList = CurrencyCodeScanner
                .getSupportedCurrencyCodeList(
                        currencyCode,
                        this.getClass());
        if(!supportedCodeList.contains(currencyPair.getCurrencyFrom().getCode())) {
            return false;
        }
        if(!supportedCodeList.contains(currencyPair.getCurrencyTo().getCode())) {
            return false;
        }
        return true;
    }

}
