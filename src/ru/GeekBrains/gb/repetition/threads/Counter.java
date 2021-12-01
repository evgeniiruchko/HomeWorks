package ru.GeekBrains.gb.repetition.threads;

import javax.sound.sampled.FloatControl;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable{
    private static int max;
    private static int count = 1;
    private static final Lock lock = new ReentrantLock(true);

    public Counter(int max) {
        Counter.max = max;
    }

    static void incrementCounter() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " - " + count);
        count++;
        lock.unlock();
    }

    @Override
    public void run() {
        while (count <= max) {
            incrementCounter();
            Thread.yield();
        }
    }
}
