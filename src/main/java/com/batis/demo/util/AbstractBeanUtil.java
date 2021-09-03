package com.batis.demo.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

/**
 * Created by NULL on 2017/5/6.
 */
public abstract class AbstractBeanUtil {

    protected static Field getDeclaredField(Class clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            if (clazz.getSuperclass() == Object.class) {
                return null;
            }
            return getDeclaredField(clazz.getSuperclass(), fieldName);
        }
    }

    protected static boolean checkProperty(Class clazz, PropertyDescriptor property, Class annotationClass) {
        String key = property.getName();

        // 过滤class属性
        if (key.equals("class")) {
            return true;
        }
        Field field = getDeclaredField(clazz, key);
        // 没有定义字段跳过
        if (field == null) {
            return true;
        }
        // 不是字符串跳过
        if (field.getType() != String.class) {
            return true;
        }
        // 没有目标注解跳过
        return field.getAnnotation(annotationClass) == null;
    }
}
