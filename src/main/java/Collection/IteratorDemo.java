package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
    public class IteratorDemo {
        public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
            Iterator<Integer> iterator = numbers.iterator();
            // Using hasNext() and next() methods
            while (iterator.hasNext()) { // Returns true if the iteration has more elements.
                Integer number = iterator.next(); // Returns the next element in the iteration.
                System.out.println("Number: " + number);
            // Using remove() method (optional operation)
                iterator.remove(); // Removes the last element returned by next() from the underlying collection
            }
            System.out.println("Updated List: " + numbers);
        }
    }