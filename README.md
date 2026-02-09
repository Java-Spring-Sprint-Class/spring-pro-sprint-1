# Homework: Spring Core (IoC & DI)

## 📋 Description

Your goal is to create a modular Java application using the capabilities of the **Spring Framework** for managing dependencies (**Inversion of Control**) and their implementation (**Dependency Injection**).

You will develop a **Notification System** that can send messages through various channels (Email, SMS) without tight coupling between code components.

## 🎯 Objectives

* Understand the working principles of the **Spring IoC Container** (`ApplicationContext`).
* Learn how to configure beans using **Java-based configuration** (`@Configuration`, `@Bean`).
* Master **Component Scanning** (`@Component`, `@Service`).
* Implement **Dependency Injection** via constructor and fields (`@Autowired`).

---

## 🛠 Technical Requirements

### 1. Interface and Implementations

* Create a `MessageService` interface with the method `void sendMessage(String message)`.
* Create two implementations of this interface:
* **EmailService**: prints `"Email sent: [message]"` to the console.
* **SmsService**: prints `"SMS sent: [message]"` to the console.


* Annotate these classes with appropriate Spring stereotype annotations (e.g., `@Component` or `@Service`).

### 2. Client Class

* Create a `Client` class that depends on `MessageService`.
* Implement **Dependency Injection** (DI) via the **constructor**.
* The `Client` class must have a `processMessage(String msg)` method that calls the service's method.

### 3. Spring Configuration

* Create an `AppConfig` configuration class.
* Set up automatic **Component Scanning** to locate your beans.
* **Bonus Task (Optional):** Try defining one of the beans manually in `AppConfig` using the `@Bean` annotation, while keeping the other one detected via component scanning.

### 4. Execution (Main Class)

* In the `Main` class, create an instance of `AnnotationConfigApplicationContext`.
* Retrieve the `Client` bean from the context.
* Call the `processMessage` method to demonstrate the functionality.
