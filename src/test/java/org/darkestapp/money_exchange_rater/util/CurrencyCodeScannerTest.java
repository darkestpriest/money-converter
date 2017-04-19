package org.darkestapp.money_exchange_rater.util;

import org.darkestapp.money_exchange_rater.api.c_cex.enums.CCexCurrencyCode;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 18/04/17.
 */
public class CurrencyCodeScannerTest {
    @Test
    public void getSupportedCurrencyCodeListTest() throws Exception {
        List<String> result = CurrencyCodeScanner.getSupportedCurrencyCodeList(CCexCurrencyCode.class, this.getClass());
        assertNotNull(result);
        assertThat(result.size(), greaterThan(0));
    }

}