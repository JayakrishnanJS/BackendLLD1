package DesignPatterns.Creational.PrototypeAndRegistry;

public class IntelligentStudent extends Student {
    private int iq;

    public IntelligentStudent() {

    }

    public IntelligentStudent(int gradYear, int id, String name, double psp, int iq) {
        super(gradYear, id, name, psp);
        this.iq = iq;
    }

    // 1. copy constructor to create a clone of intelligent student from an existing intelligent student obj or template
    public IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }

    // 2. copy constructor to create a clone of intelligent student from an existing normal student obj or template
    // iq can be set after creating clone
    public IntelligentStudent(Student student) {
        super(student);
        iq = 120;// set an average iq for intelligent student or it will be 0 by default
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public IntelligentStudent copy(){
        return new IntelligentStudent(this);
    }
}
/*
Java's overload resolution.
When the compiler encounters new IntelligentStudent(this), it follows these steps:
1. Determine the type of the argument: Inside the IntelligentStudent class, the compile-time type of this
   is IntelligentStudent.
2. Find all applicable constructors: The compiler looks for all IntelligentStudent constructors that can
   accept an argument of type IntelligentStudent.
        public IntelligentStudent(IntelligentStudent intelligentStudent) is applicable because the parameter
        type is an exact match.
        public IntelligentStudent(Student student) is also applicable because IntelligentStudent is
        a subclass of Student (polymorphism).
3. Choose the most specific constructor: The Java Language Specification requires the compiler to select
   the most specific method or constructor from the set of applicable ones.
A constructor taking a parameter of type IntelligentStudent is considered more specific than one
taking its superclass, Student
 */