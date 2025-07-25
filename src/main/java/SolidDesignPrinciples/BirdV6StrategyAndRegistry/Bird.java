package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public abstract class Bird {
    private String name;
    private int age;
    private int numberOfLegs;
    private String type;
    // Association with FlyingBehaviourType
    protected FlyingBehaviourType flyingBehaviourType;
    protected FlyingBehaviour flyingBehaviour; // bird can have flyingBehaviour as None, so all birds inherit

    public Bird(FlyingBehaviourType flyingBehaviourType) {
        this.flyingBehaviourType = flyingBehaviourType;
        this.flyingBehaviour = FlyingBehaviourFactory.createFlyingBehaviourByType(flyingBehaviourType);
    }

//    public void swim(){}

    public FlyingBehaviourType getFlyingBehaviourType() {
        return flyingBehaviourType;
    }

    public void setFlyingBehaviourType(FlyingBehaviourType flyingBehaviourType) {
        this.flyingBehaviourType = flyingBehaviourType;
    }

    public void eat(){
        System.out.println("Bird : " + name + " is eating!");
    }

//    public abstract void fly();

//    public void makeSound(){
//        // makeSound function will have implementation of all the sounds of every possible type of bird
//        if(type.equals("Peacock")){
//            System.out.println("EWEWEWEEWEWEWEWEW");
//        } else if (type.equals("Crow")){
//            System.out.println("COW COW COW");
//        } else if (type.equals("new Type")){
//            System.out.println("New Type");
//        }
//    }
    public abstract void makeSound();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean canFlyOrNot(){
        return flyingBehaviourType != FlyingBehaviourType.NONE;
    }
}
