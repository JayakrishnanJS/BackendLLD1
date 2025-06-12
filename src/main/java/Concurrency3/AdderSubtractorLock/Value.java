package Concurrency3.AdderSubtractorLock;

public class Value {
    private int val; // The integer value to be shared and updated by threads

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
// Represents the shared resource with a value that multiple threads will read and modify.
