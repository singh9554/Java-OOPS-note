# Java Object-Oriented Programming (OOP) Concepts

## Tasks Completed

This folder contains implementations and examples of the following Java OOP concepts that I have learned and practiced:

### 1. **Class**
- A blueprint or template for creating objects
- Defines attributes (fields) and behaviors (methods) that objects of the class will have
- Encapsulates data and methods together
- Example: `class Student { ... }`

### 2. **Object**
- An instance of a class
- Created using the `new` keyword
- Has its own state (values of attributes) and can perform actions (call methods)
- Example: `Student student1 = new Student();`

### 3. **Constructor**
- Special method used to initialize objects when they are created
- Has the same name as the class
- Called automatically when an object is instantiated using `new`
- Can have parameters to set initial values
- Example: `public Student(String name, int age) { ... }`

### 4. **Method**
- Functions defined inside a class that define the behavior of objects
- Can have parameters and return values
- Can be called on objects to perform specific actions
- Example: `public void displayInfo() { ... }`

### 5. **Constructor Overloading**
- Having multiple constructors in the same class with different parameter lists
- Allows creating objects in different ways
- Java determines which constructor to use based on the arguments passed
- Example: Having both `Student()` and `Student(String name)` constructors

### 6. **`this` Keyword**
- Refers to the current object instance
- Used to differentiate between instance variables and parameters with the same name
- Can be used to call other constructors in the same class (`this()`)
- Example: `this.name = name;` or `this(defaultName);`

### 7. **`static` Keyword**
- Belongs to the class rather than any specific instance
- Static variables are shared among all objects of the class
- Static methods can be called without creating an object
- Cannot access non-static (instance) variables directly
- Example: `static int count;` or `public static void main(String[] args)`

---

**Note:** All these concepts have been implemented and practiced through various Java programs in this folder.
