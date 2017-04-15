package org.darkestapp.money_exchange_rater.api.money_converter.util;

import org.darkestapp.money_exchange_rater.api.money_converter.enums.MoneyExchangeCurrencyData;
import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class MoneyExchangeRaterConstantsTest {
    @Test
    public void getMoneyConverterURL() throws Exception {

        String expected =
                "https://themoneyconverter.com/ES/CurrencyConverter.aspx?tab=0&amp;bg=ffffff&amp;from=USD&amp;to=ARS";

        MoneyConverterCurrencyPair moneyConverterCurrencyPair =
                new MoneyConverterCurrencyPair(
                        MoneyExchangeCurrencyData.USD,
                        MoneyExchangeCurrencyData.ARS);
        String result = MoneyExchangeRaterConstants.getMoneyConverterURL(moneyConverterCurrencyPair);
        assertEquals(expected, result);
    }

    @Test(expected = ParseException.class)
    public void getMoneyConverterURLNullCurrencyPair() throws Exception {

        MoneyExchangeRaterConstants.getMoneyConverterURL(null);
    }

    @Test(expected = ParseException.class)
    public void getMoneyConverterURLNullArgumentInCurrencyPair() throws Exception {

        MoneyConverterCurrencyPair moneyConverterCurrencyPair =
                new MoneyConverterCurrencyPair(
                        null,
                        MoneyExchangeCurrencyData.ARS);
        MoneyExchangeRaterConstants.getMoneyConverterURL(moneyConverterCurrencyPair);

    }

    @Test(expected = ParseException.class)
    public void getMoneyConverterURLSecondNullArgumentInCurrencyPair() throws Exception {

        MoneyConverterCurrencyPair moneyConverterCurrencyPair =
                new MoneyConverterCurrencyPair(
                        MoneyExchangeCurrencyData.ARS, null
                        );
        MoneyExchangeRaterConstants.getMoneyConverterURL(moneyConverterCurrencyPair);

    }

}