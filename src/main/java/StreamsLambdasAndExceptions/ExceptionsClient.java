package StreamsLambdasAndExceptions;

import java.io.FileNotFoundException;

import static StreamsLambdasAndExceptions.StudentExceptionDemo.*;

public class ExceptionsClient {
    public static void main(String[] args) //throws FileNotFoundException
    {
    // 1. Checked Exceptions: Exception handling is mandatory
        // 1. compiler checks exception if the method and its implemented(here main) methods throws the same exception
        //findWithThrows(5);
        // 2. or handle exception using try-catch block in the Client where the method throws exception in its class.
        try{
            StudentExceptionDemo.findWithThrows(5);
        } catch (FileNotFoundException e) {
            System.out.println("File Not found! Please check if file even exists or not");
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception is coming, it's my mistake because of which it is coming. Please don't fire me");
        } catch (RuntimeException e){
            System.out.println("Handling this exception");
        }catch (Exception e){
            System.out.println("Handling this exception");
            // if this comes as first catch, compile error will be shown bcz it is general, and it
            // catches everything; all exceptions in below catches become not reachable.
            // => whenever you are writing multiple catches, specific exception should come first, general should come later on.
        }

        // 3. or handle exception using try-catch block in the method where the method throws exception in its code block.
        findWithTryCatch(5);

        // Note: In all 3 cases, FileNotFoundException is the only checked exception. Others can also be not handled.

//      - Run time polymorphism, Exception being the parent can take any child
//        Exception ex = new FileNotFoundException();
//        ex = new NullPointerException();
//        ex = new IOException();
//        ex = new ArithmeticException();

    // 2. Unchecked Exceptions: Exception can or cannot be handled. Handle only if it is necessary.
        // 1. method throws runtime exception:
        uncheckedMethodWithRuntimeException();
        // 2. no exception handling in client or method:
        uncheckedMethodWithoutRuntimeException();
        // 3. exception handling in client and method:
        try {
            uncheckedMethodWithRuntimeException();
        }catch (Exception e){
            System.out.println("Caught Exception: " + e.getMessage());
        }
        // 3. exception handling in client only:
        try {
            uncheckedMethodWithoutRuntimeException();
        }catch (NullPointerException e){
            System.out.println("Caught Exception: " + e.getMessage());
        }


    // 3. Custom exception
        try {
            myException();
        } catch (MyOwnException e) {
            System.out.println("Caught MyOwnException: " + e.getMessage());
        }

    // Checked exception not handled scenario: causes error, fatal. Kill process to recover from it.
        StudentExceptionDemo.findAgain(5);
    }
}
