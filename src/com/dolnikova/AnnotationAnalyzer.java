package com.dolnikova;

import java.lang.reflect.Field;
import java.util.Map;

public class AnnotationAnalyzer {

    public AnnotationAnalyzer() {
    }

    public void analyze(Map<String, String> map, Class<?> myClass) {
        if (myClass == User.class) {
            User user = new User();

            Field[] fields = user.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {

                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();

                    if (fields[i].isAnnotationPresent(Column.class)) {
                        Column column = fields[i].getAnnotation(Column.class);
                        String type = column.info();
                        if (key.equals(type)) {
                            setField(user, map, fields[i].getName(), key);
                            break;
                        }
                        continue;
                    } else {
                        if (fields[i].getName().equals(key)) {
                            setField(user, map, key, key);
                            break;
                        }
                        continue;
                    }
                }
            }

            System.out.println(user);
        }

    }

    private void setField(User user, Map<String, String> map, String name, String key) {
        try {
            Field field = user.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(user, map.get(key));
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

