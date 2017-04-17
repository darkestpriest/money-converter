package org.darkestapp.money_exchange_rater.api.c_cex.processors;

import org.darkestapp.money_exchange_rater.api.c_cex.util.CCexCurrencyPair;
import org.darkestapp.money_exchange_rater.interfaces.ApiObject;
import org.darkestapp.money_exchange_rater.interfaces.CurrencyPair;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import static org.darkestapp.money_exchange_rater.api.c_cex.util.CCexConstants.MARKET_PRICES_TIMESTAMP_MULTIPLIER;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 16/04/17.
 */
public class CCexObject implements ApiObject {
    private final CCexCurrencyPair currencyPair;
    private final BigDecimal buyPrice;
    private final BigDecimal sellPrice;
    private final Date requestTime;

    public CCexObject(
            final CCexCurrencyPair currencyPair,
            final BigDecimal buyPrice,
            final BigDecimal sellPrice,
            final BigInteger timestamp) {
        this.currencyPair = currencyPair;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.requestTime = parseTimestamp(timestamp);
    }

    @Override
    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    private Date parseTimestamp(BigInteger timestamp) {

        Timestamp stamp = new Timestamp(
                timestamp.longValue() * MARKET_PRICES_TIMESTAMP_MULTIPLIER);
        return new Date(stamp.getTime());
    }

    @Override
    public String toString() {
        return "CCexObject{" +
                "currencyPair=" + currencyPair +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", requestTime=" + requestTime +
                '}';
    }
}
