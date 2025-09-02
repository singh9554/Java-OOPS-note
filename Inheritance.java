public class Inheritance {
    public static void main(String[] args) {

       //creating Dog instance and object for class Dog from Animal.java program, Dog is a child of Animal;
      Dog dog = new Dog();

      dog.sound();
      dog.eating();
      dog.run();
    }
}
/**
 * There must be is a relationship between classes (relationship concept is know as inheritance)
 * / parent class can hold child object but child class cannot hold parent class object
 * Example:
 * Animal ani = new Dog(); //correct instance is animal object called dog class.
 * Dog do = new Animal(); //Wrong
 *
 * And this concept is also know an dynamic Dispatcher here which method is going to be called is being decided on run time
 * and this is known a run time polymorphism
 * Method overriding is also know a run time polymorphism because the override method is called during run time.
 */
