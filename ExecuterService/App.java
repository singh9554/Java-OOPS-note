package ExecuterService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(8);
        String[]arr = {"Amit", "Priya", "Rahul", "Sneha", "Vikram", "Neha", "Arjun", "Kiran", "Rohit", "Anjali", "Siddharth", "Pooja"
        };

        for(String Student: arr){
            CertificationSender task = new CertificationSender(Student);
            service.submit(task);
        }
        service.shutdown();
    }
}
