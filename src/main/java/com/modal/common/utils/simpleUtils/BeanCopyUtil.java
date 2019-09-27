package com.modal.common.utils.simpleUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class BeanCopyUtil {

    /**
     * 源数据字段集合
     */
    private List<String> sourceFields;

    /**
     * 目标数据字段集合
     */
    private List<String> targetFields;

    private static BeanCopyUtil bean = null;

    private BeanCopyUtil(){
    }

    /**
     * 获取对象
     *
     */
    public static BeanCopyUtil getInstance() {
        if (bean == null) {
            bean = new BeanCopyUtil();
        }
        return bean;
    }

    /**
     * 执行复制，为空或者源数据无该字段则不复制
     *
     */
    public void copy(Object source, Object target) throws Exception {
        sourceFields = getFieldName(source);
        targetFields = getFieldName(target);
        targetFields.forEach((sf) -> {
            try {
                // 如果源数据有该字段，则复制
                if(isHasField(sf)) {
                    String firstLetter = sf.substring(0, 1).toUpperCase();
                    String setter = "set" + firstLetter + sf.substring(1);
                    Method method = null;
                    try {
                        method = source.getClass().getMethod(setter, getFieldType(sf, source.getClass()));
                    } catch (NoSuchFieldException e) {
                        method = source.getClass().getSuperclass().getMethod(setter, getFieldType(sf, source.getClass().getSuperclass()));
                    }
                    if (target instanceof Map) {
                        Map map = (Map) target;
                        // 目标字段值不为空时执行
                        if (map.get(sf) != null) {
                            method.invoke(source, map.get(sf));
                        }
                    } else {
                        // 目标字段值不为空时执行
                        if (getFieldValueByName(sf, target) != null) {
                            method.invoke(source, getFieldValueByName(sf, target));
                        }
                    }
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 判断源数据是否有该字段
     *
     */
    private boolean isHasField(String field) {
        return sourceFields.contains(field);
    }

    /**
     * 获取对象所有字段
     *
     */
    private List<String> getFieldName(Object o){
        // 如果目标数据源为map则执行
        if (o instanceof Map) {
            Map o1 = (Map) o;
            return new ArrayList<>(o1.keySet());
        }
        List<String> fieldNames = new ArrayList<>();

        List<Field> fields = Arrays.asList(o.getClass().getDeclaredFields());
        List<Field> superFields = Arrays.asList(o.getClass().getSuperclass().getDeclaredFields());
        fields.forEach((obj) -> {
            fieldNames.add(String.valueOf(obj.getName()));
        });
        superFields.forEach((obj) -> {
            fieldNames.add(String.valueOf(obj.getName()));
        });
        return fieldNames;
    }

    /**
     * 根据字段名，获取字段类型
     *
     */
    private Class<?> getFieldType(String fieldName, Class clazz) throws NoSuchFieldException {
        return clazz.getDeclaredField(fieldName).getType();
    }

    /**
     * 根据字段名获取字段值
     *
     */
    private Object getFieldValueByName(String fieldName, Object o) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
