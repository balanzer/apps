package com.test;

public class BuiltInInterfaceDefault {

    public static void main(String[] args) {

        final Runnable r1 = () -> {
            System.out.println("Running Thread 1 start");
            try {
                Thread.sleep(3000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Running Thread 1 End");
        };

        final Runnable r2 = () -> {
            System.out.println("Running Thread 2 start");
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Running Thread 2 End");
        };

        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();

        new Thread(r2).start();
        new Thread(r2).start();
        new Thread(r2).start();
    }

}
