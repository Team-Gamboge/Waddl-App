package com.northcoders.gamboge.waddl.utility;

import java.lang.reflect.Field;

public class Utility {

    public static <T> Boolean containsNullNonPrimitiveFields(T instance) {
        try {
            Field[] fields = instance.getClass().getDeclaredFields();

            for (Field field: fields) {
                boolean wasOriginallyAccessible = field.isAccessible();

                if (!wasOriginallyAccessible)
                    field.setAccessible(true);

                if (field.get(instance) == null) {
                    if (!wasOriginallyAccessible)
                        field.setAccessible(true);

                    return true;
                }

                if (!wasOriginallyAccessible)
                    field.setAccessible(false);
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException |
                 ExceptionInInitializerError | NullPointerException | ClassCastException | UnsupportedOperationException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public static <T> Boolean containsBlankStringFields(T instance) {
        try {
            Field[] fields = instance.getClass().getDeclaredFields();

            for (Field field: fields) {
                boolean wasOriginallyAccessible = field.isAccessible();

                if (!wasOriginallyAccessible)
                    field.setAccessible(true);

                Object instanceField = field.get(instance);

                if (!(instanceField instanceof String))
                    continue;

                if (((String)instanceField).isBlank()) {
                    if (!wasOriginallyAccessible)
                        field.setAccessible(true);

                    return true;
                }

                if (!wasOriginallyAccessible)
                    field.setAccessible(false);
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException |
                 ExceptionInInitializerError | NullPointerException | ClassCastException | UnsupportedOperationException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
