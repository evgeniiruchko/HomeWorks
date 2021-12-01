package ru.GeekBrains.gb.repetition.threads;

public class Pong implements Runnable{
    PingPong p;
    final int count;

    public Pong(PingPong pong, int count) {
        this.p = pong;
        this.count = count;
        //new Thread(this, "pong").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            p.pong();
        }
    }
}
