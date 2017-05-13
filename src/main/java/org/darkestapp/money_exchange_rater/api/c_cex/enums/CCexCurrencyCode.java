package org.darkestapp.money_exchange_rater.api.c_cex.enums;

import org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.annotations.Supported;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 15/04/17.
 */
public enum CCexCurrencyCode implements CurrencyCode {

    @Supported(value = false)
    ARS (PublicCurrencyCode.ARS),
    @Supported
    BTC (PublicCurrencyCode.BTC),
    @Supported
    DGC (PublicCurrencyCode.DOGE),
    @Supported
    ETH (PublicCurrencyCode.ETH),
    @Supported
    IOP (PublicCurrencyCode.IOP),
    @Supported
    LTC (PublicCurrencyCode.LTC),
    @Supported
    USD (PublicCurrencyCode.USD);

    private PublicCurrencyCode currency;

    CCexCurrencyCode(PublicCurrencyCode currency) {

        this.currency = currency;
    }

    public String getCode() {
        return this.currency.getCode();
    }

    public String getLowerCaseCode () {
        return this.currency.getCode().toLowerCase();
    }
}
