package org.darkestapp.money_exchange_rater.api.money_converter;

import org.darkestapp.money_exchange_rater.api.money_converter.enums.MoneyExchangeCurrencyData;
import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.darkestapp.money_exchange_rater.api.money_converter.util.MoneyConverterCurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.enums.PublicCurrencyCode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class MoneyConverterExchangeRaterTest {

    MoneyConverterExchangeRater exchangeRater = new MoneyConverterExchangeRater();

    @Test
    public void isCurrencyPairAllowed() throws Exception {
        MoneyConverterCurrencyPair currencyPair =
                new MoneyConverterCurrencyPair(
                        MoneyExchangeCurrencyData.ARS,
                        MoneyExchangeCurrencyData.USD);
        boolean result = exchangeRater.isCurrencyPairAllowed(currencyPair);
        assertTrue(result);
    }

    @Test(expected = ParseException.class)
    public void isCurrencyPairAllowedWithNullCurrency() throws Exception {

        MoneyConverterCurrencyPair currencyPair =
                new MoneyConverterCurrencyPair(
                        null,
                        MoneyExchangeCurrencyData.USD);
        exchangeRater.isCurrencyPairAllowed(currencyPair);
    }

    @Test(expected = ParseException.class)
    public void isCurrencyPairAllowedWithSecondNullCurrency() throws Exception {

        MoneyConverterCurrencyPair currencyPair =
                new MoneyConverterCurrencyPair(
                        MoneyExchangeCurrencyData.USD,
                        null);
        exchangeRater.isCurrencyPairAllowed(currencyPair);
    }

    @Test
    public void getExchangedCurrency() throws Exception {
    }

}