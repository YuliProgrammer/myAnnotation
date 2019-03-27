package com.dolnikova;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface Column {
    String info() ;
}