package org.darkestapp.money_exchange_rater.rater;

import org.darkestapp.money_exchange_rater.ApiManager;
import org.darkestapp.money_exchange_rater.interfaces.*;
import org.darkestapp.money_exchange_rater.rater.nulls.EmptyRater;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/06/17.
 */
public class RaterManager {

    public static Rater getRater(CurrencyPair currencyPair) {

        Map<String, ExchangeRaterApi> apiMap = getAvailableApiMap();
        return getRater(currencyPair, apiMap);
    }

    private static Map<String, ExchangeRaterApi> getAvailableApiMap() {

        Map<String, ExchangeRaterApi> apiMap = new HashMap<>();

        try {
            ApiManager apiManager = new ApiManager();
            apiMap = apiManager.getAvailableApiMap();
        } catch (MoneyExchangeRaterException e) {
            e.printStackTrace();
        }

        return apiMap;
    }

    private static Rater getRater(CurrencyPair currencyPair, Map<String, ExchangeRaterApi> apiMap) {

        ExchangeRaterApi api;
        ApiObject apiObject;
        Rater rater = new EmptyRater();
        for(Map.Entry<String, ExchangeRaterApi> entry : apiMap.entrySet()) {

            api = entry.getValue();
            try {
                if(api.isCurrencyPairAllowed(currencyPair)) {
                    apiObject = api.getApiObject(currencyPair);
                    CurrencyRater currencyRater = new CurrencyRater(apiObject, currencyPair);
                    currencyRater.appendStep(api.getApiId().getShortName());
                    return currencyRater;
                }
            } catch (MoneyExchangeRaterException e) {
                e.printStackTrace();
            }
        }

        return rater;
    }
}
