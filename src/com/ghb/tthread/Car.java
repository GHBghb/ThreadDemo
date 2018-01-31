package com.ghb.tthread;

import java.util.concurrent.Exchanger;

public class Car extends Thread {
    private Exchanger<String> exchanger;

    public Car(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": " + exchanger.exchange("Car"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}