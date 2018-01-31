package com.ghb.tthread;

import java.util.concurrent.Exchanger;

public class Bike extends Thread {
    private Exchanger<String> exchanger;

    public Bike(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": " + exchanger.exchange("Bike"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}