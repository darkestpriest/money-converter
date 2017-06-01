package org.darkestapp.money_exchange_rater.util;

import com.github.markusbernhardt.proxy.ProxySearch;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;

import java.net.ProxySelector;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 21/05/17.
 */
public class ProxyHelper {

    private static final String DEFAULT_EXCEPTION_MESSAGE = "Proxy Helper Exception";

    private ProxyHelper() {
        //Just to avoid public instantiation
    }

    public static void configProxy(final String context) throws MoneyExchangeRaterException {

        try {
            ProxySearch proxySearch = ProxySearch.getDefaultProxySearch();
            proxySearch.addStrategy(ProxySearch.Strategy.OS_DEFAULT);
            proxySearch.addStrategy(ProxySearch.Strategy.JAVA);
            ProxySelector proxySelector = proxySearch.getProxySelector();
            ProxySelector.setDefault(proxySelector);
        } catch (Exception e) {
            throw new MoneyExchangeRaterException(
                    DEFAULT_EXCEPTION_MESSAGE,
                    e,
                    context,
                    "Cannot set the proper proxy configuration");
        }

    }
}
