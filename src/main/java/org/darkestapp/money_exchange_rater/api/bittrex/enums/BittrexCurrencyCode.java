package org.darkestapp.money_exchange_rater.api.bittrex.enums;

import org.darkestapp.money_exchange_rater.enums.PublicCurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyCode;
import org.darkestapp.money_exchange_rater.interfaces.Supported;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 22/04/17.
 */
public enum BittrexCurrencyCode implements CurrencyCode {

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
    USDT (PublicCurrencyCode.USDT);

    private PublicCurrencyCode currency;

    BittrexCurrencyCode(PublicCurrencyCode currency) {

        this.currency = currency;
    }

    public String getCode() {
        return this.currency.getCode();
    }

    public String getLowerCaseCode () {
        return this.currency.getCode().toLowerCase();
    }
}
