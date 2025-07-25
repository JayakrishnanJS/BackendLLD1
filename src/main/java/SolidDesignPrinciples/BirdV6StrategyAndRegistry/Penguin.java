package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class Penguin extends Bird {
//    @Override
//    public void fly() {
//        // 1. Leave it empty
//        // 2. Throw an exception
//        // 3. System.out.println("I can't fly");
//    }
        public Penguin() {
            super(FlyingBehaviourType.NONE); // Pass the type to parent
        }

    @Override
    public void makeSound() {

    }
}
