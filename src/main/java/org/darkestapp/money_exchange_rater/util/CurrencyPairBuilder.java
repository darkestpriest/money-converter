package org.darkestapp.money_exchange_rater.util;

import org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;

import static org.darkestapp.money_exchange_rater.config.PublicConstants.MARKET_PRICES_SEPARATOR;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 13/05/17.
 */
public class CurrencyPairBuilder {

    public static CurrencyPair build(PublicCurrencyCode currencyFrom, PublicCurrencyCode currencyTo) {
        return new CurrencyPairBuilt(currencyFrom, currencyTo);
    }

    static class CurrencyPairBuilt implements CurrencyPair {

        private final PublicCurrencyCode currencyFrom;
        private final PublicCurrencyCode currencyTo;

        public CurrencyPairBuilt(final PublicCurrencyCode currencyFrom, final PublicCurrencyCode currencyTo) {
            this.currencyFrom = currencyFrom;
            this.currencyTo = currencyTo;
        }

        @Override
        public PublicCurrencyCode getCurrencyFrom() {
            return this.currencyFrom;
        }

        @Override
        public PublicCurrencyCode getCurrencyTo() {
            return this.currencyTo;
        }

        @Override
        public String getCurrenciesCodes() {
            return currencyFrom.getCode().toLowerCase()
                    + MARKET_PRICES_SEPARATOR
                    + currencyTo.getCode().toLowerCase();
        }
    }
}
