public class ConstructorDemo {
    public static void main(String[] args){
        System.out.println("=== Constructor Chaining Demo ===\n");
        
        // Default constructor - chains to full parameterized constructor
        System.out.println("1. Creating student with default constructor:");
        Student s1 = new Student();
        s1.displayinfo();
        Student.address("N/A");
        
        System.out.println("\n2. Creating student with name only:");
        Student s2 = new Student("Alice");
        s2.displayinfo();
        Student.address("Mumbai");
        
        System.out.println("\n3. Creating student with name and age:");
        Student s3 = new Student("Bob", 22);
        s3.displayinfo();
        Student.address("Bangalore");
        
        System.out.println("\n4. Creating student with name, age, and rollno:");
        Student s4 = new Student("Charlie", 21, 101);
        s4.displayinfo();
        Student.address("Chennai");
        
        System.out.println("\n5. Creating student with all parameters:");
        Student s5 = new Student("Diana", 20, 102, "M.Tech");
        s5.displayinfo();
        Student.address("Delhi");
    }
}

class Student{
    String name;
    int age;
    int rollno;
    String course;

    //Default constructor - calls parameterized constructor using this()
    Student(){
       this("Unknown", 0, 0, "Not-Assigned"); // Constructor chaining using this()
    }
    
    //Constructor with name only - chains to full parameterized constructor
    Student(String name){
        this(name, 0, 0, "Not-Assigned"); // Constructor chaining
    }
    
    //Constructor with name and age - chains to full parameterized constructor
    Student(String name, int age){
        this(name, age, 0, "Not-Assigned"); // Constructor chaining
    }
    
    //Constructor with name, age, and rollno - chains to full parameterized constructor
    Student(String name, int age, int rollno){
        this(name, age, rollno, "Not-Assigned"); // Constructor chaining
    }
    
    //Full parameterized constructor - the main constructor that does actual initialization
    Student(String name, int age, int rollno, String course){
        this.name = name;     // this keyword to refer to instance variable
        this.age = age;
        this.rollno = rollno;
        this.course = course;
        System.out.println("Full parameterized constructor called for: " + name);
    }
    public void displayinfo(){ 
        System.out.println("Name: "+name+", Age: "+age+", Rollno: "+rollno+", Course: "+course);
    }
    public static void address(String address){
         System.out.println("Address: "+address);
    }
}

/*
=== PROGRAM LOGIC AND TASKS DEMONSTRATED ===

1. CONSTRUCTOR CHAINING USING 'this()' KEYWORD:
   - Multiple constructors are created with different parameter combinations
   - Each constructor calls another constructor using this() to avoid code duplication
   - All constructors ultimately chain to the main parameterized constructor
   - this() must be the first statement in a constructor
   - Benefits: Code reusability, consistent initialization, maintainable code

2. CONSTRUCTOR OVERLOADING:
   - Same constructor name with different parameter lists
   - Provides flexibility in object creation
   - Allows users to create objects with varying levels of detail

3. 'this' KEYWORD FOR INSTANCE VARIABLE REFERENCE:
   - Used to distinguish between parameter names and instance variables
   - this.name refers to instance variable, name refers to parameter
   - Resolves naming conflicts when parameter and field have same name

4. STATIC METHOD DEMONSTRATION:
   - address() method is static, belongs to class not instance
   - Can be called using class name without creating object
   - Demonstrates difference between instance and class methods

5. OBJECT-ORIENTED CONCEPTS COVERED:
   - Encapsulation: Private data with public methods
   - Constructor overloading
   - Method overloading concept
   - Static vs instance members

6. PROGRAM FLOW:
   - Creates 5 different Student objects using different constructors
   - Each constructor call demonstrates constructor chaining
   - Shows how default values are assigned when parameters are not provided
   - Displays student information and addresses

7. KEY LEARNING OUTCOMES:
   - Understanding constructor chaining reduces code duplication
   - this() enables calling one constructor from another
   - this. helps resolve naming conflicts
   - Static methods belong to class, not instances
   - Constructor overloading provides flexible object creation options

8. BEST PRACTICES DEMONSTRATED:
   - Single point of initialization (main parameterized constructor)
   - Consistent default value assignment
   - Clear separation of concerns
   - Proper use of static methods for utility functions
*/
