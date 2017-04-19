package org.darkestapp.money_exchange_rater.api.c_cex;

import org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode;
import org.darkestapp.money_exchange_rater.api.c_cex.exceptions.CCexApiException;
import org.darkestapp.money_exchange_rater.api.c_cex.processors.CCexObject;
import org.darkestapp.money_exchange_rater.api.c_cex.processors.JsonCCexParser;
import org.darkestapp.money_exchange_rater.api.c_cex.util.CCexCurrencyPair;
import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.darkestapp.money_exchange_rater.interfaces.*;
import org.darkestapp.money_exchange_rater.util.CurrencyCodeScanner;

import java.util.List;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/04/17.
 */
@Api(enabled = true)
public class CCexApi implements ExchangeRaterApi<CCexCurrencyPair, CCexObject> {

    private static final String CONTEXT = CCexApi.class.getSimpleName();

    @Override
    public boolean isCurrencyPairAllowed(final CCexCurrencyPair currencyPair)
            throws MoneyExchangeRaterException {

        if(currencyPair == null) {
            throw new ParseException(CONTEXT, "Currency pair cannot be null");
        }

        List<String> supportedCodeList = CurrencyCodeScanner
                .getSupportedCurrencyCodeList(
                        CCexCurrencyCode.class,
                        this.getClass());
        if(!supportedCodeList.contains(currencyPair.getCurrencyFrom().getCode())) {
            return false;
        }
        if(!supportedCodeList.contains(currencyPair.getCurrencyTo().getCode())) {
            return false;
        }
        return true;
    }

    @Override
    public CCexObject getApiObject(final CCexCurrencyPair currencyPair)
            throws MoneyExchangeRaterException {

        try {
            JsonCCexParser parser = new JsonCCexParser(CCexApi.class);
            return parser.getApiObject(currencyPair);
        } catch (MoneyExchangeRaterException e) {
            throw new CCexApiException(
                    e,
                    CONTEXT,
                    "An exception has occurred getting the exchange rate from public API");
        } catch (Exception e) {
            throw new CCexApiException(
                    e,
                    CONTEXT,
                    "A generic exception has occurred getting the exchange rate from public API");
        }
    }
}
