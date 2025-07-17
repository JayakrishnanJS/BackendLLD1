package StreamsLambdasAndExceptions;

import java.io.FileNotFoundException;

import static StreamsLambdasAndExceptions.Student.myException;

public class ExceptionsClient {
    public static void main(String[] args) {

        // compiler checks exception if the method and its implemented(here main) methods throws exception, else use try-catch mechanism
        try{
            Student.find(5);
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
//      - Run time polymorphism, Exception being the parent can take any child
//        Exception ex = new FileNotFoundException();
//        ex = new NullPointerException();
//        ex = new IOException();
//        ex = new ArithmeticException();

        // Custom exception
        try {
            myException();
        } catch (MyOwnException e) {
            System.out.println("Caught MyOwnException: " + e.getMessage());
        }

        // causes error, fatal. Kill process to recover from it.
        Student.findAgain(5);
    }
}
