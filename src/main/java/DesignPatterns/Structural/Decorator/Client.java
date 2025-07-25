package DesignPatterns.Structural.Decorator;

import DesignPatterns.Structural.Decorator.Addons.ChocoChip;
import DesignPatterns.Structural.Decorator.Addons.Milk;
import DesignPatterns.Structural.Decorator.Addons.Soy;

public class Client {
    public static void main(String[] args) {
        Beverage b = new Decaf();
        System.out.println("Decaf -> Rs " + b.getCost());
        b.getDescription();
        // Dynamic Composition - This line wraps a beverage (b), which has already been declared as a Decaf beverage, with Milk and ChocoChip addons.
        Beverage b1 = new ChocoChip(new Milk(b));
        System.out.println("Decaf with milk and choco chip -> Rs " + b1.getCost());

        /* Sequence diagram:
                 Client -> Decaf : Constructor (Create Decaf)
                 Client -> Milk : Constructor (Milk wraps Decaf)
                 Client -> ChocoChip : Constructor (ChocoChip wraps Milk)
        1. What the Code Does:
            - This line wraps a beverage (b), which has already been declared as a Decaf beverage, with Milk and ChocoChip addons.
            - Specifically:
            - First, the Milk decorator is applied to b (Decaf), meaning milk is added to the Decaf drink.
            - Then, the ChocoChip decorator wraps the Milk-decorated object, meaning chocolate chips are added on top of
              the milk-with-decaf drink.

        2. Object Composition (Dynamic Behavior):
            - new Milk(b):
                - A new Milk object is created, wrapping the b object (which is a Decaf).

            - new ChocoChip(new Milk(b)):
                - A new ChocoChip object is created, wrapping the previously created Milk object.

            - This forms a chain where the ChocoChip object delegates its operations to the Milk object, which further
              delegates to the Decaf object (b).

        3. Behind the Scenes:
            - Every Addon in this program extends the Addon abstract class (which in turn extends Beverage) and dynamically
              "decorates" a Beverage instance by adding its specific behaviors (i.e., describing or adding cost).
            - Each decorator (Milk, ChocoChip, etc.) keeps a reference (beverage) to the object it wraps and forwards
              method calls to that wrapped object. It may also modify the result.

        4. Context from the Code:
            - The beverage (b) is of type Decaf, and its base cost is 50 (from Decaf.getCost()).
            - Milk adds 12 to the cost (Milk.getCost()).
            - ChocoChip adds 2 to the cost (ChocoChip.getCost()).
            - Thus, when b1.getCost() is later invoked, the total cost for the wrapped object (Decaf + Milk + ChocoChip)
              will be calculated dynamically.
        */
        b1 = new Soy(b1);
        b1 = new ChocoChip(b1);

        System.out.println("Decaf with milk, soy and double choco chip -> Rs " + b1.getCost());
        b1.getDescription();
    }
}

/*
    We need to have various combinations of beverage using various ingredients. Among standard beverages,
    we have option for various addons.
    1. If we are adding Addon methods to each Beverage subclasses, it violates SRP
    2. If we want to have multiple addons in a Beverage, we can't extend an addon since it is final => if we are
       creating various classes for each combination(e.g.Decaf with Milk and Soy, HouseBlend with Milk and
       Whip), it violates OCP since our standalone addon classes are not extensible and leads to Class explosion

    Pblm: Static Inheritance -> We can't add new functionality to an existing class at runtime.

    Soln: - The Decorator pattern allows us to add new functionality to an existing object without altering its structure.
            The Decorator pattern is also known as Wrapper.
          - It uses Dynamic Composition -> create a new class that will contain references to the existing classes and
            delegate the calls to the existing classes.
            The client can wrap a Decaf in Addon-derived objects—and even stack multiple layers—without creating a
            combinatorial explosion of subclasses.
          - A wrapper is an object that links to a target object. It defines the same set of methods as the target and
            delegates all incoming requests to it. However, the wrapper may modify the behavior by performing additional
            actions either before or after forwarding the request. The wrapper implements the same interface as the wrapped object.

   Impl: - The decorator pattern is implemented with the following steps:
            1. Common Product Interface - Common Interface for both wrappers and wrapper objects(adheres to same contract).
                                          parent for all concrete beverages -> Beverage(abstract)
            2. Concrete Product         - Create a concrete product class that implements the common interface
                                          and represents the basic behavior of the wrapped object.
                                          -> Decaf, HouseBlend, DarkRoast
            3. Base Decorator           - Create a base decorator class that implements the common interface
                                          and contains a field for storing a reference to a wrapped object.
                                          Addon -> Holds a reference to Beverage
            4. Concrete Decorators      - Create classes that extend the base decorator classes and add additional behavior
                                          to the wrapped object.
            5. Client                   - The client code works with all objects using the common interface. This way
                                          it can stay independent of the concrete classes of objects it works with.
                                            a. Instantiates a base Beverage
                                            b. Wraps it with one or more Addon decorators
                                            c. Calls getDescription() and cost() on the final chain
   Advantages of the Decorator Pattern
        - Object behavior can be extended at runtime by wrapping an object with one or several
          decorators without creating a new subclass.
        - Runtime configuration of an object is possible.
        - New behavior can be added to an object without changing its code.
        - SRP is respected by encapsulating the added behavior in separate classes.
*/
