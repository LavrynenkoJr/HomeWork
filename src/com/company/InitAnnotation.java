package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Cyborg on 2/12/2017.
 */
@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface InitAnnotation {
}
