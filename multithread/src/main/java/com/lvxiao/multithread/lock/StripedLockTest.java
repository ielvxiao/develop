package com.lvxiao.multithread.lock;

import com.google.common.util.concurrent.Striped;
import lombok.Data;

import java.util.concurrent.locks.Lock;

/**
 * @author lvxiao
 * @date 2020/5/9
 */
@Data
class Bag{
    private int id;
    private String name;
}
public class StripedLockTest {
    //锁的总数量
    private Striped<Lock> striped = Striped.lock(10);

    private void update(Bag bag) {
        //根据id获取锁
        Lock lock = striped.get(bag.getId());
        lock.lock();
        if (bag.getId() % 2 == 0) {
            bag.setName("update");
        }
        lock.unlock();
    }
}
