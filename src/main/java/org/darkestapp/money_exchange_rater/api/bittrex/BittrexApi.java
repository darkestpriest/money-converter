package org.darkestapp.money_exchange_rater.api.bittrex;

import org.darkestapp.money_exchange_rater.interfaces.annotations.Api;
import org.darkestapp.money_exchange_rater.api.bittrex.enums.BittrexCurrencyCode;
import org.darkestapp.money_exchange_rater.api.bittrex.processors.BittrexObject;
import org.darkestapp.money_exchange_rater.api.bittrex.processors.JsonBittrexParser;
import org.darkestapp.money_exchange_rater.api.bittrex.util.BittrexCurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 28/04/17.
 */
@Api(enabled = true)
public class BittrexApi extends AbstractExchangeRaterApi<BittrexObject>
        implements ExchangeRaterApi<BittrexObject> {

    private static final String CONTEXT = BittrexApi.class.getSimpleName();
    private static final String API_SHORT_NAME = "BITT";
    private static final String API_FRIENDLY_NAME = "Bittrex";

    public BittrexApi() {
        super(BittrexApi.class, BittrexCurrencyCode.class);
    }

    @Override
    public BittrexObject getApiObject(final CurrencyPair currencyPair)
            throws MoneyExchangeRaterException {

        try {
            JsonBittrexParser parser = new JsonBittrexParser(BittrexApi.class);
            return parser.getApiObject(new BittrexCurrencyPair(currencyPair));
        } catch (MoneyExchangeRaterException e) {
            throw new MoneyExchangeRaterException(
                    "Error requesting the data",
                    e,
                    CONTEXT,
                    "An exception has occurred getting the exchange rate from public API");
        } catch (Exception e) {
            throw new MoneyExchangeRaterException(
                    "Error requesting the data",
                    e,
                    CONTEXT,
                    "A generic exception has occurred getting the exchange rate from public API");
        }
    }

    @Override
    public ApiId getApiId() {
        return new ApiId(API_SHORT_NAME, API_FRIENDLY_NAME);
    }
}
