package org.darkestapp.money_exchange_rater.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 21/05/17.
 */
public class ProxyHelperTest {
    @Test
    public void configProxy() throws Exception {

        ProxyHelper.configProxy(this.getClass().getSimpleName());
    }

}