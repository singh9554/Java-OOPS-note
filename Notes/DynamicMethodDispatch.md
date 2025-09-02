Dynamic Method Dispatch - Complete Guide
1. WHAT IS DYNAMIC METHOD DISPATCH?
   Dynamic Method Dispatch is the mechanism by which Java determines which method to call at runtime based on the actual object type, not the reference type. It's the foundation of Runtime Polymorphism in Java.
   Key Points:

Also called Runtime Polymorphism or Late Binding
Method selection happens during program execution, not compilation
Enables "one interface, multiple implementations"
Only works with overridden methods (not overloaded methods)


2. HOW IT WORKS
   java// Parent reference can point to child objects
   Parent ref = new Child();  // Legal in Java
   ref.method();  // Which method gets called? Child's method!
   The Process:

Compile Time: Compiler checks if method exists in reference type
Runtime: JVM checks actual object type and calls appropriate method
Method Resolution: JVM searches from actual object's class upward in inheritance hierarchy


3. BASIC EXAMPLE
   javaclass Animal {
   void makeSound() {
   System.out.println("Animal makes a sound");
   }
   }

class Dog extends Animal {
@Override
void makeSound() {
System.out.println("Dog barks: Woof!");
}
}

class Cat extends Animal {
@Override
void makeSound() {
System.out.println("Cat meows: Meow!");
}
}

// Dynamic Method Dispatch in action
public class Demo {
public static void main(String[] args) {
Animal animal1 = new Dog();  // Parent reference, Child object
Animal animal2 = new Cat();  // Parent reference, Child object
Animal animal3 = new Animal(); // Parent reference, Parent object

        animal1.makeSound(); // Output: Dog barks: Woof!
        animal2.makeSound(); // Output: Cat meows: Meow!
        animal3.makeSound(); // Output: Animal makes a sound
        
        // Method called depends on ACTUAL OBJECT, not reference type
    }
}

4. COMPREHENSIVE EXAMPLE
   javaclass Shape {
   void draw() {
   System.out.println("Drawing a generic shape");
   }

   void area() {
   System.out.println("Calculating generic area");
   }
   }

class Circle extends Shape {
@Override
void draw() {
System.out.println("Drawing a Circle");
}

    @Override
    void area() {
        System.out.println("Area = π × r²");
    }
    
    // Child-specific method (not in parent)
    void circumference() {
        System.out.println("Circumference = 2 × π × r");
    }
}

class Rectangle extends Shape {
@Override
void draw() {
System.out.println("Drawing a Rectangle");
}

    @Override
    void area() {
        System.out.println("Area = length × width");
    }
}

public class DynamicDispatchDemo {
public static void main(String[] args) {
// Array of parent references pointing to different child objects
Shape[] shapes = {
new Circle(),
new Rectangle(),
new Shape()
};

        // Dynamic method dispatch in loop
        for (Shape shape : shapes) {
            shape.draw();  // Calls appropriate overridden method
            shape.area();  // Calls appropriate overridden method
            System.out.println("---");
        }
        
        // What about child-specific methods?
        Shape circle = new Circle();
        circle.draw();  // ✅ Works - method exists in parent
        // circle.circumference();  // ❌ Compilation error - method not in parent
        
        // To call child-specific method, need casting
        ((Circle) circle).circumference();  // ✅ Works after casting
    }
}
Output:
Drawing a Circle
Area = π × r²
---
Drawing a Rectangle
Area = length × width
---
Drawing a generic shape
Calculating generic area
---
Drawing a Circle
Circumference = 2 × π × r

5. KEY RULES & LIMITATIONS
   What Works with Dynamic Dispatch:
   ✅ Overridden instance methods
   ✅ Inherited methods (calls parent version if not overridden)
   ✅ Public, protected, package-private methods
   What DOESN'T Work:
   ❌ Static methods (resolved at compile time - Static Binding)
   ❌ Private methods (not inherited, so no overriding)
   ❌ Final methods (cannot be overridden)
   ❌ Constructor calls (not inherited)
   ❌ Variable access (resolved at compile time based on reference type)
   Example of Limitations:
   javaclass Parent {
   static void staticMethod() {
   System.out.println("Parent static method");
   }

   private void privateMethod() {
   System.out.println("Parent private method");
   }

   int value = 100;
   }

class Child extends Parent {
static void staticMethod() {
System.out.println("Child static method");
}

    // Cannot override private method - this is a new method
    private void privateMethod() {
        System.out.println("Child private method");
    }
    
    int value = 200;
}

public class LimitationsDemo {
public static void main(String[] args) {
Parent ref = new Child();

        // Static method - NO dynamic dispatch
        ref.staticMethod();  // Output: Parent static method (reference type)
        
        // Variable access - NO dynamic dispatch  
        System.out.println(ref.value);  // Output: 100 (reference type)
    }
}

6. DYNAMIC DISPATCH vs STATIC BINDING
   AspectDynamic DispatchStatic BindingWhen ResolvedRuntimeCompile TimeBased OnActual Object TypeReference TypeApplies ToInstance MethodsStatic Methods, VariablesAlso CalledLate BindingEarly BindingPolymorphismRuntime PolymorphismCompile Time Polymorphism

7. COMMON INTERVIEW QUESTIONS
   Q1: What happens if child class doesn't override parent method?
   Answer: Parent's method gets called. Dynamic dispatch still works - JVM finds the method in parent class during runtime search.
   Q2: Can dynamic dispatch work with static methods?
   Answer: No. Static methods are resolved at compile time based on reference type, not actual object type.
   Q3: What about method overloading?
   Answer: Method overloading is resolved at compile time (static binding). Dynamic dispatch only works with overriding.
   Q4: How does JVM decide which method to call?
   Answer: JVM starts from actual object's class and searches upward in inheritance hierarchy until it finds the method.
   Q5: What if parent reference calls child-specific method?
   Answer: Compilation error. Compiler checks method existence in reference type (parent), not actual object type.

8. PRACTICAL INTERVIEW SCENARIO
   javaclass Vehicle {
   void start() {
   System.out.println("Vehicle starting");
   }

   void stop() {
   System.out.println("Vehicle stopping");
   }
   }

class Car extends Vehicle {
@Override
void start() {
System.out.println("Car engine starting");
}

    void openTrunk() {
        System.out.println("Trunk opened");
    }
}

class Bike extends Vehicle {
@Override
void start() {
System.out.println("Bike engine starting");
}

    @Override
    void stop() {
        System.out.println("Bike stopping with brakes");
    }
}

// Interview Question: What will be the output?
public class InterviewTest {
public static void main(String[] args) {
Vehicle v1 = new Car();
Vehicle v2 = new Bike();
Vehicle v3 = new Vehicle();

        v1.start();  // ?
        v1.stop();   // ?
        
        v2.start();  // ?
        v2.stop();   // ?
        
        v3.start();  // ?
        v3.stop();   // ?
        
        // v1.openTrunk();  // Compilation error - why?
    }
}
Answer:
Car engine starting      // Dynamic dispatch - Car's overridden method
Vehicle stopping         // Dynamic dispatch - Car inherits from Vehicle
Bike engine starting     // Dynamic dispatch - Bike's overridden method  
Bike stopping with brakes // Dynamic dispatch - Bike's overridden method
Vehicle starting         // Dynamic dispatch - Vehicle's own method
Vehicle stopping         // Dynamic dispatch - Vehicle's own method

9. REAL-WORLD APPLICATIONS
1. Framework Design
   java// Framework defines interface
   abstract class DatabaseConnection {
   abstract void connect();
   abstract void disconnect();
   }

// Different implementations
class MySQLConnection extends DatabaseConnection {
void connect() { /* MySQL specific connection */ }
void disconnect() { /* MySQL specific disconnection */ }
}

class PostgreSQLConnection extends DatabaseConnection {
void connect() { /* PostgreSQL specific connection */ }
void disconnect() { /* PostgreSQL specific disconnection */ }
}

// Framework can work with any implementation
class DatabaseManager {
void manageConnection(DatabaseConnection db) {
db.connect();    // Dynamic dispatch - actual implementation called
// Do database operations
db.disconnect(); // Dynamic dispatch - actual implementation called
}
}
2. GUI Event Handling
   javaabstract class Button {
   abstract void onClick();
   }

class SaveButton extends Button {
void onClick() { /* Save file logic */ }
}

class CancelButton extends Button {
void onClick() { /* Cancel operation logic */ }
}

// Event handler doesn't need to know button type
class EventHandler {
void handleClick(Button button) {
button.onClick();  // Dynamic dispatch - appropriate action executed
}
}

10. BEST PRACTICES & TIPS
    For Interviews:

Always mention it's runtime behavior
Explain the difference from compile-time binding
Give practical examples with inheritance
Mention limitations (static methods, variables)
Connect to polymorphism concept

For Coding:

Use meaningful method names in inheritance hierarchy
Document overridden methods clearly
Be careful with casting when accessing child-specific methods
Design parent classes to support dynamic dispatch effectively


11. QUICK REFERENCE SUMMARY
    Key Concepts:

Runtime method resolution based on actual object type
Foundation of Runtime Polymorphism
Works only with overridden instance methods
JVM searches inheritance hierarchy bottom-up for method

Remember for Interviews:

Dynamic = Runtime, Static = Compile time
Reference type determines what methods can be called (compile check)
Actual object type determines which method gets called (runtime)
Variables and static methods use static binding, not dynamic dispatch

Common Traps:

Don't confuse with method overloading (compile-time resolution)
Remember static methods don't participate in dynamic dispatch
Parent reference can't access child-specific methods without casting
Variable access is always based on reference type, not object type

This mechanism enables Java's powerful polymorphic behavior and is fundamental to object-oriented design patterns!

//Method override: It is Run time polymorphism.
//Dynamic method dispatch -> concept.

        // This is allowed parent object can hold child object.
        Animal ani = new Dog();
        ani.sound();
        /*
        The Answer: Animal reference has LIMITED access
The ani reference can only access:

✅ Methods that exist in the Animal class (parent)
✅ But the actual implementation called will be from Dog class (if overridden)

The ani reference CANNOT access:

❌ Methods that exist only in Dog class (child-specific methods)

The KEY CONCEPT: Reference Type vs Object Type
javaAnimal ani = new Dog();
//  ↑           ↑
// Reference   Actual
//  Type       Object
What this means:
✅ ACCESSIBLE (Methods in Animal class):

ani.eat() - Inherited method from Animal
ani.makeSound() - Overridden method (but Dog's version is called!)
ani.sleep() - Inherited method from Animal
ani.move() - Overridden method (Dog's version is called!)

❌ NOT ACCESSIBLE (Dog-specific methods):

ani.bark() - ❌ Compilation error
ani.wagTail() - ❌ Compilation error
ani.fetch() - ❌ Compilation error

Why This Restriction Exists:

Compiler checks reference type (Animal) to see what methods are available
At runtime, JVM calls actual object's method (Dog's implementation)
This ensures type safety - you can only call methods that are guaranteed to exist

To Access Dog-Specific Methods:
javaAnimal ani = new Dog();

// Option 1: Casting
((Dog) ani).bark();  // ✅ Works

// Option 2: Safe casting with instanceof
if (ani instanceof Dog) {
Dog dog = (Dog) ani;
dog.bark();  // ✅ Works
}
Summary:

Reference type (Animal) determines what methods you CAN call
Object type (Dog) determines which implementation gets executed
You get Dog's behavior for overridden methods, but only Animal's interface for accessibility

This is the foundation of polymorphism - same interface, different implementations!RetryClaude does not have the ability to run the code it generates yet.Claude can make mistakes. Please double-check responses.
*/
//        Dog dog = new Animal(); --> This is not allowed child instance can not hold parent object in it.