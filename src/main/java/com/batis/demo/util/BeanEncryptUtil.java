package com.batis.demo.util;

import com.batis.demo.annoation.EncryptedField;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Bean字段加觖密工具类
 * Created by Jason.Shi on 2017/1/4.
 */
public class BeanEncryptUtil extends AbstractBeanUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(BeanEncryptUtil.class);

    public static Object encryptInfo(CipherService service, Object object) {
        if (Objects.isNull(object)) {
            return null;
        }
        try {
            return encrypt(service, object);
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            LOGGER.warn("encryptInfo", e);
            return object;
        }
    }

    public static Object decryptInfo(CipherService service, Object object) {
        if (Objects.isNull(object)) {
            return null;
        }
        try {
            return decrypt(service, object);
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            LOGGER.warn("decryptInfo", e);
            return object;
        }
    }

    private static Object encrypt(CipherService service, Object object) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class clazz = object.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            if (checkProperty(clazz, property, EncryptedField.class)) {
                continue;
            }

            // 加密操作
            Method getter = property.getReadMethod();
            String value = (String) getter.invoke(object);
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            value = service.encrypt(value);
            Method setter = property.getWriteMethod();
            setter.invoke(object, value);
        }
        return object;
    }

    private static Object decrypt(CipherService service, Object object) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class clazz = object.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            if (checkProperty(clazz, property, EncryptedField.class)) {
                continue;
            }

            // 加密操作
            Method getter = property.getReadMethod();
            String value = (String) getter.invoke(object);
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            value = service.decrypt(value);
            Method setter = property.getWriteMethod();
            setter.invoke(object, value);
        }
        return object;
    }


}
