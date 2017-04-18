package org.darkestapp.money_exchange_rater.util;

import org.darkestapp.money_exchange_rater.interfaces.Api;
import org.darkestapp.money_exchange_rater.interfaces.ExchangeRaterApi;
import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.darkestapp.money_exchange_rater.config.PublicConstants.API_CLASSPATH;
import static org.darkestapp.money_exchange_rater.config.PublicConstants.API_INTERFACE_NAME;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/04/17.
 */
public class ApiScanner {

    private static final String CONTEXT = ApiScanner.class.getSimpleName();
    private static final String EXCEPTION_MESSAGE = "An error has occurred scanning the api objects";

    private ApiScanner() {
        //Just to avoid public instantiation
    }

    public static List<ExchangeRaterApi> getAvailableApiList() throws MoneyExchangeRaterException {

        Reflections reflections = new Reflections(API_CLASSPATH);
        Set<Class<?>> apiClasses =
                reflections.getTypesAnnotatedWith(Api.class);

        return retrieveClasses(apiClasses);

    }

    private static List<ExchangeRaterApi> retrieveClasses(Set<Class<?>> apiClasses)
            throws MoneyExchangeRaterException {

        Api apiEnabled;

        List<ExchangeRaterApi> apiList = new ArrayList<>();

        for(Class apiClass : apiClasses) {

            apiEnabled = getAnnotation(apiClass);
            if(apiEnabled.enabled()) {

                Class<?>[] interfaces = apiClass.getInterfaces();
                if(isValidInterfacePresent(interfaces)) {
                    apiList.add(getExchangeRaterApi(apiClass));
                }
            }
        }
        return apiList;
    }

    private static Api getAnnotation(Class apiClass) {
        Annotation annotation = apiClass.getAnnotation(Api.class);
        return (Api) annotation;
    }

    private static ExchangeRaterApi getExchangeRaterApi(Class apiClass) throws MoneyExchangeRaterException {
        try {

            Object apiObject = apiClass.getClassLoader().loadClass(apiClass.getName()).newInstance();
            return (ExchangeRaterApi) apiObject;
        } catch (ClassNotFoundException e) {
            throw new MoneyExchangeRaterException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    "Cannot find the class");
        } catch (IllegalAccessException e) {
            throw new MoneyExchangeRaterException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    "Cannot access the class");
        } catch (InstantiationException e) {
            throw new MoneyExchangeRaterException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    "Cannot instantiate the class");
        }

    }

    private static boolean isValidInterfacePresent(Class<?>[] interfaces) {

        for(Class interfaceElement : interfaces) {

            if(interfaceElement.getSimpleName().equals(API_INTERFACE_NAME)) {
                return true;
            }
        }
        return false;
    }
}
