public class course {
    String name;
    int price;
    //Default constructor
    public course(){
      name = "Unknown course";
      price = 0;
    }
    //single parameterized constructor.
    public course(String name){
        System.out.println(name);//name will get print but the value has not been passed to instance.
        System.out.println("Constructor has been called");
    }
    // Parameterized constructor
    public course(String name, int price){
        this.name = name;
        this.price = price;
    }
    //Method without parameter:
    public void displayInfo(){
        System.out.println("Student has be assigned at "+name+", and the price of the course is "+price);
    }

    //Method where object is being passed
    public void displayInfo(course c1){
        System.out.println("Student has be assigned at "+c1.name+", and the price of the course is "+c1.price);
    }
    public static void main(String[] args) {


        course c0 = new course("Devops");
        System.out.println(c0.name);//it will print null the default value because the value has not be passed to its states
        course c1 = new course();
        c1.displayInfo();

        course c2 = new course("DSA", 5000);
        c2.displayInfo();

        course c3 = new course("Java", 4590);
        c3.displayInfo(c3);
    }
}
/*
* When to use parameterized constructor?
*
*
* */