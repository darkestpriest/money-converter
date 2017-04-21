package org.darkestapp.money_exchange_rater;

import org.darkestapp.money_exchange_rater.interfaces.ExchangeRaterApi;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.darkestapp.money_exchange_rater.util.ApiScanner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will manage all the available API in the library.
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 20/04/17.
 */
public class ApiManager {

    private final HashMap<String, ExchangeRaterApi> availableApiMap;

    /**
     * Default constructor
     * @throws MoneyExchangeRaterException
     */
    public ApiManager() throws MoneyExchangeRaterException {

        List<ExchangeRaterApi> availableApiList = ApiScanner.getAvailableApiList();
        this.availableApiMap = new HashMap<>();
        availableApiList.forEach(
                exchangeRaterApi -> availableApiMap.put(
                        exchangeRaterApi
                                .getApiId()
                                .getShortName(),
                        exchangeRaterApi));
    }

    /**
     * This method returns the available api identified by a Api Code.
     * @return
     */
    public Map<String, ExchangeRaterApi> getAvailableApiMap() {

        return this.availableApiMap;
    }
}
