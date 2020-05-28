package com.lvxiao.redis.crc16;

import org.redisson.connection.CRC16;

/**
 * Redis集群槽位分配采用CRC16算法，返回的16位二进制数中的14位会被使用，16384是2的15次方，可以均匀的分配槽位
 * @author lvxiao
 * @date 2020/5/28
 */
public class Crc16Test {
    public static void main(String[] args) {
        System.out.println(CRC16.crc16("123456789".getBytes()) % 16384);
    }
}
