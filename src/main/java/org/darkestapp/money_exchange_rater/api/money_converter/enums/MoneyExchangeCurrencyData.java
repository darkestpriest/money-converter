package org.darkestapp.money_exchange_rater.api.money_converter.enums;

import org.darkestapp.money_exchange_rater.interfaces.CurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.enums.PublicCurrencyCode;


/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public enum MoneyExchangeCurrencyData implements CurrencyCode {
    ARS (PublicCurrencyCode.ARS),
    USD (PublicCurrencyCode.USD);

    private PublicCurrencyCode currency;

    MoneyExchangeCurrencyData(PublicCurrencyCode currency) {

        this.currency = currency;
    }

    public String getCode() {
        return this.currency.getCode();
    }
}
