package StreamsLambdasAndExceptions;

public class MyOwnException extends RuntimeException {
    public MyOwnException(String message) {
        super(message);
    }
    // this is a constructor that is available in RuntimeException class to throw a detailed message
}
