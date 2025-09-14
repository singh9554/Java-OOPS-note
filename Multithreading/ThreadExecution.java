package Multithreading;

public class ThreadExecution {
    public static void main(String[] args) {
        System.out.println("Jvm revoked the main thread");
        YieldExample yi = new YieldExample();
        yi.start();
        for (int i = 0; i < 10; i++){
            System.out.println("Main Thread is running");
        }
    }

    static class YieldExample extends Thread {
        @Override
        public void run() {
            System.out.println("Yield Thread Example started to demonstrate");
            for (int i = 0; i < 10; i++) {
                System.out.println("Yield thread started running and will Yield and again get run");
            }
            System.out.println("Yield Thread Stopped");
            Thread.yield();
        }
    }
}
/*
* Note:  In the above program child Thread always calling yield() method and hence main,
Thread will get the chance more number of times for execution.
Hence the chance of completing the main Thread first is high.
Note : Some operating systems may not provide proper support for yield() method.
*/