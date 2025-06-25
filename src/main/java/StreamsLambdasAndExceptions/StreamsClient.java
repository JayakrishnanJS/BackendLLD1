package StreamsLambdasAndExceptions;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsClient {
    public static void main(String[] args){
        List<Integer> list = List.of(2, 72, 3, 4, 6, 6, 62, 10, 1, 9, 8, 9, 12);

        Stream<Integer> stream = list.stream();

//        filter only even numbers, reject all odd numbers
//        filter is an intermediate method: returns back stream object
//        intermediate : Apply as many intermediate operations as much required
//          collect : terminal method : helps to close the stream and get some data back
        List<Integer> l2 =
                stream
                .filter((x) -> { return x  % 2 == 0;})
                .sorted()
                .collect(Collectors.toList());

        System.out.println(l2);
        //        multiple terminal methods can't be invoked on the same stream
//        once you invoke a terminal, the stream is closed

//        the stream has already been operated upon or closed

//        stream.filter((x) -> x % 2 != 0);
//     map(argument) -> transforms into something else using the logic mentioned
//        filter the even data and sort, for every element get it's square

         List<Integer> l3 =
                 list.stream()
                        .filter((x) -> { return x  % 2 == 0;})
                        .sorted()
                        .map((x) -> x * x)
                        .collect(Collectors.toList());

        System.out.println(l3);

        List<Integer> l4 =
                list.stream()
                        .filter((x) -> { return x  % 2 == 0;})
                        .sorted()
                        .map((x) -> x * x)
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(l4);

        Optional<Integer> l5 =
                list.stream()
                        .filter((x) -> {
                            System.out.println("Filtering :" + x);
                            return x  % 2 == 0;}
                        )
                        .map((x) -> {
                            System.out.println("Mapping : " + x);
                            return x * x;
                        })
                        .sorted()
                        .distinct()
                        .findAny();
        // after reaching terminal method, intermediate methods are run based on optimization.
        // for e.g. if sorted() is removed, there is no need to do complete mapping
        // findAny() - do filtering first, then after mapping for first value of filtered x,
        // it outputs this first mapped x

        Integer ans = null;
        if(l5.isEmpty()){
            System.out.println("No element is present in the output");
        }
        ans = l5.get();

//        in a scenario where filter filters out all elements, findAny should return null
//        Optional helps you handle null in a much better manner

//        Student.findByRollNumber(5);
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
        // Run time polymorphism, Exception being the parent can take any child
//        Exception ex = new FileNotFoundException();
//        ex = new NullPointerException();
//        ex = new IOException();
//        ex = new ArithmeticException();

        Student.findAgain(5); // causes error, fatal. Kill process to recover from it.
    }
}

// test (Integer t) {
// matches the testing logic
// }
