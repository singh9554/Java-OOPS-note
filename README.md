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

---

## Packages, Access Modifiers & Encapsulation - Complete Guide

### 📦 Packages in Java

**What is a Package?**
A package is like a folder that groups related classes together. It's a way to organize your code and avoid naming conflicts.

Real-world analogy: Think of your computer's file system - you organize files into folders. Similarly, Java organizes classes into packages.

**Why Use Packages?**
- **Organization:** Keep related classes together
- **Name conflicts:** Two classes can have same name in different packages
- **Access control:** Control which classes can access your code
- **Easy maintenance:** Find and manage code easily

#### 📁 Package Structure Examples:
```java
// Real Java packages structure:
java.lang          // Core Java classes (String, Object, etc.)
java.util          // Utility classes (ArrayList, HashMap, etc.)
java.io            // Input/Output classes (File, Scanner, etc.)

// Your project packages:
com.company.project
├── models/        // Classes representing data
├── services/      // Business logic classes  
├── controllers/   // User interface classes
└── utils/         // Helper classes
```

#### 🔧 How to Create and Use Packages:

**Creating a Package:**
```java
// File: com/library/models/Book.java
package com.library.models;    // Package declaration (MUST be first line)

public class Book {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void displayInfo() {
        System.out.println("Book: " + title + " by " + author);
    }
}
```

**Using Classes from Packages:**
```java
// File: com/library/main/LibraryMain.java
package com.library.main;

// Import specific class
import com.library.models.Book;

// Import all classes from package (not recommended)
// import com.library.models.*;

public class LibraryMain {
    public static void main(String[] args) {
        // Using imported class
        Book book1 = new Book("Java Programming", "Oracle");
        book1.displayInfo();
        
        // Using class with full package name (without import)
        com.library.models.Book book2 = new com.library.models.Book("Python Guide", "Guido");
        book2.displayInfo();
    }
}
```

**Package Naming Conventions:**
```java
// Company domain in reverse + project name
com.google.android
com.microsoft.office
org.apache.commons

// Your packages should follow this pattern:
com.yourcompany.projectname.modulename
com.library.management.models
com.library.management.services
```

### 🔐 Access Modifiers

**What are Access Modifiers?**
Access modifiers control who can access your classes, methods, and variables. They set visibility rules.

#### 4 Types of Access Modifiers:

| Modifier | Same Class | Same Package | Subclass | Everywhere |
|----------|------------|--------------|----------|------------|
| private  | ✅         | ❌           | ❌       | ❌         |
| default  | ✅         | ✅           | ❌       | ❌         |
| protected| ✅         | ✅           | ✅       | ❌         |
| public   | ✅         | ✅           | ✅       | ✅         |

#### 📝 Detailed Examples:

#### 1️⃣ Private Access Modifier
```java
// File: com/example/BankAccount.java
package com.example;

class BankAccount {
    private double balance;        // Private - only accessible within this class
    private String accountNumber;  // Private variable
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // Private method - only accessible within this class
    private boolean validateAmount(double amount) {
        return amount > 0;
    }
    
    // Public methods to access private data
    public void deposit(double amount) {
        if (validateAmount(amount)) {  // Calling private method within same class ✅
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public double getBalance() {
        return balance;  // Accessing private variable within same class ✅
    }
}

class BankTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0);
        
        account.deposit(500);           // ✅ Public method - accessible
        System.out.println("Balance: $" + account.getBalance()); // ✅ Public method
        
        // account.balance = 5000;      // ❌ ERROR: balance is private
        // account.validateAmount(100); // ❌ ERROR: validateAmount is private
    }
}
```

#### 2️⃣ Default Access Modifier (Package-Private)
```java
// File: com/example/DefaultExample.java
package com.example;

class DefaultExample {
    String name;              // Default access - no modifier specified
    int age;                  // Default access
    
    void displayInfo() {      // Default access method
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class SamePackageClass {
    public static void main(String[] args) {
        DefaultExample obj = new DefaultExample();
        
        obj.name = "John";        // ✅ Accessible - same package
        obj.age = 25;             // ✅ Accessible - same package
        obj.displayInfo();        // ✅ Accessible - same package
    }
}
```

```java
// File: com/different/DifferentPackageClass.java
package com.different;  // Different package

import com.example.DefaultExample;

class DifferentPackageClass {
    public static void main(String[] args) {
        DefaultExample obj = new DefaultExample();
        
        // obj.name = "John";     // ❌ ERROR: not accessible from different package
        // obj.age = 25;          // ❌ ERROR: not accessible from different package
        // obj.displayInfo();     // ❌ ERROR: not accessible from different package
    }
}
```

#### 3️⃣ Protected Access Modifier
```java
// File: com/example/Vehicle.java
package com.example;

public class Vehicle {
    protected String brand;        // Protected - accessible in package + subclasses
    protected int year;
    
    protected void startEngine() { // Protected method
        System.out.println("Vehicle engine started");
    }
}
```

```java
// File: com/example/Car.java (Same package)
package com.example;

class Car extends Vehicle {
    public void carMethod() {
        brand = "Toyota";      // ✅ Accessible - same package
        year = 2023;           // ✅ Accessible - same package
        startEngine();         // ✅ Accessible - same package
    }
}

class TestProtected {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.brand = "Honda";    // ✅ Accessible - same package
        vehicle.startEngine();      // ✅ Accessible - same package
    }
}
```

```java
// File: com/different/Bike.java (Different package)
package com.different;

import com.example.Vehicle;

class Bike extends Vehicle {     // Subclass in different package
    public void bikeMethod() {
        brand = "Yamaha";        // ✅ Accessible - subclass (inheritance)
        year = 2022;             // ✅ Accessible - subclass
        startEngine();           // ✅ Accessible - subclass
    }
}

class TestProtectedDifferent {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        // vehicle.brand = "Honda";    // ❌ ERROR: not accessible from different package
        // vehicle.startEngine();      // ❌ ERROR: not accessible from different package
        
        Bike bike = new Bike();
        bike.bikeMethod();             // ✅ This works because it's inside subclass
    }
}
```

#### 4️⃣ Public Access Modifier
```java
// File: com/example/PublicExample.java
package com.example;

public class PublicExample {
    public String message;         // Public - accessible everywhere
    public int number;
    
    public void showMessage() {    // Public method - accessible everywhere
        System.out.println("Message: " + message);
    }
}
```

```java
// File: com/anywhere/AnyClass.java
package com.anywhere;  // Completely different package

import com.example.PublicExample;

class AnyClass {
    public static void main(String[] args) {
        PublicExample obj = new PublicExample();
        
        obj.message = "Hello from anywhere!";  // ✅ Public - accessible everywhere
        obj.number = 100;                      // ✅ Public - accessible everywhere
        obj.showMessage();                     // ✅ Public - accessible everywhere
    }
}
```

### 🔒 Encapsulation

**What is Encapsulation?**
Encapsulation means bundling data (variables) and methods together and hiding internal implementation details from the outside world.

Real-world analogy: A medicine capsule - the medicine (data) is safely enclosed inside the capsule, and you can only access it through proper means (methods).

**Why Encapsulation?**
- **Data Security:** Protect data from unauthorized access
- **Data Integrity:** Ensure data is modified correctly
- **Maintainability:** Change internal implementation without affecting external code
- **Flexibility:** Add validation and business logic

#### 🔧 How to Implement Encapsulation:
**Step 1:** Make Variables Private
**Step 2:** Provide Public Getter/Setter Methods

```java
class Student {
    // Private variables - cannot be accessed directly from outside
    private String name;
    private int age;
    private double gpa;
    private String email;
    
    // Constructor
    public Student(String name, int age, double gpa, String email) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.email = email;
    }
    
    // ========== GETTER METHODS (Read access) ==========
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public String getEmail() {
        return email;
    }
    
    // ========== SETTER METHODS (Write access with validation) ==========
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be empty");
        }
    }
    
    public void setAge(int age) {
        if (age >= 16 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Error: Age must be between 16 and 100");
        }
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Error: GPA must be between 0.0 and 4.0");
        }
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Error: Invalid email format");
        }
    }
    
    // ========== OTHER METHODS ==========
    
    public void displayInfo() {
        System.out.println("=== Student Info ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("Email: " + email);
        System.out.println("===================");
    }
    
    // Method to calculate grade based on GPA
    public String getGrade() {
        if (gpa >= 3.7) return "A";
        else if (gpa >= 3.3) return "B+";
        else if (gpa >= 3.0) return "B";
        else if (gpa >= 2.7) return "C+";
        else if (gpa >= 2.0) return "C";
        else return "F";
    }
}

class EncapsulationDemo {
    public static void main(String[] args) {
        // Creating student with valid data
        Student student1 = new Student("Alice Johnson", 20, 3.8, "alice@email.com");
        student1.displayInfo();
        
        System.out.println("Grade: " + student1.getGrade());
        System.out.println();
        
        // ========== DEMONSTRATING ENCAPSULATION BENEFITS ==========
        
        System.out.println("=== Testing Data Validation ===");
        
        // Valid updates
        student1.setAge(21);           // Valid age
        student1.setGpa(3.9);          // Valid GPA
        System.out.println("After valid updates:");
        student1.displayInfo();
        
        System.out.println();
        
        // Invalid updates - encapsulation protects data
        student1.setAge(150);          // Invalid age - rejected
        student1.setGpa(5.0);          // Invalid GPA - rejected
        student1.setEmail("invalidemail"); // Invalid email - rejected
        student1.setName("");          // Empty name - rejected
        
        System.out.println("After invalid updates (data unchanged):");
        student1.displayInfo();
        
        // ========== WITHOUT ENCAPSULATION (BAD EXAMPLE) ==========
        System.out.println("\n=== What happens WITHOUT encapsulation ===");
        
        NonEncapsulatedStudent badStudent = new NonEncapsulatedStudent();
        badStudent.name = "";          // ❌ Can set empty name
        badStudent.age = -5;           // ❌ Can set negative age
        badStudent.gpa = 10.0;         // ❌ Can set invalid GPA
        badStudent.email = "notanemail"; // ❌ Can set invalid email
        
        System.out.println("Bad student data:");
        badStudent.displayInfo();     // Shows invalid data!
    }
}

// Example of NON-encapsulated class (BAD PRACTICE)
class NonEncapsulatedStudent {
    public String name;    // Public - can be accessed directly
    public int age;        // No validation possible
    public double gpa;     // Anyone can set invalid values
    public String email;
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + 
                          ", GPA: " + gpa + ", Email: " + email);
    }
}
```

### 🏛️ Complete Access Modifier Examples

**Real-World Scenario: Banking System**
```java
// File: com/bank/core/Account.java
package com.bank.core;

public class Account {
    // Private - only accessible within this class
    private double balance;
    private String accountNumber;
    private String pin;
    
    // Protected - accessible in package + subclasses
    protected String accountType;
    protected String customerName;
    
    // Default (package-private) - accessible within same package
    String branchCode;
    String ifscCode;
    
    // Public - accessible everywhere
    public String bankName;
    
    public Account(String accountNumber, String customerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = initialBalance;
        this.bankName = "ABC Bank";
        this.branchCode = "BR001";
        this.ifscCode = "ABC0001234";
        this.accountType = "Savings";
    }
    
    // Private method - internal validation
    private boolean validatePin(String inputPin) {
        return pin != null && pin.equals(inputPin);
    }
    
    // Protected method - accessible to subclasses
    protected void updateAccountType(String newType) {
        accountType = newType;
        System.out.println("Account type updated to: " + newType);
    }
    
    // Default method - accessible within package
    void processInterest() {
        balance += balance * 0.03; // 3% interest
        System.out.println("Interest processed. New balance: $" + balance);
    }
    
    // Public methods - accessible everywhere
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". Balance: $" + balance);
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + ". Balance: $" + balance);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount");
            return false;
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void displayAccountInfo() {
        System.out.println("=== Account Information ===");
        System.out.println("Bank: " + bankName);
        System.out.println("Customer: " + customerName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Branch: " + branchCode);
        System.out.println("IFSC: " + ifscCode);
        System.out.println("Balance: $" + balance);
        System.out.println("==========================");
    }
}
```

**Same Package Access Example:**
```java
// File: com/bank/core/BankManager.java
package com.bank.core;  // SAME PACKAGE

class BankManager {
    public static void main(String[] args) {
        Account account = new Account("ACC001", "John Doe", 5000.0);
        
        // ✅ Public access
        account.bankName = "XYZ Bank";
        account.deposit(1000);
        
        // ✅ Protected access (same package)
        account.customerName = "John Smith";
        account.updateAccountType("Current");
        
        // ✅ Default access (same package)
        account.branchCode = "BR002";
        account.processInterest();
        
        // ❌ Private access - NOT accessible
        // account.balance = 10000;      // ERROR
        // account.validatePin("1234");  // ERROR
        
        account.displayAccountInfo();
    }
}
```

**Different Package Access Example:**
```java
// File: com/bank/external/ExternalTest.java
package com.bank.external;  // DIFFERENT PACKAGE

import com.bank.core.Account;

class ExternalTest {
    public static void main(String[] args) {
        Account account = new Account("ACC002", "Jane Doe", 3000.0);
        
        // ✅ Public access - accessible everywhere
        account.bankName = "Global Bank";
        account.deposit(500);
        account.displayAccountInfo();
        
        // ❌ Protected access - NOT accessible (different package, not subclass)
        // account.customerName = "Jane Smith";  // ERROR
        // account.updateAccountType("Fixed");   // ERROR
        
        // ❌ Default access - NOT accessible (different package)
        // account.branchCode = "BR003";         // ERROR
        // account.processInterest();            // ERROR
        
        // ❌ Private access - NOT accessible
        // account.balance = 10000;              // ERROR
    }
}
```

**Subclass in Different Package:**
```java
// File: com/bank/premium/PremiumAccount.java
package com.bank.premium;  // DIFFERENT PACKAGE

import com.bank.core.Account;

class PremiumAccount extends Account {  // Subclass
    private double creditLimit;
    
    public PremiumAccount(String accountNumber, String customerName, 
                         double initialBalance, double creditLimit) {
        super(accountNumber, customerName, initialBalance);
        this.creditLimit = creditLimit;
    }
    
    public void premiumFeatures() {
        // ✅ Public access - accessible everywhere
        bankName = "Premium Bank";
        
        // ✅ Protected access - accessible in subclass
        customerName = "VIP " + customerName;
        updateAccountType("Premium");
        
        // ❌ Default access - NOT accessible (different package, even if subclass)
        // branchCode = "PR001";         // ERROR
        // processInterest();            // ERROR
        
        // ❌ Private access - NOT accessible
        // balance = 50000;              // ERROR
        
        System.out.println("Premium account features activated for: " + customerName);
    }
}
```

### 📊 Access Modifiers Summary Table

| Access Level | private | default | protected | public |
|--------------|---------|---------|-----------|--------|
| Same Class   |   ✅    |   ✅    |   ✅    |   ✅    |
| Same Package |   ❌    |   ✅    |   ✅    |   ✅    |
| Subclass (Different Package) |   ❌    |   ❌    |   ✅    |   ✅    |
| Different Package |   ❌    |   ❌    |   ❌    |   ✅    |

### 🎯 Best Practices

**For Packages:**
- Use reverse domain naming (com.company.project)
- Keep related classes together
- Use meaningful package names
- Avoid deep nesting (max 4-5 levels)

**For Access Modifiers:**
- Default choice: Make everything private
- Use public only when needed for external access
- Use protected for inheritance-related features
- Use default for package-internal collaboration

**For Encapsulation:**
- Always make variables private
- Provide public getters/setters with validation
- Hide complex implementation details
- Expose only necessary functionality

### 💡 Quick Tips
- **Packages** help organize code - like folders for files
- **Access modifiers** control visibility - who can see what
- **Encapsulation** protects data - controlled access through methods
- Start restrictive, then open up - begin with private, make public only if needed
- **Validation in setters** - always check data before storing

These concepts work together to create secure, maintainable, and well-organized Java applications!

---

## Inheritance, Abstraction & Interfaces - Complete Guide

### 🧬 Inheritance

**What is Inheritance?**
Inheritance is a mechanism where a new class (child/subclass) acquires properties and methods of an existing class (parent/superclass). It promotes code reusability and establishes an "IS-A" relationship.

#### Types of Inheritance in Java
- **Single Inheritance** - One class extends another class
- **Multilevel Inheritance** - A chain of inheritance (A → B → C)
- **Hierarchical Inheritance** - Multiple classes inherit from one parent

#### Key Keywords
- **extends** - Used for class inheritance
- **super** - Refers to parent class
- **this** - Refers to current class instance

#### Example
```java
// Parent class
class Animal {
    protected String name;
    
    public void eat() {
        System.out.println("Animal is eating");
    }
}

// Child class
class Dog extends Animal {
    public void bark() {
        System.out.println("Dog is barking");
    }
    
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}
```

### 💎 Why Java Doesn't Support Multiple Inheritance?

#### The Diamond Problem
Java doesn't support multiple inheritance of classes to avoid the Diamond Problem.

**Problem Scenario:**
```
    Class A
   /        \
Class B    Class C
   \        /
    Class D
```

If both B and C override a method from A, and D inherits from both B and C, which version should D inherit? This creates ambiguity.

#### Java's Solution
- **Single Inheritance** for classes
- **Multiple Inheritance** through interfaces (since Java 8 with default methods)
- Interfaces can have default methods, but if conflicts arise, the implementing class must override the method

#### Example of Diamond Problem Solution
```java
interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B extends A {
    default void show() {
        System.out.println("B");
    }
}

interface C extends A {
    default void show() {
        System.out.println("C");
    }
}

class D implements B, C {
    // MUST override to resolve conflict
    @Override
    public void show() {
        B.super.show(); // Or choose C.super.show()
    }
}
```

### 🎭 Abstraction

**What is Abstraction?**
Abstraction hides implementation details and shows only essential features to the user. It focuses on "what" an object does rather than "how" it does it.

#### Ways to Achieve Abstraction
- **Abstract Classes** (0-100% abstraction)
- **Interfaces** (100% abstraction until Java 8, now can have default methods)

#### Abstract Classes
- Cannot be instantiated
- Can have both abstract and concrete methods
- Can have constructors, instance variables
- Use `abstract` keyword

```java
abstract class Shape {
    protected String color;
    
    // Abstract method - must be implemented by subclasses
    abstract double calculateArea();
    
    // Concrete method
    public void setColor(String color) {
        this.color = color;
    }
}

class Circle extends Shape {
    private double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
```

#### Key Points About Abstract Classes
- Can have 0 to n abstract methods
- If a class has even one abstract method, it must be declared abstract
- Subclasses must implement all abstract methods (unless they're also abstract)
- Can have constructors (called via `super()`)

### 🔌 Interfaces

**What are Interfaces?**
Interfaces define a contract that implementing classes must follow. They specify what methods a class must implement but not how.

#### Interface Evolution in Java

**Before Java 8:**
- Only abstract methods and constants
- 100% abstraction
- All methods implicitly `public abstract`
- All variables implicitly `public static final`

**Java 8 and Later:**
- **Default methods** - provide implementation
- **Static methods** - belong to interface, not implementing class

**Java 9+:**
- **Private methods** - for code reuse within interface

#### Interface Example
```java
interface Drawable {
    // Constant (implicitly public static final)
    int MAX_SIZE = 100;
    
    // Abstract method (implicitly public abstract)
    void draw();
    
    // Default method (Java 8+)
    default void resize() {
        System.out.println("Resizing...");
    }
    
    // Static method (Java 8+)
    static void printInfo() {
        System.out.println("This is Drawable interface");
    }
    
    // Private method (Java 9+)
    private void helper() {
        System.out.println("Helper method");
    }
}

class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}
```

### ⚖️ Abstract Class vs Interface

| Aspect | Abstract Class | Interface |
|--------|----------------|-----------|
| **Keyword** | `abstract class` | `interface` |
| **Methods** | Abstract + Concrete | Abstract + Default + Static + Private |
| **Variables** | Any type | Only `public static final` |
| **Inheritance** | Single inheritance | Multiple inheritance |
| **Constructor** | Can have | Cannot have |
| **Access Modifiers** | Any | Methods are public by default |
| **When to Use** | IS-A relationship, shared code | CAN-DO relationship, contract |

#### When to Use What?
- **Abstract Class:** When you have closely related classes sharing common code
- **Interface:** When you want to specify a contract that unrelated classes can implement

### 🎯 Common Interview Questions & Answers

**Q1: Can an abstract class have a constructor?**
**Answer:** Yes, abstract classes can have constructors. They're called when a subclass is instantiated using `super()`.

**Q2: Can we instantiate an abstract class?**
**Answer:** No, you cannot directly instantiate an abstract class using `new`. However, you can create anonymous inner classes.

**Q3: Can an interface extend multiple interfaces?**
**Answer:** Yes, interfaces can extend multiple interfaces using `extends`.
```java
interface A { }
interface B { }
interface C extends A, B { }
```

**Q4: What happens if a class implements two interfaces with the same default method?**
**Answer:** The class must override the method to resolve the conflict.

**Q5: Can we have main method in abstract class?**
**Answer:** Yes, abstract classes can have main methods and can be executed.

**Q6: What is marker interface?**
**Answer:** An interface with no methods, used to mark classes with special behavior (e.g., `Serializable`, `Cloneable`).

**Q7: Can interface have constructor?**
**Answer:** No, interfaces cannot have constructors because they cannot be instantiated.

**Q8: What is functional interface?**
**Answer:** An interface with exactly one abstract method. Can be used with lambda expressions (e.g., `Runnable`, `Comparator`).

**Q9: Difference between method overriding and method hiding?**
**Answer:**
- **Overriding:** Instance methods in subclass override parent methods
- **Hiding:** Static methods in subclass hide parent static methods

**Q10: Can we override static methods?**
**Answer:** No, static methods cannot be overridden, only hidden.

### 🚀 Advanced Concepts

#### Method Resolution in Inheritance
- **Method Overriding:** Runtime polymorphism - actual method called depends on object type
- **Method Hiding:** Compile-time resolution - method called depends on reference type

#### Super Keyword Usage
```java
class Parent {
    int x = 10;
    
    Parent() {
        System.out.println("Parent constructor");
    }
    
    void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    int x = 20;
    
    Child() {
        super(); // Call parent constructor
        System.out.println("Child constructor");
    }
    
    void display() {
        super.display(); // Call parent method
        System.out.println("Child display");
        System.out.println("Parent x: " + super.x); // Access parent variable
        System.out.println("Child x: " + this.x);
    }
}
```

#### Final Keyword with Inheritance
- **final class:** Cannot be inherited (e.g., `String`, `Integer`)
- **final method:** Cannot be overridden
- **final variable:** Cannot be reassigned

### 📋 Best Practices

#### Inheritance Best Practices
- Favor composition over inheritance when possible
- Use inheritance for IS-A relationships
- Keep inheritance hierarchies shallow
- Document the inheritance contract clearly

#### Interface Best Practices
- Keep interfaces focused and cohesive
- Use functional interfaces for single-method contracts
- Prefer interfaces over abstract classes for contracts
- Use default methods judiciously

#### Abstract Class Best Practices
- Provide common implementation in abstract classes
- Use abstract classes when you need constructors
- Don't make everything abstract - provide useful concrete methods

### 💻 Coding Interview Patterns

#### Common Scenarios
- **Shape hierarchy** - Abstract Shape class with concrete Circle, Rectangle
- **Vehicle hierarchy** - Demonstrating inheritance and polymorphism
- **Interface segregation** - Breaking large interfaces into smaller ones
- **Strategy pattern** - Using interfaces for different algorithms

#### Sample Interview Code
```java
// Demonstrate all concepts together
abstract class Vehicle {
    protected String brand;
    
    Vehicle(String brand) {
        this.brand = brand;
    }
    
    abstract void start();
    
    public void stop() {
        System.out.println("Vehicle stopped");
    }
}

interface Electric {
    void charge();
    
    default void batteryStatus() {
        System.out.println("Checking battery...");
    }
}

interface GPS {
    void navigate(String destination);
}

class Tesla extends Vehicle implements Electric, GPS {
    Tesla() {
        super("Tesla");
    }
    
    @Override
    void start() {
        System.out.println("Tesla started silently");
    }
    
    @Override
    public void charge() {
        System.out.println("Charging Tesla");
    }
    
    @Override
    public void navigate(String destination) {
        System.out.println("Navigating to: " + destination);
    }
}
```

### ✅ Quick Reference Checklist

#### Before Interview - Key Points to Remember
✅ Java supports single inheritance for classes, multiple for interfaces  
✅ Abstract classes can have constructors, interfaces cannot  
✅ Interfaces can have default, static, and private methods (Java 8+)  
✅ Diamond problem and how Java solves it  
✅ `super` vs `this` keyword usage  
✅ Method overriding vs method hiding  
✅ When to use abstract class vs interface  
✅ `final` keyword implications on inheritance  
✅ Marker interfaces and functional interfaces  
✅ Interface default method conflict resolution  

#### Common Traps in Interviews
- Assuming interfaces can't have method implementations (outdated knowledge)
- Confusing method overriding with method hiding
- Not knowing about interface private methods (Java 9+)
- Mixing up IS-A vs HAS-A relationships
- Forgetting that abstract classes can have concrete methods

---------------------------------------------------------------------