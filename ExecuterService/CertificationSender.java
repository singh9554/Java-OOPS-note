package ExecuterService;

public class CertificationSender implements Runnable{
    private final String stdName;
   public CertificationSender(String stdName){
       this.stdName = stdName;
   }
    @Override
    public void run() {
        System.out.println("Sending Certificate to: "+stdName+" by "+ Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Certificate has been sent successfully to: "+stdName+" by "+ Thread.currentThread().getName());
        }
    }
}
