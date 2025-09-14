package Advance_Multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int bal = 100000;

    private final ReentrantLock rl = new ReentrantLock();

    public void withdraw(String ThreadName, int amount){
        System.out.println(ThreadName+": is trying to withdraw "+amount);
//        rl.lock(); this is lock it will stop multithreading and will execute thread one by one
        //rl.tryLock() -> This is a method that used to check if lock is free or not if it is free it will
        //take a lock or if no then it will do some other task;
        if(rl.tryLock()){
            rl.lock();
            try{
                System.out.println(ThreadName+" acquired Lock");
                if(bal >= amount){
                    Thread.sleep(2000);
                    bal = bal - amount;
                    System.out.println("withdraw: "+amount+ "remaining: "+ bal);
                }
                else {
                    System.out.println("Insufficient Balance");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                rl.unlock();
            }
        }
        else{
            System.out.println(ThreadName+ " is saying lock is not free now let's do some other task");
        }
    }
}
