public class StaticKeyword {
//    int num; non-static method cannot get access to static variable directly.
//    int num2;
     static int num;
    static int num2;

    static void number(){
//        this.num = num --> Static methods cannot access instance variables directly
//        System.out.println(num);//compilation Error cannot access instance variable directly
        // To access class variable in a static method need to assign the variable as static.
        num = 2;
        num2 = 3;
        System.out.println(num + num2);

    }
    public static void main(String[] args) {
      StaticKeyword st = new StaticKeyword();

      st.number();
    }
}
/*
* The Key Point: Static methods cannot access instance variables AT ALL
Static methods cannot access instance variables in any direct way - not even by calling methods directly. Here's why and what the solutions are:
Why Static Methods Can't Access Instance Variables:

Static methods belong to the CLASS, not to any specific object
Instance variables belong to OBJECTS, not to the class
Static methods are loaded when the class is loaded, before any objects are created
* */
