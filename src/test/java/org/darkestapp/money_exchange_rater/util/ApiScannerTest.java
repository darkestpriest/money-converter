package org.darkestapp.money_exchange_rater.util;

import org.darkestapp.money_exchange_rater.interfaces.ExchangeRaterApi;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.darkestapp.money_exchange_rater.util.ApiScanner.getAvailableApiList;
import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/04/17.
 */
public class ApiScannerTest {
    @Test
    public void getAvailableApiListTest() throws Exception {

        List<ExchangeRaterApi> apiList = getAvailableApiList();
        assertNotNull(apiList);
        assertThat((long)apiList.size(), greaterThan(0L));
    }

}