package com.litieming.test.utils;

import java.lang.reflect.Field;

public class InitObjWithObjUtil {
    public static void initObjWithObj(Object source, Object target) throws IllegalAccessException, NoSuchFieldException {

        Class clazzSource = source.getClass();
        Class clazzTarget = target.getClass();

        //源对象所有的属性
        Field[] sourceFields = clazzSource.getDeclaredFields();

        for (Field sourceFieldsItem: sourceFields) {
            //检查源数据某属性的访问权限
            boolean accessFlag = sourceFieldsItem.isAccessible();
            if (!sourceFieldsItem.isAccessible()) {
                sourceFieldsItem.setAccessible(true);
            }
            if (sourceFieldsItem.get(source) != null) {
                //看目标对象中有没有该属性（同名的属性）
                Field targetField = clazzTarget.getDeclaredField(sourceFieldsItem.getName());

                //看源和目标对象同名属性的数据类型是否相同
                if (targetField.getType().equals(sourceFieldsItem.getType())) {
                    //判断目标对象该属性的访问权限
                    boolean targetAccessFlag = targetField.isAccessible();
                    if (!targetField.isAccessible()) {
                        targetField.setAccessible(true);
                        //赋值
                        targetField.set(target, sourceFieldsItem.get(source));
                        //回复目标对象该属性的访问权限
                        targetField.setAccessible(targetAccessFlag);
                    }
                }

            }
            //恢复源对象该属性访问权限
            sourceFieldsItem.setAccessible(accessFlag);
        }
    }
}
