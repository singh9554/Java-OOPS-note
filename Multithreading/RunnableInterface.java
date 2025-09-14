package Multithreading;

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("The run method of Runnable interface started running");
        for (int i = 0; i < 6; i++){
            System.out.println("Thread started running");
        }
        System.out.println("Thread Stopped Running");
    }
}
public class RunnableInterface {
    public static void main(String[] args) {
        System.out.println("The main Thread started execution");
          Thread thread = new Thread(new MyRunnable());
          Thread thread1 = new Thread(new MyRunnable());
        System.out.println("Thread is being created");
          thread.start();
        System.out.println("second Thread is being created");
          thread1.start();

        for (int i = 0; i < 10; i++){
            System.out.println("Main Thread is running fine");
        }
    }
}
