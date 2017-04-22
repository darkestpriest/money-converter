package org.darkestapp.money_exchange_rater.api.c_cex.processors;

import org.darkestapp.money_exchange_rater.api.c_cex.util.CCexConstants;
import org.darkestapp.money_exchange_rater.api.c_cex.util.CCexCurrencyPair;
import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.darkestapp.money_exchange_rater.interfaces.JsonParser;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.json.JSONException;
import org.json.JSONObject;

import static org.darkestapp.money_exchange_rater.api.c_cex.util.CCexConstants.MARKET_PRICES_BUY_PRICES_KEY;
import static org.darkestapp.money_exchange_rater.api.c_cex.util.CCexConstants.MARKET_PRICES_SELL_PRICES_KEY;
import static org.darkestapp.money_exchange_rater.api.c_cex.util.CCexConstants.MARKET_PRICES_TIMESTAMP_KEY;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 16/04/17.
 */
public class JsonCCexParser extends JsonParser<CCexObject, CCexCurrencyPair> {

    public JsonCCexParser(Class context) {
        super(context);
    }

    public CCexObject getApiObject(CCexCurrencyPair currencyPair)
            throws MoneyExchangeRaterException {
        return getApiObject(CCexConstants.MARKET_PRICES_URL, currencyPair);
    }

    @Override
    public CCexObject getApiObject(
            String url,
            CCexCurrencyPair currencyPair) throws MoneyExchangeRaterException {

        try{

            JSONObject jsonObject = getRequest(url);

            JSONObject parsedForCurrencyPair = jsonObject.getJSONObject(
                    currencyPair.getCurrenciesCodes());

            return new CCexObject(
                    currencyPair,
                    parsedForCurrencyPair.getBigDecimal(MARKET_PRICES_BUY_PRICES_KEY),
                    parsedForCurrencyPair.getBigDecimal(MARKET_PRICES_SELL_PRICES_KEY),
                    parsedForCurrencyPair.getBigInteger(MARKET_PRICES_TIMESTAMP_KEY));
        } catch (JSONException e) {
            throw new ParseException(e, CONTEXT, "Cannot parse the json object");
        } catch (Exception e) {
            throw new ParseException(e, CONTEXT, "An error has occurred parsing a json object");
        }
    }
}
