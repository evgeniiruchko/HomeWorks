package ru.GeekBrains.gb.repetition.threads;

public class Main {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Thread ping = new Thread(new Ping(pingPong, 50));
        Thread pong = new Thread(new Pong(pingPong, 50));
        try {
            ping.start();
            pong.start();
            ping.join();
            pong.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Ping(pingPong);
//        new Pong(pingPong);

        
        Counter counter = new Counter(500);
        new Thread(counter).start();
        new Thread(counter).start();
        new Thread(counter).start();
        new Thread(counter).start();

    }
}
