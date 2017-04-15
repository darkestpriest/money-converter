package org.darkestapp.money_exchange_rater.api.money_converter.util;

import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class MoneyExchangeRaterConstants {

    private static final String CONTEXT = MoneyExchangeRaterConstants.class.getSimpleName();
    private static final String REPLACER_STRING = "_replacer_";

    private static final int NUMBER_OF_ELEMENTS = 2;

    private static final String[] toReplaceArray = getReplaceArray(NUMBER_OF_ELEMENTS);

    private static final String moneyConverterURL =
            "https://themoneyconverter.com/ES/CurrencyConverter.aspx?tab=0&amp;bg=ffffff&amp;from=" +
                    REPLACER_STRING + 0 +
                    "&amp;to=" +
                    REPLACER_STRING + 1;

    private MoneyExchangeRaterConstants() {
    }

    private static String[] getReplaceArray(int elements) {

        String[] toReplaceArray = new String[elements];
        for(int i = 0; i < elements; i++) {
            toReplaceArray[i] = REPLACER_STRING + i;
        }

        return toReplaceArray;
    }

    public static final String getMoneyConverterURL(final MoneyConverterCurrencyPair currencyPair) throws ParseException {

        if(currencyPair == null) {
            throw new ParseException(CONTEXT, "Currency Pair cannot be null");
        }

        if(!isCurrencyPairArgumentsSet(currencyPair)) {
            throw new ParseException(CONTEXT, "Currency Pair is not properly set, please, check: "+currencyPair.toString());
        }

        return moneyConverterURL
                .replace(toReplaceArray[0], currencyPair.getCurrencyFrom().getCode())
                .replace(toReplaceArray[1], currencyPair.getCurrencyTo().getCode());
    }

    private static boolean isCurrencyPairArgumentsSet(final MoneyConverterCurrencyPair currencyPair) {

        if(currencyPair.getCurrencyFrom() == null) {
            return false;
        }

        if(currencyPair.getCurrencyTo() == null) {
            return false;
        }

        return true;
    }
}
