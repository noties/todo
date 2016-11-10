package ru.noties.todo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Todo {
    String value() default "";
    boolean blocker() default false;
}
