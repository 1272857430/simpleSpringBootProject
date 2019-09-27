package com.modal.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by 170096 on 2018/9/7
 */
@SuppressWarnings("unused")
public class BeanCopyUtil extends BeanUtils {

    private static final transient Logger log = Logger.getLogger(BeanCopyUtil.class);

    public BeanCopyUtil() {
    }

    public static void copyProperties(Object source, Object target, String... ignoreProperties) throws BeansException {
        copyProperties(source, target, Boolean.valueOf(true), ignoreProperties);
    }

    public static void copyProperties(Object source, Object target) throws BeansException {
        copyProperties(source, target, Boolean.valueOf(true), (String[])null);
    }

    public static void copyProperties(Object source, Object target, Boolean isIgnoreNull, String... ignoreProperties) throws BeansException {
        copyProperties(source, target, (Class)null, isIgnoreNull, ignoreProperties);
    }

    private static void copyProperties(Object source, Object target, Class<?> editable, Boolean isIgnoreNull, String... ignoreProperties) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();

        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = ignoreProperties != null? Arrays.asList(ignoreProperties):null;
        PropertyDescriptor[] var8 = targetPds;
        int var9 = targetPds.length;

        for(int var10 = 0; var10 < var9; ++var10) {
            PropertyDescriptor targetPd = var8[var10];
            Method writeMethod = targetPd.getWriteMethod();
            if(writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if(sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if(readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if(!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }

                            Object value = readMethod.invoke(source, new Object[0]);
                            if(!isIgnoreNull.booleanValue() || value != null) {
                                if(!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                    writeMethod.setAccessible(true);
                                }

                                writeMethod.invoke(target, new Object[]{value});
                            }
                        } catch (Throwable var16) {
                            throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", var16);
                        }
                    }
                }
            }
        }

    }

    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap();
        if(bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            Iterator var3 = beanMap.keySet().iterator();

            while(var3.hasNext()) {
                Object key = var3.next();
                map.put(key + "", beanMap.get(key));
            }
        }

        return map;
    }

    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    public static <T> T mapToBeanFromOracle(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(casePropertyName(map));

        return bean;
    }

    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = new ArrayList();
        Map<String, Object> map = null;
        T bean = null;
        int i = 0;

        for(int size = objList.size(); i < size; ++i) {
            bean = objList.get(i);
            map = beanToMap(bean);
            list.add(map);
        }

        return list;
    }

    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList();
        if(maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            int i = 0;

            for(int size = maps.size(); i < size; ++i) {
                map = (Map)maps.get(i);
                bean = clazz.newInstance();
                mapToBean(map, bean);
                list.add(bean);
            }
        }

        return list;
    }

    public static <T> List<T> mapsToObjectsFromOracle(List<Map<String, Object>> maps, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList();
        if(maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            int i = 0;

            for(int size = maps.size(); i < size; ++i) {
                map = (Map)maps.get(i);
                bean = clazz.newInstance();
                mapToBeanFromOracle(map, bean);
                list.add(bean);
            }
        }

        return list;
    }

    private static Map<String, Object> casePropertyName(Map<String, Object> src) {
        Map<String, Object> map = new HashMap();
        Iterator var2 = src.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            map.put(getPropertyName(key), src.get(key));
        }

        return map;
    }

    private static String getPropertyName(String columnName) {
        String columnName_ = columnName.toLowerCase();
        StringBuilder sb = new StringBuilder();
        boolean match = false;

        for(int i = 0; i < columnName_.length(); ++i) {
            char ch = columnName_.charAt(i);
            if(match && ch >= 97 && ch <= 122) {
                ch = (char)(ch - 32);
            }

            if(ch != 95) {
                match = false;
                sb.append(ch);
            } else {
                match = true;
            }
        }

        return sb.toString();
    }
}
