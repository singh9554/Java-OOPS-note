package Multithreading;

class Exception extends Thread{
    @Override
    public void run() {
        System.out.println("The Thread has started to run");
        for(int i = 0; i < 5; i++){
            System.out.println("Running Thread");
        }
        System.out.println("The Thread has stop to run");
    }
}

public class Threading {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("The main method starts here");
           Exception ex = new Exception();
           Exception ex2 = new Exception();
        System.out.println("The name of my thread is "+ ex.getName());
        ex.setName("MyThread");
        String getName = ex.getName();
        System.out.println("The new name of my thread "+ getName);
           ex.start();
           ex2.start();

           for(int i = 0; i < 5; i++){
               System.out.println("Main method is getting executed");
           }

    }
}
