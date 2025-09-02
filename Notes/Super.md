Java Super Keyword - Complete Interview Notes
1. WHAT IS THE SUPER KEYWORD?
   The super keyword in Java is a reference variable that refers to the immediate parent class object. It's used to access parent class members (variables, methods, constructors) from the child class.
   Key Points:

super is an implicit reference to the parent class
It's automatically available in every child class
Cannot be used in static context (static methods/blocks)
Must be the first statement when calling parent constructor


2. USES OF SUPER KEYWORD
   A) Accessing Parent Class Variables
   B) Calling Parent Class Methods
   C) Calling Parent Class Constructors

3. USE 1: ACCESSING PARENT CLASS VARIABLES
   When child and parent classes have variables with the same name, super helps access the parent's version.
   javaclass Parent {
   int number = 100;
   String name = "Parent";
   }

class Child extends Parent {
int number = 200;  // Same variable name as parent
String name = "Child";

    void displayValues() {
        System.out.println("Child number: " + number);        // 200
        System.out.println("Parent number: " + super.number); // 100
        System.out.println("Child name: " + this.name);       // Child
        System.out.println("Parent name: " + super.name);     // Parent
    }
}
Interview Question: What if parent variable is private?
Answer: super cannot access private variables. You need public getters or protected access.
javaclass Parent {
private int value = 50;
protected int protectedValue = 75;

    public int getValue() {
        return value;
    }
}

class Child extends Parent {
void test() {
// System.out.println(super.value);        // ❌ Cannot access private
System.out.println(super.protectedValue);  // ✅ Can access protected
System.out.println(super.getValue());      // ✅ Can call public method
}
}

4. USE 2: CALLING PARENT CLASS METHODS
   Method Overriding Scenario
   javaclass Animal {
   void makeSound() {
   System.out.println("Animal makes a sound");
   }

   void eat() {
   System.out.println("Animal is eating");
   }
   }

class Dog extends Animal {
@Override
void makeSound() {
super.makeSound();  // Call parent version first
System.out.println("Dog barks");
}

    void showBehavior() {
        makeSound();       // Calls overridden version (Dog's version)
        super.makeSound(); // Calls parent version (Animal's version)
        super.eat();       // Calls parent method (not overridden)
    }
}
Why Use Super for Methods?

Extend functionality rather than completely replace it
Avoid code duplication by reusing parent logic
Maintain parent behavior while adding child-specific features


5. USE 3: CALLING PARENT CLASS CONSTRUCTORS
   Constructor Chaining
   The most important use of super is calling parent constructors.
   javaclass Person {
   String name;
   int age;

   // Default constructor
   Person() {
   System.out.println("Person default constructor");
   }

   // Parameterized constructor
   Person(String name, int age) {
   this.name = name;
   this.age = age;
   System.out.println("Person parameterized constructor");
   }
   }

class Student extends Person {
String studentId;

    // Default constructor
    Student() {
        super();  // Calls Parent() - optional for default constructor
        System.out.println("Student default constructor");
    }
    
    // Parameterized constructor
    Student(String name, int age, String studentId) {
        super(name, age);  // MUST be first statement
        this.studentId = studentId;
        System.out.println("Student parameterized constructor");
    }
}
Constructor Rules:

super() must be the FIRST statement in child constructor
Only one super() call per constructor
If no super() is written, Java automatically adds super() (default constructor)
Compilation error if parent doesn't have default constructor and child doesn't explicitly call parameterized constructor


6. SUPER vs THIS KEYWORD
   AspectsuperthisPurposeRefers to parent classRefers to current classVariable AccessParent class variablesCurrent class variablesMethod AccessParent class methodsCurrent class methodsConstructorParent class constructorCurrent class constructorUsage in Static❌ Not allowed❌ Not allowedMust be firstOnly for constructorsOnly for constructors
   javaclass Example {
   int value = 10;

   Example() {
   this(20);  // Calls parameterized constructor of same class
   }

   Example(int value) {
   super();   // Calls parent constructor
   this.value = value;  // this refers to current object
   }
   }

7. COMMON INTERVIEW SCENARIOS
   Scenario 1: Constructor Chaining Chain
   javaclass GrandParent {
   GrandParent() {
   System.out.println("GrandParent constructor");
   }
   }

class Parent extends GrandParent {
Parent() {
super();  // Calls GrandParent()
System.out.println("Parent constructor");
}
}

class Child extends Parent {
Child() {
super();  // Calls Parent() which calls GrandParent()
System.out.println("Child constructor");
}
}

// Output:
// GrandParent constructor
// Parent constructor  
// Child constructor
Scenario 2: Method Resolution
javaclass A {
void display() {
System.out.println("Class A");
}
}

class B extends A {
void display() {
System.out.println("Class B");
}

    void show() {
        display();       // Calls B's display()
        super.display(); // Calls A's display()
        this.display();  // Calls B's display()
    }
}

8. INTERVIEW QUESTIONS & ANSWERS
   Q1: Can we use super in static methods?
   Answer: No, super cannot be used in static context because static methods belong to the class, not to instances, and super refers to parent instance.
   Q2: What happens if we don't use super() in constructor?
   Answer: Java automatically inserts super() to call parent's default constructor. If parent doesn't have default constructor, compilation error occurs.
   Q3: Can super() and this() be used together in same constructor?
   Answer: No, both must be the first statement, so only one can be used.
   Q4: What if parent and child have same method name but different return types?
   Answer: If return types are incompatible, it's not method overriding, it's a compilation error. If compatible (covariant), super.method() calls parent version.
   Q5: Can we use super.super to access grandparent?
   Answer: No, super.super is not valid syntax. super only refers to immediate parent.

9. PRACTICAL EXAMPLES
   Example 1: Real-world Scenario
   javaclass Vehicle {
   protected String brand;
   protected double price;

   Vehicle(String brand, double price) {
   this.brand = brand;
   this.price = price;
   }

   void start() {
   System.out.println("Vehicle starting...");
   }

   void displayInfo() {
   System.out.println("Brand: " + brand + ", Price: $" + price);
   }
   }

class Car extends Vehicle {
private int doors;

    Car(String brand, double price, int doors) {
        super(brand, price);  // Initialize parent fields
        this.doors = doors;
    }
    
    @Override
    void start() {
        System.out.println("Checking systems...");
        super.start();  // Reuse parent logic
        System.out.println("Car started successfully!");
    }
    
    @Override
    void displayInfo() {
        super.displayInfo();  // Display parent info
        System.out.println("Doors: " + doors);  // Add child-specific info
    }
}
Example 2: Super with Method Overloading
javaclass Calculator {
int add(int a, int b) {
return a + b;
}

    void showResult(int result) {
        System.out.println("Result: " + result);
    }
}

class AdvancedCalculator extends Calculator {
// Overload parent method
int add(int a, int b, int c) {
int twoSum = super.add(a, b);  // Use parent method
return twoSum + c;
}

    @Override
    void showResult(int result) {
        System.out.print("Advanced Calculator - ");
        super.showResult(result);  // Use parent implementation
    }
}

10. COMMON MISTAKES & PITFALLS
    Mistake 1: Using super() in middle of constructor
    javaclass Child extends Parent {
    Child() {
    System.out.println("Some statement");
    super();  // ❌ ERROR: super() must be first statement
    }
    }
    Mistake 2: Multiple super() calls
    javaclass Child extends Parent {
    Child() {
    super();
    super();  // ❌ ERROR: Only one super() call allowed
    }
    }
    Mistake 3: Using super in static context
    javaclass Child extends Parent {
    static void test() {
    super.method();  // ❌ ERROR: Cannot use super in static context
    }
    }
    Mistake 4: Forgetting parent constructor parameters
    javaclass Parent {
    Parent(int value) {  // No default constructor
    // Constructor logic
    }
    }

class Child extends Parent {
Child() {
// ❌ ERROR: Parent doesn't have default constructor
// Must call super(int) explicitly
}
}

11. ADVANCED CONCEPTS
    Super with Abstract Classes
    javaabstract class Shape {
    protected String color;

    Shape(String color) {
    this.color = color;
    }

    abstract double area();

    void display() {
    System.out.println("Color: " + color);
    }
    }

class Circle extends Shape {
private double radius;

    Circle(String color, double radius) {
        super(color);  // Call abstract class constructor
        this.radius = radius;
    }
    
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
    
    @Override
    void display() {
        super.display();  // Call abstract class method
        System.out.println("Area: " + area());
    }
}
Super with Interfaces (Default Methods)
javainterface Drawable {
default void draw() {
System.out.println("Drawing...");
}
}

class Shape implements Drawable {
@Override
public void draw() {
Drawable.super.draw();  // Call interface default method
System.out.println("Shape drawn");
}
}

12. BEST PRACTICES
    When to Use Super:

Constructor chaining - Initialize parent state
Method extension - Add functionality to parent methods
Variable disambiguation - Access parent variables with same name
Code reuse - Leverage parent functionality

When NOT to Use Super:

Overriding completely different logic - Just override without super
Private parent members - Use public methods instead
Static methods - Not applicable
Constructor body - Only in first statement


13. QUICK REFERENCE CHECKLIST
    Key Points for Interviews:

✅ super refers to immediate parent class only
✅ super() must be first statement in constructor
✅ Cannot be used in static context
✅ Used for accessing parent variables, methods, constructors
✅ Different from this which refers to current class
✅ Helps in constructor chaining and method extension
✅ Cannot access private members of parent class
✅ Only one super() call per constructor
✅ If no super() written, Java adds super() automatically
✅ Compilation error if parent has no default constructor and child doesn't call parameterized constructor

Common Interview Red Flags:

❌ Saying super can access grandparent directly
❌ Using super in static methods
❌ Multiple super() calls in constructor
❌ Placing super() after other statements in constructor
❌ Confusing super with this keyword