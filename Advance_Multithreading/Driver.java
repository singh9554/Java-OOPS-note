package Advance_Multithreading;

public class Driver {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable t1 = ()->account.withdraw("Wifey",2000);
        Runnable t2 = ()-> account.withdraw("Papa", 3000);
        Runnable t3 = ()-> account.withdraw("Mummy", 5000);

        new Thread(t1).start(); // remember no thread will be call in class level need to call thread in method
        new Thread(t2).start();
        new Thread(t3).start();
    }

}
