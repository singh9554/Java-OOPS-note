# Java Object-Oriented Programming (OOP) Concepts

## Classes, Objects & Methods - Complete Guide

### 🏗️ What is a Class?
A class is a blueprint or template that defines the structure and behavior of objects. It's like an architectural plan for a house - it shows what the house will look like but isn't the actual house itself.

**Key Points about Classes:**
- A class is a user-defined data type
- It contains attributes (variables) and methods (functions)
- It serves as a template for creating objects
- Classes don't consume memory until objects are created
- It defines what an object will have and what it can do

### 📋 Rules for Creating Classes in Java

**1. Class Declaration Rules:**
```java
[access_modifier] class ClassName {
    // class body
}
```

**2. Naming Rules:**
- Class name must start with a letter (A-Z or a-z), underscore (_), or dollar sign ($)
- Cannot start with a digit
- Cannot use Java keywords (class, int, public, etc.)
- Follow PascalCase convention (first letter of each word capitalized)
- Should be a noun (represents an entity)

```java
// ✅ Valid class names
class Student { }
class BankAccount { }
class Car { }
class _MyClass { }
class $SpecialClass { }

// ❌ Invalid class names
class 2Student { }        // Starts with digit
class class { }           // Java keyword
class student-info { }    // Contains hyphen
```

**3. File Naming Rules:**
- If class is public, file name must match class name exactly
- File extension must be .java
- Only one public class per file

```java
// File: Student.java
public class Student {
    // This is correct
}
```

**4. Access Modifier Rules:**
- **public:** Accessible from anywhere
- **default** (no modifier): Accessible within same package
- **private:** Not allowed for top-level classes
- **protected:** Not allowed for top-level classes

### 🔢 How Many Classes Can Be in One Program?

**In One .java File:**
- Only ONE public class per file
- Multiple non-public classes (default access) allowed
- Public class name = File name

```java
// File: MainClass.java

public class MainClass {        // ✅ Public class - file name matches
    // main class content
}

class HelperClass {             // ✅ Non-public class - allowed
    // helper class content
}

class UtilityClass {            // ✅ Another non-public class - allowed
    // utility class content
}

// public class AnotherClass { }  // ❌ ERROR: Only one public class allowed
```

**In One Java Program (Project):**
- Unlimited classes across multiple files
- Each public class in its own .java file
- Non-public classes can share files

### 🎯 What is an Object?
An object is a real-world entity or an instance of a class. If class is a blueprint, object is the actual house built from that blueprint.

**Important Points about Objects:**

**1. Object Definition:**
- An object is an instance of a class
- It has state (values of attributes) and behavior (methods)
- Objects consume memory when created
- Also called instance of a class

**2. Object Creation:**
```java
ClassName objectName = new ClassName();
```

**3. Memory Allocation:**
- Objects are stored in Heap memory
- Object reference is stored in Stack memory
- Garbage Collector automatically manages memory

**4. Object Characteristics:**
- **Identity:** Unique identification (memory address)
- **State:** Current values of all attributes
- **Behavior:** Methods that can be performed on the object

**5. Multiple Objects from Same Class:**
```java
Student student1 = new Student();  // First object
Student student2 = new Student();  // Second object
Student student3 = new Student();  // Third object
// Each has separate memory space and can have different states
```

**6. Object Reference:**
- Reference variable holds the memory address of object
- Multiple references can point to same object
- If no reference points to object, it becomes eligible for garbage collection

```java
Student s1 = new Student();     // s1 references the object
Student s2 = s1;               // s2 also references same object
s1 = null;                     // s1 no longer references object
// Object still exists because s2 references it
```

**7. Accessing Object Members:**
```java
objectName.variableName;    // Access attribute
objectName.methodName();    // Call method
```

### ⚙️ What is a Method?
A method is a block of code that performs a specific task. It's like a function that belongs to a class and defines the behavior of objects.

**Important Points about Methods:**

**1. Method Definition:**
```java
[access_modifier] [static] [return_type] methodName([parameters]) {
    // method body
    [return statement;]
}
```

**2. Method Components:**
- **Access Modifier:** Controls visibility (public, private, protected, default)
- **Static keyword:** Optional - method belongs to class, not instance
- **Return Type:** Data type of value returned (void if nothing returned)
- **Method Name:** Identifier for the method (camelCase convention)
- **Parameters:** Input values (optional)
- **Method Body:** Code that executes when method is called

**3. Types of Methods:**

*Instance Methods:*
```java
public void displayInfo() {        // Instance method
    // Needs object to call
}
```

*Static Methods:*
```java
public static void showMessage() { // Static method
    // Can call without creating object
}
```

**4. Method Calling:**
```java
// Instance method calling
ObjectName objectName = new ObjectName();
objectName.methodName();

// Static method calling
ClassName.methodName();
```

**5. Method Parameters:**
- **Parameters:** Variables in method declaration
- **Arguments:** Actual values passed when calling method

```java
public void setAge(int age) {      // 'age' is parameter
    this.age = age;
}

student.setAge(20);                // '20' is argument
```

**6. Return Statement:**
- **void methods:** Don't return anything
- **Non-void methods:** Must return value of declared type
- **return statement** exits method immediately

**7. Method Overloading:**
- Same method name with different parameters
- Compile-time polymorphism

```java
public void display() { }                    // No parameters
public void display(String name) { }         // One parameter
public void display(String name, int age) { } // Two parameters
```

### 💻 Complete Example with Explanation

```java
// File: Student.java

// Class Declaration - Blueprint for Student objects
public class Student {
    
    // ========== ATTRIBUTES (Instance Variables) ==========
    // These define the STATE of an object
    private String name;        // Private - encapsulation
    private int age;           // Each object will have its own age
    private String studentId;  // Unique for each student
    private double gpa;        // Grade Point Average
    
    // Static variable - belongs to class, shared by all objects
    private static int totalStudents = 0;
    
    // ========== CONSTRUCTORS ==========
    // Special method to initialize object when created
    
    // Default Constructor (no parameters)
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.studentId = "NOT_ASSIGNED";
        this.gpa = 0.0;
        totalStudents++;          // Increment total count
        System.out.println("Default constructor called");
    }
    
    // Parameterized Constructor
    public Student(String name, int age, String studentId, double gpa) {
        this.name = name;         // 'this' refers to current object
        this.age = age;
        this.studentId = studentId;
        this.gpa = gpa;
        totalStudents++;
        System.out.println("Parameterized constructor called");
    }
    
    // ========== INSTANCE METHODS ==========
    // These define the BEHAVIOR of objects
    
    // Getter methods - provide controlled access to private variables
    public String getName() {
        return name;              // Return current object's name
    }
    
    public int getAge() {
        return age;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    // Setter methods - allow controlled modification of private variables
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;     // Validation before setting
        } else {
            System.out.println("Invalid name provided");
        }
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;       // Business logic validation
        } else {
            System.out.println("Invalid age provided");
        }
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA must be between 0.0 and 4.0");
        }
    }
    
    // Method with no return type (void) - performs an action
    public void displayInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("GPA: " + gpa);
        System.out.println("==========================");
    }
    
    // Method with return type - calculates and returns value
    public String getGradeLevel() {
        if (gpa >= 3.5) {
            return "Excellent";
        } else if (gpa >= 3.0) {
            return "Good";
        } else if (gpa >= 2.0) {
            return "Average";
        } else {
            return "Below Average";
        }
    }
    
    // Method with parameters - takes input and processes it
    public void updateGpa(double newGpa) {
        double oldGpa = this.gpa;
        setGpa(newGpa);           // Using setter for validation
        System.out.println("GPA updated from " + oldGpa + " to " + this.gpa);
    }
    
    // Method that interacts with other objects
    public boolean isClassmate(Student otherStudent) {
        // Comparing with another Student object
        return this.studentId.equals(otherStudent.studentId);
    }
    
    // ========== STATIC METHODS ==========
    // Belong to class, not to any specific object
    
    public static int getTotalStudents() {
        return totalStudents;     // Access static variable
    }
    
    public static void printSchoolInfo() {
        System.out.println("Welcome to Java Programming School");
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
}

// ========== MAIN CLASS FOR TESTING ==========
class StudentTest {
    public static void main(String[] args) {
        System.out.println("=== CLASSES, OBJECTS & METHODS DEMO ===\n");
        
        // ========== OBJECT CREATION ==========
        System.out.println("1. Creating Objects:");
        
        // Creating object using default constructor
        Student student1 = new Student();
        
        // Creating object using parameterized constructor
        Student student2 = new Student("Alice Johnson", 20, "CS001", 3.8);
        Student student3 = new Student("Bob Smith", 19, "CS002", 3.2);
        
        System.out.println("Objects created successfully!\n");
        
        // ========== ACCESSING STATIC METHODS ==========
        System.out.println("2. Static Method Access:");
        Student.printSchoolInfo();    // Called using Class name
        System.out.println();
        
        // ========== USING SETTER METHODS ==========
        System.out.println("3. Setting Object Properties:");
        student1.setName("Charlie Brown");
        student1.setAge(21);
        student1.setGpa(3.5);
        System.out.println();
        
        // ========== USING GETTER METHODS ==========
        System.out.println("4. Getting Object Properties:");
        System.out.println("Student 2 Name: " + student2.getName());
        System.out.println("Student 2 Age: " + student2.getAge());
        System.out.println("Student 3 GPA: " + student3.getGpa());
        System.out.println();
        
        // ========== CALLING INSTANCE METHODS ==========
        System.out.println("5. Instance Method Calls:");
        
        // Method with no parameters, no return value
        student1.displayInfo();
        
        // Method with return value
        System.out.println("Student 2 Grade Level: " + student2.getGradeLevel());
        
        // Method with parameters
        student3.updateGpa(3.6);
        System.out.println();
        
        // ========== OBJECT INTERACTION ==========
        System.out.println("6. Object Interaction:");
        Student student4 = new Student("Alice Johnson", 21, "CS001", 3.9);
        
        if (student2.isClassmate(student4)) {
            System.out.println(student2.getName() + " and " + student4.getName() + " have same student ID");
        } else {
            System.out.println(student2.getName() + " and " + student4.getName() + " are different students");
        }
        System.out.println();
        
        // ========== MULTIPLE OBJECTS DEMONSTRATION ==========
        System.out.println("7. Multiple Objects with Different States:");
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        
        // ========== STATIC VARIABLE ACCESS ==========
        System.out.println("8. Static Variable Access:");
        System.out.println("Total students created: " + Student.getTotalStudents());
    }
}
```

### 🔍 Step-by-Step Explanation:

**Step 1: Class Declaration**
```java
public class Student {
```
- Creates a public class named "Student"
- This is our blueprint for creating student objects

**Step 2: Attributes (Instance Variables)**
```java
private String name;
private int age;
```
- Define what data each Student object will have
- Private ensures encapsulation

**Step 3: Constructor**
```java
public Student(String name, int age, String studentId, double gpa) {
    this.name = name;
}
```
- Special method that runs when object is created
- Initializes object's state

**Step 4: Methods**
```java
public String getName() {
    return name;
}
```
- Define what actions objects can perform
- Getters/setters provide controlled access

**Step 5: Object Creation**
```java
Student student1 = new Student();
```
- **Student** = Class name (data type)
- **student1** = Reference variable (points to object)
- **new** = Creates new object in memory
- **Student()** = Calls constructor

**Step 6: Method Calling**
```java
student1.setName("Charlie");
String name = student1.getName();
```
- Use dot operator to access object's methods
- Methods can modify object's state or return values

### 📝 Summary
- **Class:** Blueprint that defines structure and behavior
- **Object:** Real instance created from class blueprint
- **Method:** Function that defines what objects can do
- Each object has its own state but shares class methods
- Memory is allocated when objects are created, not when class is defined
- Access object members using dot operator (objectName.member)

---

## Polymorphism, Constructor, Static & This Keyword - Complete Guide

### 🔄 Polymorphism

**What is Polymorphism?**
Polymorphism means "one name, many forms". It allows the same method name to behave differently based on the object that calls it.

Real-world example: A "draw" command works differently for a Circle (draws circle) vs Rectangle (draws rectangle), but uses the same command name.

**Types of Polymorphism:**

#### 1️⃣ Compile-Time Polymorphism (Method Overloading)
**Definition:** Same method name with different parameters in the same class.

```java
class Calculator {
    
    // Method 1: Add two integers
    int add(int a, int b) {
        return a + b;
    }
    
    // Method 2: Add three integers (different parameter count)
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Method 3: Add two doubles (different parameter type)
    double add(double a, double b) {
        return a + b;
    }
    
    // Method 4: Add two strings (different parameter type)
    String add(String a, String b) {
        return a + b;
    }
}

class OverloadingDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        // Same method name 'add', different behavior based on parameters
        System.out.println("Add two integers: " + calc.add(5, 3));           // Output: 8
        System.out.println("Add three integers: " + calc.add(5, 3, 2));      // Output: 10
        System.out.println("Add two doubles: " + calc.add(5.5, 3.2));        // Output: 8.7
        System.out.println("Add two strings: " + calc.add("Hello", "World")); // Output: HelloWorld
    }
}
```

**Rules for Method Overloading:**
- Method name must be same
- Parameters must be different (number, type, or order)
- Return type can be same or different
- Access modifiers can be same or different

#### 2️⃣ Runtime Polymorphism (Method Overriding)
**Definition:** Child class provides specific implementation of parent class method.

```java
// Parent class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
    
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

// Child class 1
class Dog extends Animal {
    @Override  // Annotation to indicate overriding
    void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

// Child class 2
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows: Meow! Meow!");
    }
}

// Child class 3
class Cow extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cow moos: Moo! Moo!");
    }
}

class OverridingDemo {
    public static void main(String[] args) {
        // Runtime polymorphism in action
        Animal animal1 = new Dog();    // Parent reference, Child object
        Animal animal2 = new Cat();    // Parent reference, Child object
        Animal animal3 = new Cow();    // Parent reference, Child object
        
        // Same method call, different behavior at runtime
        animal1.makeSound();  // Output: Dog barks: Woof! Woof!
        animal2.makeSound();  // Output: Cat meows: Meow! Meow!
        animal3.makeSound();  // Output: Cow moos: Moo! Moo!
        
        // Method not overridden - uses parent implementation
        animal1.sleep();      // Output: Animal is sleeping
    }
}
```

**Rules for Method Overriding:**
- Method signature must be exactly same
- Child class method cannot have more restrictive access modifier
- Return type must be same or covariant
- Cannot override static, final, or private methods

### 🏗️ Constructor

**What is a Constructor?**
A constructor is a special method that is automatically called when an object is created. It initializes the object.

**Key Points:**
- Same name as class
- No return type (not even void)
- Called automatically when object is created
- Used to initialize object state

**Types of Constructors:**

#### 1️⃣ Default Constructor (No Parameters)
```java
class Student {
    String name;
    int age;
    String course;
    
    // Default constructor - no parameters
    Student() {
        name = "Unknown";
        age = 0;
        course = "Not Assigned";
        System.out.println("Default constructor called");
    }
    
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

class DefaultConstructorDemo {
    public static void main(String[] args) {
        Student student1 = new Student();  // Default constructor called automatically
        student1.displayInfo();
        
        // Output: 
        // Default constructor called
        // Name: Unknown, Age: 0, Course: Not Assigned
    }
}
```

#### 2️⃣ Parameterized Constructor (With Parameters)
```java
class Student {
    String name;
    int age;
    String course;
    
    // Parameterized constructor
    Student(String studentName, int studentAge, String studentCourse) {
        name = studentName;
        age = studentAge;
        course = studentCourse;
        System.out.println("Parameterized constructor called");
    }
    
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

class ParameterizedConstructorDemo {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 20, "Computer Science");
        student1.displayInfo();
        
        // Output:
        // Parameterized constructor called
        // Name: Alice, Age: 20, Course: Computer Science
    }
}
```

#### 3️⃣ Constructor Overloading (Multiple Constructors)
```java
class Book {
    String title;
    String author;
    double price;
    int pages;
    
    // Constructor 1: No parameters
    Book() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
        pages = 0;
        System.out.println("Default constructor called");
    }
    
    // Constructor 2: With title and author
    Book(String bookTitle, String bookAuthor) {
        title = bookTitle;
        author = bookAuthor;
        price = 0.0;
        pages = 0;
        System.out.println("Constructor with 2 parameters called");
    }
    
    // Constructor 3: With title, author, and price
    Book(String bookTitle, String bookAuthor, double bookPrice) {
        title = bookTitle;
        author = bookAuthor;
        price = bookPrice;
        pages = 0;
        System.out.println("Constructor with 3 parameters called");
    }
    
    // Constructor 4: With all parameters
    Book(String bookTitle, String bookAuthor, double bookPrice, int bookPages) {
        title = bookTitle;
        author = bookAuthor;
        price = bookPrice;
        pages = bookPages;
        System.out.println("Constructor with 4 parameters called");
    }
    
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Pages: " + pages);
        System.out.println("--------------------");
    }
}

class ConstructorOverloadingDemo {
    public static void main(String[] args) {
        // Different constructor calls
        Book book1 = new Book();
        Book book2 = new Book("Java Programming", "James Gosling");
        Book book3 = new Book("Python Guide", "Guido van Rossum", 29.99);
        Book book4 = new Book("C++ Primer", "Bjarne Stroustrup", 39.99, 500);
        
        // Display all books
        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
        book4.displayInfo();
    }
}
```

### 🔧 Static Keyword

**What is Static?**
Static means belongs to the class rather than to any specific object. Static members are shared by all objects of the class.

**Types of Static Members:**

#### 1️⃣ Static Variables (Class Variables)
```java
class Counter {
    static int count = 0;        // Static variable - shared by all objects
    String name;                 // Instance variable - unique for each object
    
    Counter(String objectName) {
        name = objectName;
        count++;                 // Increment shared counter
        System.out.println("Object " + name + " created. Total objects: " + count);
    }
    
    void displayInfo() {
        System.out.println("Object name: " + name + ", Total count: " + count);
    }
}

class StaticVariableDemo {
    public static void main(String[] args) {
        Counter obj1 = new Counter("First");    // count becomes 1
        Counter obj2 = new Counter("Second");   // count becomes 2
        Counter obj3 = new Counter("Third");    // count becomes 3
        
        obj1.displayInfo();  // Object name: First, Total count: 3
        obj2.displayInfo();  // Object name: Second, Total count: 3
        obj3.displayInfo();  // Object name: Third, Total count: 3
        
        // Accessing static variable using class name
        System.out.println("Total objects created: " + Counter.count);
    }
}
```

#### 2️⃣ Static Methods
```java
class MathHelper {
    static String className = "MathHelper";  // Static variable
    
    // Static method - can be called without creating object
    static int add(int a, int b) {
        return a + b;
    }
    
    static int multiply(int a, int b) {
        return a * b;
    }
    
    static double calculateArea(double radius) {
        return 3.14159 * radius * radius;
    }
    
    // Static method can access static variables
    static void showClassName() {
        System.out.println("Class name: " + className);
    }
    
    // Instance method
    void instanceMethod() {
        System.out.println("This is an instance method");
        // Can access both static and instance variables
    }
}

class StaticMethodDemo {
    public static void main(String[] args) {
        // Calling static methods without creating object
        // Use ClassName.methodName()
        
        int sum = MathHelper.add(10, 20);
        int product = MathHelper.multiply(5, 6);
        double area = MathHelper.calculateArea(7.5);
        
        System.out.println("Sum: " + sum);           // Sum: 30
        System.out.println("Product: " + product);   // Product: 30
        System.out.println("Area: " + area);         // Area: 176.714...
        
        MathHelper.showClassName();  // Class name: MathHelper
        
        // For instance method, we need to create object
        MathHelper helper = new MathHelper();
        helper.instanceMethod();
    }
}
```

#### 3️⃣ Static Block
```java
class DatabaseConfig {
    static String databaseUrl;
    static String username;
    static String password;
    
    // Static block - executed when class is first loaded
    static {
        System.out.println("Static block executed - Initializing database config");
        databaseUrl = "jdbc:mysql://localhost:3306/mydb";
        username = "admin";
        password = "password123";
    }
    
    // Another static block
    static {
        System.out.println("Second static block executed");
    }
    
    static void showConfig() {
        System.out.println("Database URL: " + databaseUrl);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}

class StaticBlockDemo {
    public static void main(String[] args) {
        System.out.println("Main method started");
        
        // Static blocks execute before any static method call
        DatabaseConfig.showConfig();
        
        System.out.println("Main method ended");
        
        // Output:
        // Main method started
        // Static block executed - Initializing database config
        // Second static block executed
        // Database URL: jdbc:mysql://localhost:3306/mydb
        // Username: admin
        // Password: password123
        // Main method ended
    }
}
```

**Important Rules for Static:**
- Static methods cannot access instance variables directly
- Static methods cannot call instance methods directly
- Cannot use 'this' keyword in static methods
- Static variables are initialized when class is first loaded

### 👆 This Keyword

**What is 'this'?**
'this' is a reference to the current object. It refers to the object whose method or constructor is being called.

**Uses of 'this' Keyword:**

#### 1️⃣ Differentiate Between Instance Variable and Parameter
```java
class Person {
    String name;
    int age;
    String city;
    
    // Constructor with parameters having same names as instance variables
    Person(String name, int age, String city) {
        // Without 'this', it would be parameter = parameter (does nothing)
        this.name = name;    // this.name refers to instance variable
        this.age = age;      // age refers to parameter
        this.city = city;
        
        System.out.println("Person created with name: " + this.name);
    }
    
    void setPersonInfo(String name, int age, String city) {
        this.name = name;    // 'this' distinguishes instance var from parameter
        this.age = age;
        this.city = city;
    }
    
    void displayInfo() {
        System.out.println("Name: " + this.name);    // 'this' is optional here
        System.out.println("Age: " + age);           // can omit 'this' when no conflict
        System.out.println("City: " + city);
    }
}

class ThisExample1 {
    public static void main(String[] args) {
        Person person1 = new Person("John", 25, "New York");
        person1.displayInfo();
        
        person1.setPersonInfo("Jane", 30, "London");
        person1.displayInfo();
    }
}
```

#### 2️⃣ Constructor Chaining
```java
class Vehicle {
    String brand;
    String model;
    int year;
    double price;
    
    // Constructor 1: Default
    Vehicle() {
        this("Unknown", "Unknown", 0, 0.0);  // Calling constructor 4
        System.out.println("Default constructor executed");
    }
    
    // Constructor 2: With brand only
    Vehicle(String brand) {
        this(brand, "Unknown", 0, 0.0);      // Calling constructor 4
        System.out.println("Constructor with brand executed");
    }
    
    // Constructor 3: With brand and model
    Vehicle(String brand, String model) {
        this(brand, model, 0, 0.0);          // Calling constructor 4
        System.out.println("Constructor with brand and model executed");
    }
    
    // Constructor 4: With all parameters
    Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        System.out.println("All-parameter constructor executed");
    }
    
    void displayInfo() {
        System.out.println("Brand: " + this.brand + ", Model: " + this.model + 
                          ", Year: " + this.year + ", Price: $" + this.price);
    }
}

class ConstructorChainingDemo {
    public static void main(String[] args) {
        System.out.println("Creating vehicle with default constructor:");
        Vehicle v1 = new Vehicle();
        v1.displayInfo();
        
        System.out.println("\nCreating vehicle with brand:");
        Vehicle v2 = new Vehicle("Toyota");
        v2.displayInfo();
        
        System.out.println("\nCreating vehicle with brand and model:");
        Vehicle v3 = new Vehicle("Honda", "Civic");
        v3.displayInfo();
    }
}
```

#### 3️⃣ Method Chaining (Returning Current Object)
```java
class StringBuilder2 {
    String content;
    
    StringBuilder2() {
        content = "";
    }
    
    StringBuilder2 append(String text) {
        content += text;
        return this;    // Return current object for chaining
    }
    
    StringBuilder2 appendLine(String text) {
        content += text + "\n";
        return this;    // Return current object for chaining
    }
    
    StringBuilder2 reverse() {
        String reversed = "";
        for (int i = content.length() - 1; i >= 0; i--) {
            reversed += content.charAt(i);
        }
        content = reversed;
        return this;    // Return current object for chaining
    }
    
    void display() {
        System.out.println("Content: " + content);
    }
}

class MethodChainingDemo {
    public static void main(String[] args) {
        StringBuilder2 sb = new StringBuilder2();
        
        // Method chaining - calling multiple methods in sequence
        sb.append("Hello")
          .append(" ")
          .append("World")
          .appendLine("!")
          .append("This is method chaining");
        
        sb.display();  // Content: Hello World!
                      //          This is method chaining
    }
}
```

#### 4️⃣ Passing Current Object to Another Method
```java
class Student {
    String name;
    int marks;
    
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    
    void compareWith(Student other) {
        System.out.println("Comparing " + this.name + " with " + other.name);
        
        if (this.marks > other.marks) {
            System.out.println(this.name + " has higher marks");
        } else if (this.marks < other.marks) {
            System.out.println(other.name + " has higher marks");
        } else {
            System.out.println("Both have same marks");
        }
    }
    
    void printDetails() {
        System.out.println("Student: " + this.name + ", Marks: " + this.marks);
    }
    
    // Method that receives current object as parameter
    void processStudent(Student currentStudent) {
        System.out.println("Processing student: " + currentStudent.name);
    }
    
    void callProcess() {
        processStudent(this);    // Passing current object
    }
}

class PassingCurrentObjectDemo {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 85);
        Student student2 = new Student("Bob", 78);
        
        student1.printDetails();
        student2.printDetails();
        
        student1.compareWith(student2);  // 'this' refers to student1
        
        student1.callProcess();  // Passing current object
    }
}
```

### 📝 Summary & Key Points

**Polymorphism:**
- **Overloading:** Same method name, different parameters (compile-time)
- **Overriding:** Child class redefines parent method (runtime)

**Constructor:**
- Special method to initialize objects
- Same name as class, no return type
- Can be overloaded like regular methods
- Automatically called when object is created

**Static Keyword:**
- Belongs to class, not individual objects
- Shared by all instances of the class
- Can access only static members directly
- Called using ClassName.memberName

**This Keyword:**
- Reference to current object
- Distinguishes between instance variables and parameters
- Used for constructor chaining
- Enables method chaining
- Cannot be used in static methods

These four concepts are fundamental to Java programming and are heavily used in frameworks like Spring Boot!

