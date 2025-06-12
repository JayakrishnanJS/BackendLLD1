package Concurrency2.AdderSubtractor;

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
// we are not passing integers to add and subtract directly since those are pass
// by Value and they works without Synchronization. We are passing Objects with integer instances so that we are mimicing pass by
// Reference.