public class Polymorphism {
    public int number(int a, int b){
        return a + b;
    }
    public int number(int a, int b,int c){
        return a + b + c;
    }
    public double number(double a, double b){
        return a + b;
    }

    public static void main(String[] args) {

         Polymorphism poly = new Polymorphism();
         //method overloading concept: here JVM decides in compile time.
        //Method overloading is a compile time polymorphism.
         poly.number(5,6);
         poly.number(5,6,8);
         poly.number(5,6);

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
    }
}
