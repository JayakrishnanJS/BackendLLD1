package DesignPatterns.Builder.V1;

public class Client1 {
    public static void main(String[] args) {
        SoldItem item0 = new SoldItem();
        SoldItem item1 = new SoldItem(101);
        SoldItem item2 = new SoldItem(102, "Mouse");
        SoldItem item3 = new SoldItem(103, "Keyboard", 1200);
        SoldItem item4 = new SoldItem(104, "Monitor", 8000, 2);
        SoldItem item5 = new SoldItem(105, "Tablet", 15000, 1, true);
        SoldItem item6 = new SoldItem(106, "Laptop", 75000, 1, true, 5.0);
        SoldItem item7 = new SoldItem(107, "Phone", 30000, 1, true, 10.0, "Credit Card");
        System.out.println();
    }
}
/* Telescoping Construcor chaining (i.e., calling one constructor from another using this(...)) solves
            1. Code dupliation
            2. Hard to validate or add logic
            3. Hard to read and maintain(partially)

   But it has the following issues:
            1. Ambiguity Between Constructors: When two constructors have similar parameter types, Java can get confused,
                                               or it may call the wrong constructor by mistake.
                         public SoldItem(int id, int price) { ... }
                         public SoldItem(int price, int quantity) { ... }
                         SoldItem soldItem = new SoldItem(100, 200);
               which one does it pick?

             2. Scalability / Constructor Explosion: Telescoping still requires one constructor per combination, so you hit
                                                     the same scalability issue (exponential combinations).

             3. Rigid Parameter Order: You can't skip optional parameters without creating more constructor versions.
                         new SoldItem(id, paymentMethodOnly);

             4. Telescoping constructor anti-pattern: hard to read and maintain when too many constructors
             5. Lack of Clarity with Defaults: We are forced to hardcode default values in telescoping chains, which
                                               might spread default logic across constructors and make it inconsistent.
                                               We might accidentally apply inconsistent defaults across constructors.

 */