package ru.GeekBrains.gb.repetition.threads;

public class PingPong{
    boolean flag = true;

    synchronized void ping() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ping");
        flag = false;
        notify();
    }

    synchronized void pong() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("pong");
        flag = true;
        notify();
    }
}
