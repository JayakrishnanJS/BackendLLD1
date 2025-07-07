package SOLID.BirdV1;

import java.util.List;

public class Client {

    public static void doSomething(List<Bird> birds){
        for(Bird bird : birds) {
            bird.fly();
        }
    }

    public static void main(String[] args) {

    }
}

/*
1. Fix SRP
    Bird is now abstract class, and it uses inheritance(subclasses) to have single and specific
    responsibility for each bird class and polymorphism(overriding) to use common methods but with
    specific implementation.
2. Fix OCP
    new Bird, say Crow, can be added(extension of code) without modifying any existing classes.
*/

/*
- Violates LSP: a Penguin is forced to fly. This breaks the LSP because the `Penguin` subclass
  cannot properly substitute the `Bird` class - it alters the program's correctness in contexts
  where `Bird.fly()` is expected.

* */
