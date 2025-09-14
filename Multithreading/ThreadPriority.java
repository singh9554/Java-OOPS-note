package Multithreading;
class Running implements Runnable{
    @Override
    public void run() {
        System.out.println("This thread is running to make understand the Thread priority");
        for(int i = 0; i < 10; i++){
            System.out.println("The Thread is running fine");
        }
        System.out.println("The Thread has stopped running");
    }
}
public class ThreadPriority {
    public static void main(String[] args) {
        /*
        * By Default only main thread have the priority of 5, Rest all the Thread will inheritance the priority from its
        * parent class, means the priority there parents have by default will be there same
        * hence, we can set the priority of each Thread by using the Method setPriority();
        * */
        System.out.println("Main Thread priority "+ Thread.currentThread().getPriority());

       Thread thread1 = new Thread(new Running(),"Thread1");
       Thread thread2 = new Thread(new Running(),"Thread2");

       //Set the priority of the Thread;
       thread1.setPriority(Thread.MIN_PRIORITY);
       thread2.setPriority(Thread.MAX_PRIORITY);
       //Starting the Thread;
        thread1.start();
        thread2.start();

    }
}
