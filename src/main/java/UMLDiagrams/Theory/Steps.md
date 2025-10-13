# UML Class Diagram Design SOP for LLD Interviews

This document provides a Standard Operating Procedure (SOP) for systematically creating a UML class diagram from a one-line problem statement, specifically for Low-Level Design (LLD) interviews.

## 📜 Core Philosophy: Clarify, Don't Assume

A vague, one-line prompt is a test of your ability to handle ambiguity. Your first and most critical step is **always** to ask clarifying questions to establish a concrete scope.

> **Example Interaction:**
>
> **Interviewer:** "Design a parking lot."
>
> **You:** "Great. To start, I'd like to define the scope. Are we designing for a specific type of vehicle (cars, bikes, trucks)? Should the system handle payments? Does it need to support multi-level lots and different types of parking spots (compact, regular, handicapped)?"

By clarifying, you transform the problem from abstract to a manageable set of requirements.

---

## ⚙️ The 5-Step Method

Follow these steps methodically to deconstruct the problem and build the diagram.

### Step 1: Scope Clarification & Requirement Gathering

1.  **Identify Core Features:** What is the absolute minimum functionality?
2.  **Identify Actors/Users:** Who will be using the system? (e.g., Customer, Admin).
3.  **State Assumptions:** Clearly state what you are including and, more importantly, what you are excluding (e.g., "I will assume we don't need to handle user authentication for this initial design.").

### Step 2: Identify Core Entities (The Noun Approach)

Scan your clarified requirements and list all the major **nouns**. These are your candidate classes.

* **Example (`BookMyShow`):** `User`, `Movie`, `Cinema`, `Hall`, `Show`, `Seat`, `Booking`, `Payment`.

### Step 3: Detail Classes (Attributes & Methods)

For each class, define its properties and behaviors.

1.  **Attributes (Properties):** What data does the class hold? (e.g., `Movie` has `title`, `duration`).
2.  **Methods (Behaviors):** What actions can the class perform? (e.g., `Booking` can `makePayment()`).
3.  **Use Enums:** For fixed sets of constants, use Enums to show strong design skills.
    * `SeatStatus`: { `AVAILABLE`, `BOOKED`, `LOCKED` }
    * `PaymentStatus`: { `PENDING`, `SUCCESS`, `FAILED` }

### Step 4: Establish Relationships & Multiplicity

Connect your classes using the correct OOP relationships. Define how many objects are involved.

* **Ask "is-a" or "has-a":**
    * **Inheritance (is-a):** `Car` is a `Vehicle`.
    * **Composition (strong has-a):** A `House` has `Rooms`. The room cannot exist without the house.
    * **Aggregation (weak has-a):** A `Team` has `Players`. Players can exist without the team.
    * **Association:** `Student` is associated with a `Teacher`.
* **Define Multiplicity:**
    * `1` (Exactly one)
    * `*` (Many)
    * `0..1` (Zero or one)
    * `1..*` (One or more)
    * **Example:** One `Cinema` has `1..*` `Halls`.

### Step 5: Refine and Draw

Elevate your design with advanced concepts before drawing the final diagram.

* **Interfaces:** Use for behavior contracts. (e.g., a `PaymentGateway` interface allows for different payment methods like `CreditCardPayment` or `PayPalPayment`).
* **Abstract Classes:** Use for shared structure and behavior among related classes (e.g., an abstract `User` class with `Customer` and `Admin` subclasses).
* **Draw the Diagram:** Assemble all the pieces using standard UML notation.

---

## 🚀 Example Walkthrough: "Design BookMyShow"

1.  **Scope:** Core movie ticket booking flow for a customer.
2.  **Core Entities (Nouns):**
    * `User`, `Movie`, `City`, `Cinema`, `Hall`, `Show`, `Seat`, `Booking`, `Payment`.
3.  **Key Relationships:**
    * `Cinema` ---◆ `Hall` (Composition, 1 to 1..*)
    * `Hall` ---◆ `Seat` (Composition, 1 to *)
    * `Show` --- `Movie` (Association, * to 1)
    * `Booking` --- `User` (Association, * to 1)
    * `Booking` --- `Show` (Association, * to 1)
    * `Booking` --- `Seat` (Association, 1 to 1..*)
4.  **Refinements:**
    * Introduce `BookingStatus` and `SeatStatus` Enums.
    * Use a `PaymentGateway` interface to handle different payment methods.

---

## ⭐ Interview Best Practices

* **Think Aloud:** Your thought process is more valuable than the final diagram. Explain your choices.
* **Start Simple, Then Elaborate:** Get the core classes and relationships down first. Then, add details like enums, interfaces, and multiplicities.
* **Justify Your Decisions:** Be prepared to explain *why* you chose Composition over Aggregation or why an interface is a good design choice.
* **Use the Whiteboard Effectively:** Structure your space into sections: `Scope`, `Classes`, `Relationships`, and `Final Diagram`.