package com.xiaow.ssmdemo.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiaow
 * @create  2021/5/28
 */
public class ObjectConvertUtil {
    /**
     * 获取类的所有属性，包括父类
     *
     * @param object
     * @return
     */
    public static Field[] getAllFields(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<Field>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return (true);
        }
        if ("".equals(object)) {
            return (true);
        }
        if ("null".equals(object)) {
            return (true);
        }
        return (false);
    }


}



