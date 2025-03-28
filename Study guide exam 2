# Java Study Guide

This guide reviews key concepts from Modules 1 through 7, with extra emphasis on Modules 5 through 7. It includes high-level summaries, explanations, and example code snippets in Java.

---

## Table of Contents

1. [Module 1](#module-1)
   - [Variables](#variables-primitive-vs-complex)
   - [Reading/Writing to the Console](#readingwriting-to-the-console)
   - [Conditionals](#conditionals-ifthenelse-ifelse-case)
   - [Logical Operators](#logical-operators)
   - [Arithmetic Operators](#arithmetic-operators)
   - [Methods](#methods)
   - [Loops](#loops)
   - [Operator Precedence](#operator-precedence)
   - [Arrays](#arrays)
   - [Two-Dimensional Arrays](#two-dimensional-arrays)
   - [Classes](#classes)
   - [Driver Code (Using the Dot Operator)](#driver-dot-operator)
2. [Module 2](#module-2)
   - [ArrayLists (Lists)](#arraylists-or-lists)
   - [Pass by Value vs Pass by Reference](#passing-by-value-vs-passing-by-reference)
   - [Returning Values from Methods](#returning-values-from-a-method)
   - [Garbage Collection](#garbage-collection)
   - [Method Overloading](#method-overloading)
3. [Module 3](#module-3)
   - [Inheritance](#inheritance)
   - [Method Overriding](#overriding-methods)
   - [Object/Object](#objectobject)
   - [this vs super](#this-vs-super)
   - [Access Modifiers](#publicprivateprotected)
   - [Polymorphism](#polymorphism)
   - [Abstract Classes](#abstract-classes)
   - [Interfaces](#interfaces)
   - [Casting](#casting)
4. [Module 4 (Recursion)](#module-4-recursion)
   - [Function Stack](#what-is-the-function-stack)
   - [Tracing Code](#how-to-trace-code)
   - [Local Variables in Recursive Calls](#how-variables-are-local-to-each-method-call-by-default)
   - [Recursion Concepts](#recursion)
5. [Module 5 (Exception Handling)](#module-5-exception-handling)
   - [What is an Exception?](#what-is-an-exception)
   - [Catching Exceptions](#catching-an-exception)
   - [Exception Hierarchy](#exception-object-hierarchy)
   - [Throwing Exceptions](#throwing-exceptions)
   - [Custom Exceptions](#defining-custom-exception)
   - [Checked vs Unchecked Exceptions](#checked-vs-unchecked-exceptions)
6. [Module 6 (File I/O)](#module-6-file-io)
   - [Opening a File (Reading, Writing, Appending)](#how-to-open-a-file-for-reading-writing-appending-creating)
   - [Reading/Writing Text Files](#how-to-read-a-text-file-and-write-to-a-text-file)
   - [Parsing Different Formats](#parsing-file-of-different-formats)
   - [Reading Binary Files](#reading-a-binary-file)
   - [Closing Files](#closing-files)
   - [Socket I/O](#reading-from-and-writing-to-a-socket)
7. [Module 7 (Threads and Parallel Processing)](#module-7-threads-and-parallel-processing)
   - [Why Use Multiple Threads?](#dividing-work-into-multiple-threads)
   - [Thread Throughput vs Speedup](#understanding-why-3-threads-doesnt-mean-completing-a-task-in-⅓-the-time)
   - [Implementing Threads](#using-runnablethreadstart-starting-a-thread)
   - [Thread States](#thread-states)
   - [Parallel Processing (Task Parallel Library, ForkJoin)](#task-parallel-libraryparallelforeach-parallelinvoke)
   - [ForkJoin Pools](#forkjoin-pools-recursive-actions-recursive-task)

---

## Module 1

### Variables (Primitive vs Complex)
- **Primitive Types** in Java include `int`, `double`, `char`, `boolean`, `byte`, `short`, `long`, `float`.
- **Complex (Reference) Types** typically refer to objects or arrays, e.g., `String`, array objects, custom classes.

```java
int myNumber = 42;           // primitive
String myString = "Hello";   // reference type (complex)
```

### Reading/Writing to the Console
- `System.out.println("Hello World");` prints output followed by a newline.
- `System.out.print("Hello");` prints without adding a newline.
- Reading from console (since Java 1.5+):
  ```java
  import java.util.Scanner;

  Scanner input = new Scanner(System.in);
  System.out.print("Enter a number: ");
  int userNumber = input.nextInt();  // reads an integer
  ```

### Conditionals (if/then/else if/else, case)
- **if** statements:
  ```java
  if (x > 10) {
      System.out.println("x is greater than 10");
  } else if (x == 10) {
      System.out.println("x equals 10");
  } else {
      System.out.println("x is less than 10");
  }
  ```
- **switch** statement:
  ```java
  switch (color) {
      case "red":
          // handle red
          break;
      case "blue":
          // handle blue
          break;
      default:
          // handle other
  }
  ```

### Logical Operators
- **Equality/Relational**: `<`, `<=`, `>`, `>=`, `==`, `!=`
- **Logical**: `&&` (AND), `||` (OR), `!` (NOT)

### Arithmetic Operators
- **Basic**: `+`, `-`, `*`, `/`, `%`
- **Assignment**: `+=`, `-=`, `*=`, `/=`
- **Increment/Decrement**: `++`, `--`
  - `x++` (post-increment) returns `x` then increments.
  - `++x` (pre-increment) increments then returns the new value.

### Methods
- **Declaring**: specify return type, method name, parameters, and body.
  ```java
  public static int sum(int a, int b) {
      return a + b;
  }
  ```
- **Calling**: use method name with matching arguments.
  ```java
  int result = sum(3, 4);  // result = 7
  ```

### Loops
- **for**:
  ```java
  for (int i = 0; i < 10; i++) {
      System.out.println(i);
  }
  ```
- **while**:
  ```java
  int i = 0;
  while (i < 10) {
      System.out.println(i);
      i++;
  }
  ```
- **do-while**:
  ```java
  int i = 0;
  do {
      System.out.println(i);
      i++;
  } while (i < 10);
  ```
- **for-each** (enhanced for loop):
  ```java
  int[] arr = {1,2,3};
  for (int num : arr) {
      System.out.println(num);
  }
  ```

### Operator Precedence
- Common order: `*`/`/`/`%` have higher precedence than `+`/`-`.
- Parentheses can override default precedence.

### Arrays
- **Declaring**: `int[] arr = new int[5];`
- **Accessing**: `arr[0] = 10;`
- **Traversing**:
  ```java
  for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
  }
  ```
- **Properties**: `length` is a final property of arrays.

### Two-Dimensional Arrays
- **Declaring**: `int[][] matrix = new int[3][4];`
- **Accessing**: `matrix[row][col] = 5;`
- **Traversing**:
  ```java
  for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[r].length; c++) {
          System.out.println(matrix[r][c]);
      }
  }
  ```

### Classes
- **Defining**:
  ```java
  public class Person {
      private String name;  // attribute

      public Person() {     // default constructor
          this.name = "Unknown";
      }

      public Person(String name) {  // overloaded constructor
          this.name = name;
      }

      public String getName() {     // getter
          return this.name;
      }

      public void setName(String name) {  // setter
          this.name = name;
      }

      public void printInfo() {     // method
          System.out.println("Name: " + name);
      }
  }
  ```
- **Static**: belongs to the class, not a specific instance.
  ```java
  public static int count = 0;
  public static void showCount() {
      System.out.println(count);
  }
  ```

### Driver (Dot Operator)
- Instantiating an object:
  ```java
  Person p = new Person("Alice");
  p.printInfo();               // calling a method
  System.out.println(p.name);  // if name were public (not recommended)
  ```

---

## Module 2

### ArrayLists (or Lists)
- Need `import java.util.ArrayList;`
- **Defining**: `ArrayList<String> list = new ArrayList<>();`
- **Adding**: `list.add("Hello");`
- **Accessing**: `list.get(0);`
- **Removing**: `list.remove("Hello");`
- **Size**: `list.size();`
- **Iteration**:
  ```java
  for (String item : list) {
      System.out.println(item);
  }
  ```

### Passing by Value vs Passing by Reference
- **Java is strictly pass-by-value** for both primitives and object references. The *reference itself* is passed by value, but the object can still be modified if the method uses the reference to update fields.
  ```java
  public static void modifyString(String str) {
      str = "New Value"; // does not affect the original outside
  }
  ```
  ```java
  public static void modifyPerson(Person p) {
      p.setName("Bob"); // modifies the actual object
  }
  ```

### Returning Values from a Method
- Return types must match the declared type.
- Example:
  ```java
  public static double average(int x, int y) {
      return (x + y) / 2.0;
  }
  ```

### Garbage Collection
- Java automatically manages memory; unreferenced objects are eligible for garbage collection.
- You can suggest GC with `System.gc()`, but it’s not guaranteed.

### Method Overloading
- Multiple methods with the *same name* but different parameter lists.
  ```java
  public static int add(int a, int b) {
      return a + b;
  }
  public static double add(double a, double b) {
      return a + b;
  }
  ```

---

## Module 3

### Inheritance
- A class can **extend** another class.
- Inherits fields/methods (excluding private fields of the superclass).
- Helps reuse code and establish an “is-a” relationship.
  ```java
  public class Animal {
      protected String name;
      public void eat() { /* ... */ }
  }

  public class Dog extends Animal {
      public void bark() { System.out.println("Woof!"); }
  }
  ```

### Overriding Methods
- Provide a new implementation of an inherited method:
  ```java
  @Override
  public String toString() {
      return "Dog: " + name;
  }
  ```

### Object/Object
- `Object` is the root of Java’s class hierarchy. Every class implicitly extends `Object` if no other parent is specified.

### this vs super
- `this` refers to the current instance.
- `super` refers to the parent (superclass) instance or methods.
  ```java
  public class Dog extends Animal {
      public Dog(String name) {
          super();          // calls Animal's constructor
          this.name = name; // sets current dog's name
      }
  }
  ```

### Public/Private/Protected
- **public**: accessible from anywhere.
- **private**: accessible only within the same class.
- **protected**: accessible within the same package or subclasses.

### Polymorphism
- **Polymorphism**: a superclass reference can refer to a subclass instance, and the correct method is chosen at runtime (late binding).
  ```java
  Animal myAnimal = new Dog();
  myAnimal.eat();  // Calls Dog's inherited eat() method
  // If Dog overrides eat(), that override is called
  ```

### Abstract Classes
- Cannot be instantiated directly.
- Can contain both abstract methods (no implementation) and concrete methods.
  ```java
  public abstract class Shape {
      public abstract double getArea();
      public void printShape() {
          System.out.println("I am a shape.");
      }
  }
  public class Circle extends Shape {
      private double radius;
      public Circle(double r) {
          this.radius = r;
      }
      @Override
      public double getArea() {
          return Math.PI * radius * radius;
      }
  }
  ```

### Interfaces
- All methods in an interface are implicitly public and abstract (in older Java versions; Java 8+ also allows default methods).
  ```java
  public interface Flyable {
      void fly();
  }
  public class Bird implements Flyable {
      @Override
      public void fly() {
          System.out.println("Bird is flying.");
      }
  }
  ```

### Casting
- **Upcasting**: `(Animal) new Dog()` is generally implicit if Dog extends Animal.
- **Downcasting**: `(Dog) myAnimal` only valid if `myAnimal` actually refers to a `Dog`.
- Use `instanceof` to check type before downcasting.

---

## Module 4 (Recursion)

### What is the Function Stack
- Each method call has its own *stack frame* storing local variables and return addresses.

### How to Trace Code
- Follow each method call, note parameter values and local variables.

### How Variables Are Local to Each Method Call by Default
- Each invocation has new copies of its local variables.

### Recursion
- A method that calls itself until a **base condition** is met.
  
  ```java
  public static int factorial(int n) {
      if (n <= 1) {          // Base Condition
          return 1;
      } else {
          return n * factorial(n - 1);  // Recursive Call
      }
  }
  ```

- **Infinite recursion** happens if the base condition is missing or incorrect.
- **Tracing recursion**:
  1. Identify the base case.
  2. Follow each call step-by-step.

---

## Module 5 (Exception Handling)

> **Note**: This module is a key focus area.

### What is an Exception
- An **exception** is an event that disrupts normal flow of the program during runtime.
- When an exception occurs (is “thrown”), normal execution stops and the runtime looks for an appropriate “catch” block.

### Catching an Exception
- **try/catch**:
  ```java
  try {
      int x = 5 / 0; // ArithmeticException
  } catch (ArithmeticException e) {
      System.out.println("Error: " + e.getMessage());
  } finally {
      System.out.println("This always executes.");
  }
  ```
- **finally** block runs whether or not an exception is thrown.

### Exception Object Hierarchy
- `Throwable`
  - `Error` (not typically handled by applications)
  - `Exception`
    - `RuntimeException` (unchecked exceptions)
    - other checked exceptions

### Throwing Exceptions
- You can manually **throw** exceptions:
  ```java
  if (value < 0) {
      throw new IllegalArgumentException("value cannot be negative");
  }
  ```

### Defining Custom Exception
- Extend `Exception` (for a checked exception) or `RuntimeException` (for an unchecked exception):
  ```java
  public class MyCustomException extends Exception {
      public MyCustomException(String message) {
          super(message);
      }
  }
  ```

### Checked vs Unchecked Exceptions
- **Checked Exceptions**: Must be declared in a method’s `throws` clause or handled with try/catch. Examples: `IOException`, `SQLException`.
- **Unchecked Exceptions**: Subclasses of `RuntimeException`. Not required to be handled explicitly. Examples: `NullPointerException`, `ArithmeticException`.

---

## Module 6 (File I/O)

> Also a major area of focus.

### How to Open a File for Reading, Writing, Appending, Creating
- Common classes: `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`, `FileInputStream`, `FileOutputStream`, `Scanner` for simpler text reading, etc.
- **Reading**:
  ```java
  try (FileReader fr = new FileReader("input.txt");
       BufferedReader br = new BufferedReader(fr)) {
      String line;
      while ((line = br.readLine()) != null) {
          System.out.println(line);
      }
  } catch (IOException e) {
      e.printStackTrace();
  }
  ```
- **Writing**:
  ```java
  try (FileWriter fw = new FileWriter("output.txt");
       BufferedWriter bw = new BufferedWriter(fw)) {
      bw.write("Hello, File!");
  } catch (IOException e) {
      e.printStackTrace();
  }
  ```
- **Appending**: use `FileWriter("output.txt", true)`

### How to Read a Text File, and Write to a Text File
- Example above shows typical approach.
- Alternatively, `Scanner`:
  ```java
  try (Scanner scanner = new Scanner(new File("input.txt"))) {
      while (scanner.hasNextLine()) {
          System.out.println(scanner.nextLine());
      }
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  }
  ```

### Parsing File of Different Formats
- You can split strings on delimiters (e.g., CSV) or use specialized libraries.
  ```java
  String[] parts = line.split(",");
  ```

### Reading a Binary File
- Use `FileInputStream` (and `DataInputStream` for convenience).
  ```java
  try (FileInputStream fis = new FileInputStream("data.bin")) {
      int byteRead;
      while ((byteRead = fis.read()) != -1) {
          // process byte
      }
  } catch (IOException e) {
      e.printStackTrace();
  }
  ```

### Closing Files
- **Try-with-resources** (introduced in Java 7) automatically closes them.

### Reading from and Writing to a Socket
- Use `java.net.Socket` or server classes like `ServerSocket`.  
  ```java
  try (Socket socket = new Socket("localhost", 8080);
       PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
       BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
      out.println("Hello Server");
      String response = in.readLine();
      System.out.println("Server replied: " + response);
  } catch (IOException e) {
      e.printStackTrace();
  }
  ```

---

## Module 7 (Threads and Parallel Processing)

> Another key focus area.

### Dividing Work into Multiple Threads
- Threads allow concurrency within a single process.

### Understanding Why 3 Threads Doesn’t Mean Completing a Task in 1/3 the Time
- Due to context switching, shared resources, and overhead. Speedup is not always linear.

### Using Runnable/ThreadStart, Starting a Thread
- Implement `Runnable` or extend `Thread`.
  ```java
  public class MyRunnable implements Runnable {
      @Override
      public void run() {
          System.out.println("Thread is running.");
      }
  }

  // Starting a thread:
  MyRunnable r = new MyRunnable();
  Thread t = new Thread(r);
  t.start();
  ```
  
### Thread States
- **New**, **Runnable**, **Running**, **Blocked/Waiting**, **Terminated**.

### Task Parallel Library/Parallel.ForEach, Parallel.Invoke
- In Java, you can achieve parallel streams or use concurrent libraries.  
  - For parallel streams:
    ```java
    list.parallelStream().forEach(item -> {
       // process item
    });
    ```
  - Java’s `CompletableFuture` and `ExecutorService` can mimic “parallel” tasks.

### ForkJoin Pools, Recursive Actions, Recursive Task
- **ForkJoinPool** is used for parallelizing recursive algorithms.
  ```java
  import java.util.concurrent.RecursiveTask;

  public class SumTask extends RecursiveTask<Long> {
      private final long[] arr;
      private final int start, end;

      public SumTask(long[] arr, int start, int end) {
          this.arr = arr;
          this.start = start;
          this.end = end;
      }

      @Override
      protected Long compute() {
          if (end - start <= 10_000) { // threshold
              long sum = 0;
              for (int i = start; i < end; i++) {
                  sum += arr[i];
              }
              return sum;
          } else {
              int mid = (start + end) / 2;
              SumTask leftTask = new SumTask(arr, start, mid);
              SumTask rightTask = new SumTask(arr, mid, end);

              leftTask.fork();         // run left task asynchronously
              Long rightResult = rightTask.compute(); 
              Long leftResult = leftTask.join();  

              return leftResult + rightResult;
          }
      }
  }
  ```

---

## Final Notes

- Modules 5, 6, and 7 (and possibly 8, if covered) are especially emphasized for Test 2, **but** Modules 1–3 content is still foundational and testable.
- Practice writing short code snippets focusing on:
  - **Exception handling** (try/catch/finally, custom exceptions)
  - **File I/O** (text/binary, reading/writing, parsing, and closing resources)
  - **Multithreading** (implementing `Runnable`, using `Thread`, concurrency issues, and performance considerations)

Good luck with your studying, and remember to **practice** with hands-on coding examples to fully solidify these concepts!
