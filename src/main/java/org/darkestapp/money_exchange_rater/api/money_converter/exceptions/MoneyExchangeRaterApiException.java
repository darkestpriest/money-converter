package org.darkestapp.money_exchange_rater.api.money_converter.exceptions;

import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 14/04/17.
 */
public class MoneyExchangeRaterApiException extends MoneyExchangeRaterException {

    private static final String DEFAULT_MESSAGE = "Money Converter API found an exception, please, check the stacktrace";

    /**
     * Default constructor.
     *
     * @param message
     * @param cause
     * @param context
     * @param possibleReason
     */
    public MoneyExchangeRaterApiException(String message, Exception cause, String context, String possibleReason) {
        super(message, cause, context, possibleReason);
    }

    public MoneyExchangeRaterApiException(Exception cause, String context, String possibleReason) {
        super(DEFAULT_MESSAGE, cause, context, possibleReason);
    }

}
