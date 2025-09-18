package com.solvd.taxi.model;

import java.lang.reflect.Field;

public class DataMasker {

    public static String maskSensitive(Object obj) {
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = obj.getClass();

        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    if (field.isAnnotationPresent(SensitiveData.class)) {
                        SensitiveData annotation = field.getAnnotation(SensitiveData.class);
                        String mask = annotation.maskWith();
                        sb.append(field.getName()).append("=")
                                .append(mask).append(", ");
                    } else {
                        sb.append(field.getName()).append("=")
                                .append(field.get(obj)).append(", ");
                    }
                } catch (IllegalAccessException e) {
                   e.printStackTrace();
                }
            }
            clazz = clazz.getSuperclass();
        }
        return sb.toString();
    }
}