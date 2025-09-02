The Key Point: Static methods cannot access instance variables AT ALL
Static methods cannot access instance variables in any direct way - not even by calling methods directly.
Here's why and what the solutions are:

Why Static Methods Can't Access Instance Variables:

-> Static methods belong to the CLASS, not to any specific object
-> Instance variables belong to OBJECTS, not to the class
-> Static methods are loaded when the class is loaded, before any objects are created

What This Means:
javaclass Example {
    // Instance variable
    private int instanceVar = 10;
    
    // Static method - CANNOT do this:
    public static void staticMethod() {
        // System.out.println(instanceVar); // ❌ COMPILATION ERROR!
        // this.instanceVar = 20;           // ❌ COMPILATION ERROR!
    }
}
Solutions to Access Instance Variables from Static Methods:
1. Create an Object Instance (Most Common)
javaclass Student {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Instance method
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    // Static method accessing instance variables via object
    public static void printStudentInfo() {
        // Create object to access instance variables
        Student student = new Student("John", 20);
        System.out.println("Student name: " + student.name); // Access via object
        student.displayInfo(); // Call instance method via object
    }
}
2. Pass Object as Parameter
javaclass Calculator {
    private int value1;
    private int value2;
    
    public Calculator(int v1, int v2) {
        this.value1 = v1;
        this.value2 = v2;
    }
    
    // Static method that takes object as parameter
    public static int addNumbers(Calculator calc) {
        return calc.value1 + calc.value2; // Access via passed object
    }
    
    public static void main(String[] args) {
        Calculator calc = new Calculator(10, 20);
        int result = Calculator.addNumbers(calc); // Pass object to static method
        System.out.println("Result: " + result);
    }
}
3. Pass Values as Parameters (What you mentioned)
javaclass MathUtils {
    private int baseValue = 5; // Instance variable
    
    // Static method taking values as parameters
    public static int multiply(int a, int b) {
        return a * b; // Works with parameters, not instance variables
    }
    
    // Instance method to bridge the gap
    public int multiplyWithBase(int number) {
        return multiply(baseValue, number); // Pass instance variable as parameter
    }
}
4. Use Static Variables Instead (If Appropriate)
javaclass Counter {
    // Static variable - accessible from static methods
    private static int count = 0;
    
    // Static method can access static variables
    public static void increment() {
        count++; // ✅ This works!
    }
    
    public static int getCount() {
        return count; // ✅ This works!
    }
}

/*
KEY TAKEAWAYS:

1. WHAT STATIC METHODS CAN ACCESS:
   ✅ Static variables
   ✅ Static methods
   ✅ Local variables within the method
   ✅ Parameters passed to the method

2. WHAT STATIC METHODS CANNOT ACCESS:
   ❌ Instance variables directly
   ❌ Instance methods directly
   ❌ 'this' keyword
   ❌ 'super' keyword

3. WHY THIS RESTRICTION EXISTS:
    - Static methods are loaded with the class
    - Instance variables don't exist until objects are created
    - Static methods must work without any object instances

4. COMMON INTERVIEW MISTAKES:
    - Thinking you can just "pass the value" - you need an object reference
    - Forgetting that static methods can't use 'this'
    - Not understanding the fundamental difference between class-level and object-level

5. REAL-WORLD USAGE:
    - Utility methods (Math.max, Arrays.sort)
    - Factory methods
    - Main method
    - Helper methods that don't need object state
      */