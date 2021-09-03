package com.batis.demo.annoation;


import java.lang.annotation.*;

/**
 * Excel import export Index
 * Created by dell on 8/15/2015.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EncryptedField {
}
