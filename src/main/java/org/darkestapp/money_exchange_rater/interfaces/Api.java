package org.darkestapp.money_exchange_rater.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 17/04/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Api {

    boolean enabled() default false;
}
