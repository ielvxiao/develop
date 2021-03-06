package com.lvxiao.multithread.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer 的设计核心是一个 TaskList 和一个 TaskThread。Timer 将接收到的任务丢到自己的 TaskList 中，TaskList 按照 Task 的最初执行时间进行排序。
 * TimerThread 在创建 Timer 时会启动成为一个守护线程。这个线程会轮询所有任务，找到一个最近要执行的任务，然后休眠，当到达最近要执行任务的开始时间点，TimerThread 被唤醒并执行该任务。
 * 之后 TimerThread 更新最近一个要执行的任务，继续休眠。
 * Timer 的优点在于简单易用，但由于所有任务都是由同一个线程来调度，因此所有任务都是串行执行的，同一时间只能有一个任务在执行，前一个任务的延迟或异常都将会影响到之后的任务。
 * @author lvxiao
 * @date 2020/7/17
 */
public class TimerTest extends TimerTask {

    @Override
    public void run() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
    }

    public static void main(String[] args) {
        Timer timer = new Timer("lvxiao-timer");
        timer.schedule(new TimerTest(), 5000, 1000);
    }
}
