package Concurrency3.AdderSubtractorSyncMethods;

public class Value {
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public synchronized void incrementBy(int x){
        val += x;
    }
    // the method is declared as synchronized, which ensures that only one thread
    // can execute it on the same object at any given time. The action modifies the
    // value of `val` safely across multiple threads by preventing race conditions.
    // The `adder` and `subtractor` methods now delegate the actual modification of
    // `val` to the `incrementBy` method. Instead of duplicating similar increment/decrement
    // logic, you move this logic into one shared, reusable function.
    // This reduces redundancy, making the code easier to maintain.

}
