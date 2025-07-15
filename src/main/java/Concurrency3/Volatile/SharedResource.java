package Concurrency3.Volatile;

public class SharedResource {
    volatile boolean flag;
    SharedResource(){
        flag = false;
    }
    public void toggleFlag() {
        flag = !flag;
    }
    public boolean getFlag() {
        return flag;
    }
}
