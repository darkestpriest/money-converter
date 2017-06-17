package org.darkestapp.money_exchange_rater.interfaces;

import java.util.Objects;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/06/17.
 */
public class Step {

    private final String apiFrom;
    private final String apiTo;

    public Step(String apiFrom, String apiTo) {
        this.apiFrom = apiFrom;
        this.apiTo = apiTo;
    }

    public String getApiFrom() {
        return apiFrom;
    }

    public String getApiTo() {
        return apiTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return Objects.equals(apiFrom, step.apiFrom) &&
                Objects.equals(apiTo, step.apiTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiFrom, apiTo);
    }
}
