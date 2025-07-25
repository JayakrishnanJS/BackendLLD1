package AccessModifier;

public class finalMethodCanBeOverloaded extends StaticFinalExample {

    public finalMethodCanBeOverloaded(int id) {
        super(id);
    }

    private void display(int x){ // Overloading is allowed
        System.out.println("Overloaded Method");
    }

}
