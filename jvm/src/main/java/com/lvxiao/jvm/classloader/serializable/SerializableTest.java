package com.lvxiao.jvm.classloader.serializable;

import com.lvxiao.jvm.classloader.domain.User;

import java.io.*;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/20 5:01 下午
 */
public class SerializableTest {

    private static String fileDir = "/Users/lvxiao/Desktop/user.txt";
    public static void writeObject() {
        User user = new User(1, "吕啸");
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileDir))){
            stream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将类从文本中提取并赋值给内存中的类
     */
    public static void readObj() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileDir));
            try {
                Object object = objectInputStream.readObject();
                User user = (User) object;
                System.out.println(user);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        writeObject();
        readObj();
    }
}
