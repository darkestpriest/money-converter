package org.darkestapp.money_exchange_rater.rater;

import org.darkestapp.money_exchange_rater.interfaces.ApiObject;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.Rater;
import org.darkestapp.money_exchange_rater.interfaces.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/06/17.
 */
public class CurrencyRater implements Rater {

    private final ApiObject apiObject;
    private final CurrencyPair currencyPair;
    private List<Step> path;

    public CurrencyRater(
            final ApiObject apiObject,
            final CurrencyPair currencyPair) {
        this.apiObject = apiObject;
        this.currencyPair = currencyPair;
        this.path = new ArrayList<>();
    }

    @Override
    public ApiObject getApiObject() {
        return this.apiObject;
    }

    @Override
    public CurrencyPair getCurrencyPair() {
        return this.currencyPair;
    }

    @Override
    public List<Step> getPath() {
        return this.path;
    }

    public void appendStep(Step step) {
        this.path.add(step);
    }

    public void appendStep(String apiIdFrom, String apiIdTo) {
        appendStep(new Step(apiIdFrom, apiIdTo));
    }

    public void appendStep(String apiId) {
        appendStep(apiId, "-");
    }
}
