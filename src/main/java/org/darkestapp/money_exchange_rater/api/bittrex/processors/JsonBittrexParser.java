package org.darkestapp.money_exchange_rater.api.bittrex.processors;

import org.darkestapp.money_exchange_rater.api.bittrex.util.BittrexCurrencyPair;
import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.darkestapp.money_exchange_rater.interfaces.JsonParser;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static org.darkestapp.money_exchange_rater.api.bittrex.util.BittrexConstants.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 22/04/17.
 */
public class JsonBittrexParser extends JsonParser<BittrexObject, BittrexCurrencyPair> {

    public JsonBittrexParser(Class context) {
        super(context);
    }

    public BittrexObject getApiObject(final BittrexCurrencyPair currencyPair)
            throws MoneyExchangeRaterException {
        return getApiObject(
                MARKET_PRICES_URL + currencyPair.getCurrenciesCodes(),
                currencyPair);
    }

    @Override
    public BittrexObject getApiObject(
            final String url,
            final BittrexCurrencyPair currencyPair) throws MoneyExchangeRaterException {
        try{

            JSONObject jsonObject = getRequest(url);

            if(!jsonObject.getBoolean(MARKET_PRICES_SUCCES_KEY)) {
                throw new ParseException(
                        null,
                        CONTEXT,
                        "Market not supported");
            }

            JSONArray array = jsonObject.getJSONArray(
                    MARKET_PRICES_RESULT_KEY);

            JSONObject parsedForCurrencyPair = array.getJSONObject(0);

            return new BittrexObject(
                    currencyPair,
                    parsedForCurrencyPair.getBigDecimal(MARKET_PRICES_BUY_PRICES_KEY),
                    parsedForCurrencyPair.getBigDecimal(MARKET_PRICES_SELL_PRICES_KEY),
                    parsedForCurrencyPair.getString(MARKET_PRICES_TIMESTAMP_KEY));
        } catch (JSONException e) {
            throw new ParseException(
                    e,
                    CONTEXT,
                    "Cannot parse the json object");
        } catch (Exception e) {
            throw new ParseException(
                    e,
                    CONTEXT,
                    "An error has occurred parsing a json object");
        }
    }

}
