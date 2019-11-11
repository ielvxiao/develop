package com.lvxiao.reflect.bytecode.javassist;

import com.lvxiao.reflect.bytecode.asm.Base;
import javassist.*;

import java.io.IOException;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/11/11 4:51 下午
 */
public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.lvxiao.reflect.bytecode.asm.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile(".");
        Base base = (Base) c.newInstance();
        base.process();
    }
}
