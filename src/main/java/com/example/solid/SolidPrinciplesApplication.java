package com.example.solid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Solid Principles are a set of design principles that help developers create maintainable, scalable, and flexible software systems.
 * The principles are:
 * 1. Single Responsibility Principle (SRP): A class should have only one reason to change, meaning it should have only one responsibility or job.
 * 2. Open/Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to add new functionality without changing existing code.
 * 3. Liskov Substitution Principle (LSP): Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In other words, subclasses should be able to stand in for their parent classes without causing unexpected behavior.
 * 4. Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use. This means that you should create small, specific interfaces rather than large, general-purpose ones.
 * 5. Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces). This principle encourages the use of dependency injection and promotes loose coupling between components.
 */
@SpringBootApplication
public class SolidPrinciplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolidPrinciplesApplication.class, args);
	}
}
