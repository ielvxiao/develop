package com.lvxiao.reflect;

import com.lvxiao.reflect.domain.ReflectEntry;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-07-16 23:41
 */
public class ReflectTest {
    public static void main(String[] args) {
        ReflectEntry reflectEntry = new ReflectEntry();
        Class c = ReflectEntry.class;
        //2.1 获取所有 public 访问权限的变量
        // 包括本类声明的和从父类继承的
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field.getType().getName());
        }
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        try {
            Method method = c.getDeclaredMethod("test", String.class);
            if (method != null) {
                method.setAccessible(true);
                Object o = method.invoke(reflectEntry, "lvxiao");
                System.out.println(o);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
