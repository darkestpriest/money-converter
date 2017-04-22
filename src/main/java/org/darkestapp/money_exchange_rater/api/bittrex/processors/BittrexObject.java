package org.darkestapp.money_exchange_rater.api.bittrex.processors;

import org.darkestapp.money_exchange_rater.api.bittrex.util.BittrexCurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.ApiObject;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.darkestapp.money_exchange_rater.api.bittrex.util.BittrexConstants.TIMESTAMP_DATE_FORMAT;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 22/04/17.
 */
public class BittrexObject implements ApiObject {

    private final BittrexCurrencyPair currencyPair;
    private final BigDecimal buyPrice;
    private final BigDecimal sellPrice;
    private final Date requestTime;

    public BittrexObject(
            final BittrexCurrencyPair currencyPair,
            final BigDecimal buyPrice,
            final BigDecimal sellPrice,
            final String timestamp) {
        this.currencyPair = currencyPair;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.requestTime = parseTimestamp(timestamp);
    }

    @Override
    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    @Override
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    @Override
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    private Date parseTimestamp(String timestamp) {

        DateFormat dateFormat = new SimpleDateFormat(TIMESTAMP_DATE_FORMAT);
        try {
            return dateFormat.parse(timestamp);
        } catch (ParseException e) {
            return new Date();
        }
    }

    @Override
    public String toString() {
        return "BittrexObject{" +
                "currencyPair=" + currencyPair +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", requestTime=" + requestTime +
                '}';
    }
}
