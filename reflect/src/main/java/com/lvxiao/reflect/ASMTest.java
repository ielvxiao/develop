package com.lvxiao.reflect;

import com.esotericsoftware.reflectasm.MethodAccess;
import com.lvxiao.reflect.domain.ReflectEntry;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Method;

/**
 * @author lvxiao
 * @date 2019/5/24
 */
@Log4j2
public class ASMTest {
    public static void main(String[] args) throws Exception{
        ReflectEntry entry = new ReflectEntry();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            entry.setId(i);
        }
        long mid = System.currentTimeMillis();
        log.error("执行直接调用方法耗时：{}ms", mid - begin);
        MethodAccess access = MethodAccess.get(ReflectEntry.class);
        long mid1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            access.invoke(entry, "setId", i);
        }
        long end = System.currentTimeMillis();
        log.error("执行ASM反射调用法耗时：{}ms", end - mid1);
        Method method = entry.getClass().getMethod("setId", Integer.class);
        long end1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            method.invoke(entry, i);
        }
        long end2 = System.currentTimeMillis();
        log.error("执行JDK反射调用法耗时：{}ms", end2 - end1);
    }
}
