package org.darkestapp.money_exchange_rater.interfaces.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 18/04/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Supported {

    boolean value() default true;
}
