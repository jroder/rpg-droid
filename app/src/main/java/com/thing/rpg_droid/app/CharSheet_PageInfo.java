package com.thing.rpg_droid.app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jon on 8/08/14.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CharSheet_PageInfo
{
    public String title() default "";
}
