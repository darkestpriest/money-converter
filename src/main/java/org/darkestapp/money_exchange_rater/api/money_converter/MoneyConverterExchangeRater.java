package org.darkestapp.money_exchange_rater.api.money_converter;

import org.darkestapp.money_exchange_rater.api.money_converter.enums.MoneyExchangeCurrencyData;
import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.darkestapp.money_exchange_rater.api.money_converter.util.MoneyConverterCurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.ExchangeRaterApi;

import java.math.BigDecimal;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class MoneyConverterExchangeRater implements ExchangeRaterApi<MoneyConverterCurrencyPair> {

    private static final String CONTEXT = MoneyConverterExchangeRater.class.getSimpleName();

    @Override
    public boolean isCurrencyPairAllowed(MoneyConverterCurrencyPair currencyPair) throws ParseException {

        try {

            MoneyExchangeCurrencyData.valueOf(currencyPair.getCurrencyFrom().getCode());
            MoneyExchangeCurrencyData.valueOf(currencyPair.getCurrencyTo().getCode());
        } catch (IllegalArgumentException e) {
            return false;
        } catch (Exception e) {
            throw new ParseException(
                    e,
                    CONTEXT,
                    "There is an error checking if the currency pair is allowed " + currencyPair);
        }

        return true;
    }

    @Override
    public BigDecimal getExchangedCurrency(MoneyConverterCurrencyPair currencyPair, BigDecimal quantityToExchange) {
        return null;
    }

    private String requestExternalApi(CurrencyPair currencyPair) {
        return "";
    }
}
