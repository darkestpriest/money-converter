package org.darkestapp.money_exchange_rater.util;

import org.darkestapp.money_exchange_rater.interfaces.MoneyExchangeRaterException;
import org.darkestapp.money_exchange_rater.interfaces.Supported;
import org.reflections.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.reflections.ReflectionUtils.withAnnotation;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 18/04/17.
 */
public class CurrencyCodeScanner {

    private static final String EXCEPTION_MESSAGE = "An error has occurred scanning the api objects";

    private CurrencyCodeScanner() {
        //Just to avoid public instantiation.
    }

    /**
     * Returns a List with the codes retrieved from the currencyCode Class.
     * This list contains all the enum parameters marked with the annotation Supported using its default value.
     * @param currencyCodeClass enum that contains the currency code
     * @param context The class that executes this object.
     * @return
     * @throws MoneyExchangeRaterException
     */
    public static List<String> getSupportedCurrencyCodeList(
            Class currencyCodeClass,
            Class context) throws MoneyExchangeRaterException{

        try {

            Set<Field> enumElements =
                    ReflectionUtils.getAllFields(
                            currencyCodeClass,
                            withAnnotation(Supported.class));

            List<String> codeList = new ArrayList<>();
            for(Field field : enumElements) {
                if(getAnnotation(field).value()) {

                    codeList.add(field.getName());
                }
            }

            return codeList;
        } catch (Exception e) {
            throw new MoneyExchangeRaterException(
                    EXCEPTION_MESSAGE,
                    e,
                    context.getSimpleName(),
                    "An error has occurred while scanning the Currency Code List");
        }
    }

    private static Supported getAnnotation(Field field) {
        Annotation annotation = field.getAnnotation(Supported.class);
        return (Supported) annotation;
    }
}
