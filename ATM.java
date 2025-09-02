public class ATM {
    //instance has been set as private so, it will not be access to other class.
    private String name;
    private double balance;

    //using constructor to set the variables
    //Note can also be used set method to set the variables depends on how you one to. here constructor is used.
    ATM(String name, int balance){
        this.name = name;
        this.balance = balance;
    }
    //this method is used to show balance also get be called as get method to get the balance;
   void showBalance(){
       System.out.println("Account name: "+name);
       System.out.println("Your account balance is: "+balance);
   }
    public static void main(String[] args) {
          ATM atm1 = new ATM("Pankaj", 100000);
          atm1.showBalance();
          //A test class has been created to test the Encapsulation and is the working fine as test class can only see the
        // value cannot modify it.
    }
}
