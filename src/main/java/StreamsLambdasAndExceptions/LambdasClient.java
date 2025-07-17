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

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        List<Integer> l =new ArrayList<>();
        l.add(31);
        l.add(22);
        l.add(13);
        l.add(46);
        l.add(5);
    // Given a list of integers. Sort even numbers first, then followed by odd numbers.
    // Within even and odd arrange them with higher magnitude first
        // (a, b) +ve result => treat a > b
        // (a, b) -ve result => treat a < b
        // (a, b) 0  => a = b
        Collections.sort(l, (a , b) -> {
            if(a % 2 == b % 2){ // either both even or both odd - return higher magnitude
                return b - a; // b > a => b - a = +ve => b first, b < a => b - a = -ve =>  a first
            } else if (a % 2 == 0){ // a being even, b is odd => +ve => return a
                return -1;
            } else {
                return 1; // if a being odd, b is even => -ve => return b
            }
        });
        System.out.println(l);
//        () -> {}

    }
}
// with functional interfaces, instead of creating a class, we can provide
// definition of the method via lambdas.
// It is a way to pass behavior as an argument to a method invocation and to define a method without name

// functional interface is an interface having only one abstract method.
// It is a way to define a contract for behavior of an argument to a method invocation.

// we are not mentioning for which method we are creating the definition, if the interface has 2 or more methods,
// there will be a confusion that where this definition to be implemented
// => this works only with functional interfaces where there is a single method
// class R1 {
//    run() {
//        definition of method
//    }
// }

// lambda expressions are also called anonymous functions. Syntax can be:
// (parameters) -> expression
// (parameters) -> { statements }
// parameters - can be empty or many
// -> operator separates parameter list from lambda body.
// lambda body -code that implements the functional interface or its abstract method