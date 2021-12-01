package ru.GeekBrains.gb.repetition.threads;

public class Ping implements Runnable{
    PingPong p;
    final int count;

    public Ping(PingPong ping, int count) {
        this.p = ping;
        this.count = count;
        //new Thread(this, "ping").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            p.ping();
        }
    }
}
