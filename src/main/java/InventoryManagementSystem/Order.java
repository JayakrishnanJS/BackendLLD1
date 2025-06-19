package InventoryManagementSystem;

public class Order implements Comparable<Order>{
    private String OrderID;
    private boolean isExpress;

    public Order(String OrderID, boolean isExpress) {
        this.OrderID = OrderID;
        this.isExpress = isExpress;
    }
    public String getOrderID() {
        return OrderID;
    }
    public boolean isExpress() {
        return isExpress;
    }
    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }
    public void setExpress(boolean isExpress) {
        this.isExpress = isExpress;
    }

    @Override
    public int compareTo(Order o) {
        if(this.isExpress){
            return -1;
        }else if(o.isExpress){
            return 1;
        }
        return 0;
    }
}
