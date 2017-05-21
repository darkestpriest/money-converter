package org.darkestapp.money_exchange_rater.util;

import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;

import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 21/05/17.
 */
public class ProxyHelper {

    private static String context;

    private static final String USE_SYSTEM_PROXIES_PROPERTY = "java.net.useSystemProxies";
    private static final String DEFAULT_EXCEPTION_MESSAGE = "Proxy Helper Exception";

    public static void configProxy(final Class contextClass, String url) throws MoneyExchangeRaterException {

        context = contextClass.getSimpleName();
        try {
            System.setProperty(USE_SYSTEM_PROXIES_PROPERTY, "true");
            List proxies = ProxySelector
                    .getDefault()
                    .select(new URI(url));
        } catch (URISyntaxException e) {
            throw new MoneyExchangeRaterException(
                    DEFAULT_EXCEPTION_MESSAGE,
                    e,
                    context,
                    "Cannot set the URI for test a proxy connection");
        }

    }
}
