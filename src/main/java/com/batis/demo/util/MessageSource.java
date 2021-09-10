package com.batis.demo.util;

import com.batis.demo.BatisApplication;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class MessageSource {

    public static String get(String msgKey) {
        try {
            ReloadableResourceBundleMessageSource messageSource = BatisApplication.getBean("messageSource");
            return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            return msgKey;
        }
    }
}
