package com.lvxiao.jvm.classloader.directmemo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2020/1/3 2:08 下午
 */
public class DirectMemoTest {
    public static void main(String[] args) {
        final int _1M = 1024 * 1024;
        List<ByteBuffer> buffers = new ArrayList<>();
        int count = 1;
        while (true) {
            //会导致 java.lang.OutOfMemoryError: Direct buffer memory
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1M);
            buffers.add(byteBuffer);
            System.out.println(count++);
        }
    }
}
