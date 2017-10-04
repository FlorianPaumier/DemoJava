package com.tactfactory.demo1.thread;

public class DemoThread {
    static boolean isRunnable = true;

    public static class Process implements Runnable {
        int i = 0;

        @Override
        public void run() {
            System.out.println("Sub Thread Id : "
                    + Thread.currentThread().getId());

            while (true) {
                System.out.println(String.format("My Thread %d run !", Thread.currentThread().getId()));

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ++i;

                if (i > 10) {
                    isRunnable = false;
                }

                if (i > 5) {
                    throw new RuntimeException();
                }
            }
        }
    }


    public static void run() {
        System.out.println("Main Thread Id : "
                            + Thread.currentThread().getId());

        Thread subThread1 = new Thread(new Process());
        subThread1.start();

        Thread subThread2 = new Thread(new Process());
        subThread2.start();

        while (isRunnable) {
            System.out.println(String.format("My Thread %d run !", Thread.currentThread().getId()));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
