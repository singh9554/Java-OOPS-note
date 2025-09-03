Complete Java Keywords Reference Guide
📋 What are Java Keywords?
Java keywords are reserved words that have special meaning in Java language. They cannot be used as identifiers (variable names, method names, class names, etc.).
Total Java Keywords: 50 reserved words

🔤 Complete List of Java Keywords
KeywordCategoryDescriptionabstractOOPDeclares abstract class/methodassertControlUsed for debugging assertionsbooleanData TypeBoolean data type (true/false)breakControl FlowExit from loop or switchbyteData Type8-bit signed integercaseControl FlowUsed in switch statementcatchExceptionCatches exceptions in try-catchcharData Type16-bit Unicode characterclassOOPDeclares a classconstReservedReserved (not used)continueControl FlowSkip current iterationdefaultControl FlowDefault case in switchdoControl FlowDo-while loopdoubleData Type64-bit floating pointelseControl FlowAlternative in if-elseenumOOPDeclares enumerationextendsOOPInheritance - extends a classfinalModifierFinal variable/method/classfinallyExceptionAlways executes after try-catchfloatData Type32-bit floating pointforControl FlowFor loopgotoReservedReserved (not used)ifControl FlowConditional statementimplementsOOPImplements an interfaceimportPackageImport classes/packagesinstanceofOperatorType checking operatorintData Type32-bit signed integerinterfaceOOPDeclares an interfacelongData Type64-bit signed integernativeModifierNative method (JNI)newOperatorCreates new objectspackagePackageDeclares packageprivateAccessPrivate access modifierprotectedAccessProtected access modifierpublicAccessPublic access modifierreturnControl FlowReturns from methodshortData Type16-bit signed integerstaticModifierStatic memberstrictfpModifierStrict floating pointsuperOOPReference to parent classswitchControl FlowSwitch statementsynchronizedConcurrencyThread synchronizationthisOOPReference to current objectthrowExceptionThrows an exceptionthrowsExceptionDeclares exceptionstransientModifierExcludes from serializationtryExceptionTry block for exceptionsvoidReturn TypeNo return valuevolatileModifierVolatile variablewhileControl FlowWhile loop

🏷️ Keywords by Category
📊 Data Type Keywords (8)
java// Primitive data types
boolean isValid = true;        // true or false
byte age = 25;                 // -128 to 127
char grade = 'A';              // Single character
short score = 32000;           // -32,768 to 32,767
int count = 1000000;           // -2^31 to 2^31-1
long population = 7800000000L; // -2^63 to 2^63-1
float price = 99.99f;          // 32-bit decimal
double salary = 50000.50;      // 64-bit decimal

class DataTypeExample {
public static void main(String[] args) {
System.out.println("Boolean: " + isValid);
System.out.println("Byte: " + age);
System.out.println("Char: " + grade);
System.out.println("Short: " + score);
System.out.println("Int: " + count);
System.out.println("Long: " + population);
System.out.println("Float: " + price);
System.out.println("Double: " + salary);
}
}

🔐 Access Modifier Keywords (3)
javaclass AccessModifierExample {
public String publicVar = "Accessible everywhere";
protected String protectedVar = "Accessible in package & subclasses";
private String privateVar = "Accessible only in this class";
String defaultVar = "Accessible in same package"; // default access

    public void publicMethod() {
        System.out.println("Public method - accessible everywhere");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method - accessible in package & subclasses");
    }
    
    private void privateMethod() {
        System.out.println("Private method - accessible only in this class");
    }
    
    void defaultMethod() {
        System.out.println("Default method - accessible in same package");
    }
}

🎛️ Control Flow Keywords (11)
Conditional Statements
javaclass ConditionalExample {
public static void main(String[] args) {
int score = 85;

        // if-else
        if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 80) {
            System.out.println("Grade B");
        } else {
            System.out.println("Grade C");
        }
        
        // switch-case-default
        char grade = 'B';
        switch (grade) {
            case 'A':
                System.out.println("Excellent!");
                break;
            case 'B':
                System.out.println("Good!");
                break;
            case 'C':
                System.out.println("Average");
                break;
            default:
                System.out.println("Invalid grade");
        }
    }
}
Loop Statements
javaclass LoopExample {
public static void main(String[] args) {
// for loop
for (int i = 1; i <= 5; i++) {
System.out.println("For loop: " + i);
}

        // while loop
        int j = 1;
        while (j <= 3) {
            System.out.println("While loop: " + j);
            j++;
        }
        
        // do-while loop
        int k = 1;
        do {
            System.out.println("Do-while loop: " + k);
            k++;
        } while (k <= 2);
        
        // break and continue
        for (int i = 1; i <= 10; i++) {
            if (i == 3) {
                continue; // Skip iteration when i = 3
            }
            if (i == 8) {
                break;    // Exit loop when i = 8
            }
            System.out.println("Number: " + i);
        }
    }
}

🏗️ OOP Keywords (8)
java// abstract class
abstract class Animal {
abstract void makeSound(); // abstract method

    void sleep() { // concrete method
        System.out.println("Animal is sleeping");
    }
}

// class extends abstract class
class Dog extends Animal {
@Override
void makeSound() {
System.out.println("Dog barks");
}
}

// interface
interface Flyable {
void fly(); // implicitly abstract and public
}

// class implements interface
class Bird extends Animal implements Flyable {
@Override
void makeSound() {
System.out.println("Bird chirps");
}

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

// enum
enum Day {
MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

class OOPExample {
public static void main(String[] args) {
Dog dog = new Dog();
dog.makeSound(); // Dog barks
dog.sleep();     // Animal is sleeping

        Bird bird = new Bird();
        bird.makeSound(); // Bird chirps
        bird.fly();       // Bird is flying
        
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);
        
        // this and super examples in methods
        // instanceof example
        if (dog instanceof Animal) {
            System.out.println("Dog is an Animal");
        }
    }
}

⚙️ Modifier Keywords (8)
javaclass ModifierExample {
// static - belongs to class
static int classCounter = 0;

    // final - constant value
    final int CONSTANT_VALUE = 100;
    
    // transient - not serialized
    transient String password = "secret";
    
    // volatile - thread-safe variable
    volatile boolean isRunning = true;
    
    static {
        System.out.println("Static block executed");
    }
    
    // final method - cannot be overridden
    final void finalMethod() {
        System.out.println("This method cannot be overridden");
    }
    
    // synchronized method - thread-safe
    synchronized void synchronizedMethod() {
        System.out.println("Only one thread can access this at a time");
    }
    
    // native method - implemented in other language (like C++)
    native void nativeMethod();
    
    // strictfp - strict floating-point calculations
    strictfp double calculate(double a, double b) {
        return a * b;
    }
}

// final class - cannot be extended
final class FinalClass {
void someMethod() {
System.out.println("This class cannot be extended");
}
}

🚨 Exception Handling Keywords (5)
javaclass ExceptionExample {
public static void main(String[] args) {
// try-catch-finally
try {
int result = divide(10, 0);
System.out.println("Result: " + result);
} catch (ArithmeticException e) {
System.out.println("Error: " + e.getMessage());
} finally {
System.out.println("Finally block always executes");
}

        // Method that throws exception
        try {
            throwException();
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
    
    // throws - declares exceptions
    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero!"); // throw
        }
        return a / b;
    }
    
    static void throwException() throws Exception {
        throw new Exception("Custom exception thrown");
    }
}

📦 Package Keywords (2)
java// package declaration (must be first line)
package com.mycompany.myproject;

// import statements
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PackageExample {
public static void main(String[] args) {
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Names: " + names);
    }
}

🔧 Other Keywords (5)
javaclass OtherKeywordsExample {

    // Method with void return type
    void voidMethod() {
        System.out.println("This method returns nothing");
        return; // optional for void methods
    }
    
    // Method with return value
    int getValue() {
        return 42; // return keyword with value
    }
    
    // new keyword
    void objectCreation() {
        String str = new String("Hello World");
        int[] array = new int[5];
        ArrayList<String> list = new ArrayList<>();
    }
    
    // assert keyword (used for debugging)
    void assertExample(int age) {
        assert age >= 0 : "Age cannot be negative";
        System.out.println("Age is: " + age);
    }
    
    public static void main(String[] args) {
        OtherKeywordsExample example = new OtherKeywordsExample();
        
        example.voidMethod();
        int value = example.getValue();
        System.out.println("Returned value: " + value);
        
        example.objectCreation();
        
        // Enable assertions with: java -ea YourClass
        example.assertExample(25);
    }
}

🚫 Reserved Keywords (2)
java// These keywords are reserved but NOT USED in Java

// const - reserved but not used (use 'final' instead)
// final int CONSTANT = 100;  // ✅ Correct way

// goto - reserved but not used (considered harmful)
// Use structured programming instead

⚠️ Important Rules for Keywords
❌ Cannot Use Keywords As:
java// These will cause compilation errors
// int class = 5;           // ERROR: 'class' is keyword
// String if = "hello";     // ERROR: 'if' is keyword  
// void for() {}            // ERROR: 'for' is keyword
// boolean public = true;   // ERROR: 'public' is keyword
✅ Correct Usage:
java// Use meaningful names that are not keywords
int studentClass = 5;       // ✅ Correct
String condition = "hello"; // ✅ Correct
void processLoop() {}       // ✅ Correct
boolean isPublic = true;    // ✅ Correct

🎯 Keywords Most Important for Beginners
🔥 Top 20 Most Used Keywords:

class - Define classes
public - Access modifier
private - Access modifier
static - Class members
void - No return value
int - Integer data type
String - Text data (not keyword, but class)
if - Conditional statements
else - Alternative condition
for - Loop
while - Loop
return - Return from method
new - Create objects
this - Current object reference
super - Parent class reference
extends - Inheritance
implements - Interface implementation
try - Exception handling
catch - Exception handling
finally - Always execute block


📝 Summary
Java has 50 reserved keywords divided into categories:

Data Types (8): boolean, byte, char, short, int, long, float, double
Access Modifiers (3): public, protected, private
Control Flow (11): if, else, switch, case, default, for, while, do, break, continue, return
OOP (8): class, interface, abstract, extends, implements, this, super, instanceof
Modifiers (8): static, final, synchronized, volatile, transient, native, strictfp, enum
Exception Handling (5): try, catch, finally, throw, throws
Package (2): package, import
Others (3): new, void, assert
Reserved (2): const, goto (not used)

Remember: Keywords are case-sensitive and cannot be used as identifiers!