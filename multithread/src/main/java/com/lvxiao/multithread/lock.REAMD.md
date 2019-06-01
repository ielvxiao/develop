# Package java.util.concurrent.locks Description
Interfaces and classes providing a framework for locking and waiting for conditions that is distinct from built-in synchronization and monitors. The framework permits much greater flexibility in the use of locks and conditions, at the expense of more awkward syntax.
The Lock interface supports locking disciplines that differ in semantics (reentrant, fair, etc), and that can be used in non-block-structured contexts including hand-over-hand and lock reordering algorithms. The main implementation is ReentrantLock.

The ReadWriteLock interface similarly defines locks that may be shared among readers but are exclusive to writers. Only a single implementation, ReentrantReadWriteLock, is provided, since it covers most standard usage contexts. But programmers may create their own implementations to cover nonstandard requirements.

The Condition interface describes condition variables that may be associated with Locks. These are similar in usage to the implicit monitors accessed using Object.wait, but offer extended capabilities. In particular, multiple Condition objects may be associated with a single Lock. To avoid compatibility issues, the names of Condition methods are different from the corresponding Object versions.

The AbstractQueuedSynchronizer class serves as a useful superclass for defining locks and other synchronizers that rely on queuing blocked threads. The AbstractQueuedLongSynchronizer class provides the same functionality but extends support to 64 bits of synchronization state. Both extend class AbstractOwnableSynchronizer, a simple class that helps record the thread currently holding exclusive synchronization. The LockSupport class provides lower-level blocking and unblocking support that is useful for those developers implementing their own customized lock classes.

## AbstractOwnableSynchronizer接口
官方文档描述，一句话解决问题，他的作用就是:A synchronizer that may be exclusively owned by a thread.
实现类：<br/>
AbstractQueuedLongSynchronizer, AbstractQueuedSynchronizer
### AbstractQueuedSynchronizer
- 作用：Provides a framework for implementing blocking locks and related synchronizers (semaphores, events, etc) that rely on first-in-first-out (FIFO) wait queues.
- 内部原理：This class is designed to be a useful basis for most kinds of synchronizers that rely on a single atomic int value to represent state. Subclasses must define the protected methods that change this state, and which define what that state means in terms of this object being acquired or released. Given these, the other methods in this class carry out all queuing and blocking mechanics. Subclasses can maintain other state fields, but only the atomically updated int value manipulated using methods getState(), setState(int) and compareAndSetState(int, int) is tracked with respect to synchronization.
实现细节：<br/>
通过一个"CLH"队列，如下图

           +------+  prev +-----+       +-----+
      head |      | <---- |     | <---- |     |  tail
           +------+       +-----+       +-----+
waitStatus的状态变化:
1. 线程刚入 Sync Queue 里面, 发现 独占锁被其他人获取, 则将其前继节点标记为 SIGNAL, 然后再尝试获取一下锁(调用 tryAcquire 方法)
2. 若 调用 tryAcquire 方法获取失败, 则判断一下是否前继节点被标记为 SIGNAL, 若是的话 直接 block(block前会确保前继节点被标记为SIGNAL, 因为前继节点在进行释放锁时根据是否标记为 SIGNAL 来决定唤醒后继节点与否 <- 这是独占的情况下)
3. 前继节点使用完lock, 进行释放, 因为自己被标记为 SIGNAL, 所以唤醒其后继节点
waitStatus 变化过程:
1. 独占模式下:  0(初始) -> signal(被后继节点标记为release需要唤醒后继节点) -> 0 (等释放好lock, 会恢复到0)
2. 独占模式 + 使用 Condition情况下: 0(初始) -> signal(被后继节点标记为release需要唤醒后继节点) -> 0 (等释放好lock, 会恢复到0)
   其上可能涉及 中断与超时, 只是多了一个 CANCELLED, 当节点变成 CANCELLED, 后就等着被清除
3. 共享模式下: 0(初始) -> PROPAGATE(获取 lock 或release lock 时) (获取 lock 时会调用 setHeadAndPropagate 来进行 传递式的唤醒后继节点, 直到碰到 独占模式的节点)
4. 共享模式 + 独占模式下: 0(初始) -> signal(被后继节点标记为release需要唤醒后继节点) -> 0 (等释放好lock, 会恢复到0)
其上的这些状态变化主要在: doReleaseShared , shouldParkAfterFailedAcquire 里面

protected final boolean compareAndSetState(int expect,int update)是原子操作

# Locks源码解读
![lock代码](sources/img/162f769475d5e980.jpg)

## 可以简单概括一下：

- Lock方式来获取锁支持中断、超时不获取、是非阻塞的
- 提高了语义化，哪里加锁，哪里解锁都得写出来
- Lock显式锁可以给我们带来很好的灵活性，但同时我们必须手动释放锁
- 支持Condition条件对象
- 允许多个读线程同时访问共享资源

Lock接口提供了几种获取和释放锁的方式。
实现这个接口的类有：<br/>
ReentrantLock, ReentrantReadWriteLock.ReadLock, ReentrantReadWriteLock.WriteLock
