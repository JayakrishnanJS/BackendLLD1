package StreamsLambdasAndExceptions;

import java.io.FileNotFoundException;

public class Student {
    static Integer findByRollNumber(int x){
        return  1/0;
    }

    // Checked exceptions - These are exceptions that inherit from `java.lang.Exception` but not from `RuntimeException`
    // the Java compiler enforces that these exceptions must either be handled using a
    // `try-catch` block or declared using the `throws` keyword in the method signature.
    static void find(int x) throws FileNotFoundException {
        if(x % 2 == 0){
            throw new ArithmeticException();
        } else if (x % 3 == 0){
            throw new NullPointerException();
        } else if (x % 5 == 0){
            throw new FileNotFoundException();
        }
    }

    // Stack Overflow Error - due to infinite recursion
    static void findAgain(int x){
        findAgain(x * 2);
    }

    // Unchecked exceptions (runtime exceptions)- These are exceptions that inherit from `RuntimeException`
    // The Java compiler does not enforce any requirement to declare them with `throws`, nor does it require handling them with `try-catch`.
    // custom run time exception by creating a class
    static void myException(){
        throw new MyOwnException("This is my own exception");
    }
}

// throws - Used in the method signature to declare the exceptions that a method might throw.
// the `throws` keyword is not required for runtime exceptions (also known as unchecked exceptions)
// throw - Used to explicitly throw an exception within the body of a method or a block of code.