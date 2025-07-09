package DesignPatterns.Builder.V0;

public class Client0 {
    public static void main(String[] args) {
        SoldItem item1 = new SoldItem(); // no data
        SoldItem item2 = new SoldItem(101); // only ID
        SoldItem item3 = new SoldItem(102, "Mouse");
        SoldItem item4 = new SoldItem(103, "Keyboard", 1200);
        SoldItem item5 = new SoldItem(104, "Monitor", 8000, 2);
        SoldItem item6 = new SoldItem(105, "Tablet", 15000, 1, true);
        SoldItem item7 = new SoldItem(106, "Laptop", 75000, 1, true, 5.0);
        SoldItem item8 = new SoldItem(107, "Phone", 30000, 1, true, 10.0, "Credit Card");
        System.out.println();
    }
}
/*
    1. Code Duplication: Each constructor repeats field assignments:
                        this.id = id;
                        this.name = name;
                        ...
    2. Hard to read and maintain

    3. Hard to validate or add logic: There is no relation between various constructors, so each one needs to
                                      be updated when there is a change or addition.
    4. No centralized initialization logic : parameters of constructor calls where all parameters are not initialized
                                             gets initialized with java defaults


*/