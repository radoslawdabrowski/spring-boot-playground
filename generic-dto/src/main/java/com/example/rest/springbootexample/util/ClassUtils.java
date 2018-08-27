package com.example.rest.springbootexample.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by rdabrowski on 07.06.2017.
 */
public class ClassUtils{

    protected ClassUtils() {}

    public static <T> void setIfNotNull(final Supplier<? extends T> getter, final Consumer<T> setter){
        T t = getter.get();
        if(null != t){
            setter.accept(t);
        }
    }

}
