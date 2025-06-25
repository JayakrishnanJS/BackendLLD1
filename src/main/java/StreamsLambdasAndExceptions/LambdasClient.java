package StreamsLambdasAndExceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdasClient {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Hello World"); // definition
        };

        Runnable task2 = () -> System.out.println("Hello World2");

        Thread t = new Thread(task);
        t.start();

        List<Integer> l =new ArrayList<>();
        l.add(31);
        l.add(22);
        l.add(13);
        l.add(46);
        l.add(5);
//        even numbers should come first, also higher magnitude comes first
//        Instead of separate class, we use lambda expression

        // (a, b) +ve result => b comes before a
        // (a, b) -ve result => a comes before b
        // (a, b) 0  => a = b
        Collections.sort(l, (a , b) -> {
            if(a % 2 == b % 2){ // either both even or both odd - return higher magnitude
                return b - a; // b - a > 0 => b first, b - a < 0 => a first
            } else if (a % 2 == 0){ // a being even, b is odd - return even -> a
                return -1;
            } else {
                return 1; // if a being odd, b is even - return even -> b
            }
        });

//        () -> {}

    }
}
// with functional interfaces, instead of creating a class, we can provide
// definition of the method via lambdas

// we are not mentioning for which method we are creating the definition, if the interface has 2 or more methods,
// there will be a confusion that where this definition to be implemented
// => this works only with functional interfaces where there is a single method
// class R1 {
//    run() {
//        definition of method
//    }
// }