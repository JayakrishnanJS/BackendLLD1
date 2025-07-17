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

//      1. Filter even numbers and collect sorted list
//      - filter is an intermediate method: returns back stream object
//      - intermediate : Apply as many intermediate operations as much required
//      - collect : terminal method : helps to close the stream and get some data back
        List<Integer> l2 =
                stream
                .filter((x) -> { return x % 2 == 0;})
                .sorted()
                .collect(Collectors.toList());

        System.out.println(l2);

//      - multiple terminal methods can't be invoked on the same stream
//      - once you invoke a terminal, the stream is closed

//      - map(argument) -> transforms into something else using the logic mentioned
//      - filter the even data and sort, for every element get it's square

//      2. Map to squares after filtering and sorting
         List<Integer> l3 =
                 list.stream()
                        .filter((x) -> { return x  % 2 == 0;})
                        .sorted()
                        .map((x) -> x * x)
                        .collect(Collectors.toList());

        System.out.println(l3);

//      3. Distinct squares
        List<Integer> l4 =
                list.stream()
                        .filter((x) -> { return x  % 2 == 0;})
                        .sorted()
                        .map((x) -> x * x)
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(l4);

//      4. Demonstrate laziness and short-circuiting with findAny()
        Optional<Integer> l5 =
                list.stream()
                        .filter((x) -> {            // Filter (with debug)
                            System.out.println("Filtering :" + x);
                            return x  % 2 == 0;}
                        )
                        .map((x) -> {                 // Map (with debug)
                            System.out.println("Mapping : " + x);
                            return x * x;
                        })
                        .sorted()
                        .distinct()
                        .findAny(); // Terminal: short-circuit
        // after reaching terminal method, intermediate methods are run based on optimization.
        // for e.g. if sorted() is removed, there is no need to do complete mapping, and system won't do
        // findAny() - do filtering first, then after mapping for the first value of filtered x,
        // it outputs this first mapped x

        Integer ans = null;
        if(l5.isEmpty()){
            System.out.println("No element is present in the output");
        }
        ans = l5.get();

//      - in a scenario where filter filters out all elements, findAny should return null
//      - Optional helps you handle null in a much better manner
    }
}

// test (Integer t) {
// matches the testing logic
// }
