package org.darkestapp.money_exchange_rater.api.c_cex.exceptions;

import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public class CCexApiException extends MoneyExchangeRaterException {

    private static final String DEFAULT_MESSAGE = "C-Cex API found an exception, please, check the stacktrace";

    /**
     * Default constructor.
     *
     * @param message
     * @param cause
     * @param context
     * @param possibleReason
     */
    public CCexApiException(String message, Exception cause, String context, String possibleReason) {
        super(message, cause, context, possibleReason);
    }

    public CCexApiException(Exception cause, String context, String possibleReason) {
        super(DEFAULT_MESSAGE, cause, context, possibleReason);
    }

    public CCexApiException(Exception cause, Class context, String possibleReason) {
        super(DEFAULT_MESSAGE, cause, context.getSimpleName(), possibleReason);
    }
}
