package org.darkestapp.money_exchange_rater.api.money_converter.exceptions;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 14/04/17.
 */
public class ParseException extends MoneyExchangeRaterApiException {

    private static final String DEFAULT_MESSAGE = "Cannot parse data";

    public ParseException(Exception cause, String context, String possibleReason) {
        super(DEFAULT_MESSAGE, cause, context, possibleReason);
    }

    public ParseException(String context, String possibleReason) {
        super(DEFAULT_MESSAGE, null, context, possibleReason);
    }
}
