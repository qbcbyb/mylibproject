package com.eric.library.ericlibrary.base;

import com.eric.library.commonutils.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by eric on 2014/11/28.
 */
public class EBaseModel extends Object implements Serializable {

    public Object getValue(String key) {
        try {
            key = StringUtils.capitalizeFirstLetter(key);//获取get方法
            Class clazz = this.getClass();
            Method getMethod = null;
            try {
                getMethod = clazz.getDeclaredMethod("get" + key);
            } catch (NoSuchMethodException e) {
                try {
                    getMethod = clazz.getDeclaredMethod("is" + key);
                } catch (NoSuchMethodException e1) {
                    try {
                        getMethod = clazz.getDeclaredMethod("have" + key);
                    } catch (NoSuchMethodException e2) {
                        try {
                            getMethod = clazz.getDeclaredMethod("has" + key);
                        } catch (NoSuchMethodException e3) {
                            return null;
                        }
                    }
                }
            }
            Object value = getMethod.invoke(this);
            return value;
        } catch (InvocationTargetException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }
}
